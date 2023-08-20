package dev.thielker.template.task.control

import dev.thielker.template.task.TaskDto
import dev.thielker.template.task.entity.Task
import jakarta.enterprise.context.Dependent
import jakarta.transaction.Transactional

@Dependent
class TaskService {

    @Transactional
    fun getAll(): List<TaskDto> {
        val list = Task.listAll()
        return list.map { TaskDto.from(it) }
    }

    @Transactional
    fun getByPublicId(id: Long): TaskDto? {
        val task = Task.findById(id)
        return task?.let { TaskDto.from(it) }
    }

    @Transactional
    fun create(task: Task): TaskDto {
        task.persist()
        return TaskDto.from(task)
    }

    @Transactional
    fun update(task: Task): TaskDto {

        if (task.id == null) throw IllegalArgumentException("Task id must not be null")

        Task.findById(task.id!!)?.let {
            it.apply {
                name = task.name
                description = task.description
                checked = task.checked
            }
            return TaskDto.from(it)
        }
        throw IllegalArgumentException("Task with id ${task.id} not found")
    }

    @Transactional
    fun delete(id: Long) {
        Task.deleteById(id)
    }
}
