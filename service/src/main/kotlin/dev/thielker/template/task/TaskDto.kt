package dev.thielker.template.task

import dev.thielker.template.task.entity.Task
import java.time.LocalDateTime

/*
* Why do we use a Dto?
*
* In this sample, the Dto is the same as the entity stored in the database.
* This usually is not the case. The Dto is a representation of the entity that is exposed to the outside world.
* It is used to hide internal or sensitive information. For example, the database internal id should not be exposed
* since it is a sequential number and can be used to guess the number of entries in the database. Instead a randomly
* created String should be used as a public id.
*
* Another example are users in a system. Even though each user has an email, this email should not be exposed to every
* client accessing the users profile. Instead of sending the entity, a Dto can be used to hide (not container) the email.
*
* Since this is a very basic sample, neither the publicId generation nor samples of hiding sensitive information are
* implemented. The Dto is only used to show how to use Dos in general.
*
* */

class TaskDto(
    val id: Long?,
    val name: String,
    val description: String,
    val checked: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {

    companion object {
        fun from(task: Task): TaskDto {
            return TaskDto(
                id = task.id,
                name = task.name,
                description = task.description,
                checked = task.checked,
                createdAt = task.createdAt,
                updatedAt = task.updatedAt,
            )
        }
    }
}
