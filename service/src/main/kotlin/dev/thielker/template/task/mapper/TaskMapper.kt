package dev.thielker.template.task.mapper

import dev.thielker.template.task.control.TaskService
import dev.thielker.template.task.dto.CreateTaskRequest
import dev.thielker.template.task.dto.TaskDto
import dev.thielker.template.task.dto.UpdateTaskRequest
import dev.thielker.template.task.entity.Task
import jakarta.enterprise.context.Dependent
import jakarta.inject.Inject

@Dependent
class TaskMapper {

    @Inject
    lateinit var taskService: TaskService

    fun toTask(taskDto: TaskDto): Task {

        if (taskDto.id != null) {
            taskService.getByPublicId(taskDto.id)?.let {
                return it.apply {
                    name = taskDto.name
                    description = taskDto.description
                    checked = taskDto.checked
                }
            }
        }

        return Task().apply {
            id = taskDto.id
            name = taskDto.name
            description = taskDto.description
            checked = taskDto.checked
            createdAt = taskDto.createdAt
            updatedAt = taskDto.updatedAt
        }
    }

    fun toTaskDto(task: Task) = TaskDto(
        id = task.id!!,
        name = task.name,
        description = task.description,
        checked = task.checked,
        createdAt = task.createdAt,
        updatedAt = task.updatedAt,
    )

    fun toTask(request: CreateTaskRequest): Task = Task().apply {
        name = request.name
        description = request.description
        checked = request.checked
    }

    fun toTask(request: UpdateTaskRequest): Task {

        if (request.id != null) {
            taskService.getByPublicId(request.id)?.let {
                return it.apply {
                    name = request.name
                    description = request.description
                    checked = request.checked
                }
            }
        }

        return Task().apply {
            id = request.id
            name = request.name
            description = request.description
            checked = request.checked
        }
    }
}
