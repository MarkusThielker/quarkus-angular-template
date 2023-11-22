package dev.thielker.template.task.control

import dev.thielker.template.task.entity.Task
import jakarta.enterprise.context.Dependent
import jakarta.transaction.Transactional

@Dependent
class TaskService {

    @Transactional
    fun getAll(): List<Task> {
        return Task.listAll()
    }

    @Transactional
    fun getByPublicId(id: Long): Task? {
        return Task.findById(id)
    }

    @Transactional
    fun create(task: Task): Task {
        task.persist()
        return task
    }

    @Transactional
    fun update(task: Task): Task {

        if (task.id == null) throw IllegalArgumentException("Task id must not be null")

        Task.findById(task.id!!)?.let {
            return it.apply {
                name = task.name
                description = task.description
                checked = task.checked
            }
        }
        throw IllegalArgumentException("Task with id ${task.id} not found")
    }

    @Transactional
    fun delete(id: Long) {
        Task.deleteById(id)
    }
}
