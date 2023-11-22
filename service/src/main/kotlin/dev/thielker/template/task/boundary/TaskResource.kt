package dev.thielker.template.task.boundary

import dev.thielker.template.task.dto.TaskDto
import dev.thielker.template.task.control.TaskService
import dev.thielker.template.task.dto.CreateTaskRequest
import dev.thielker.template.task.dto.UpdateTaskRequest
import dev.thielker.template.task.mapper.TaskMapper
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/task")
@ApplicationScoped
class TaskResource {

    @Inject
    private lateinit var taskService: TaskService

    @Inject
    private lateinit var taskMapper: TaskMapper

    @GET
    fun getAll(): List<TaskDto> {
        return taskService.getAll().map { taskMapper.toTaskDto(it) }
    }

    @GET
    @Path("/{id}")
    fun getByPublicId(@PathParam("id") id: Long): TaskDto? {
        return taskService.getByPublicId(id)?.let { taskMapper.toTaskDto(it) }
    }

    @POST
    fun create(request: CreateTaskRequest): TaskDto {
        val persisted = taskService.create(taskMapper.toTask(request))
        return taskMapper.toTaskDto(persisted)
    }

    @PUT
    fun update(request: UpdateTaskRequest): TaskDto {
        val persisted = taskService.update(taskMapper.toTask(request))
        return taskMapper.toTaskDto(persisted)
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) {
        taskService.delete(id)
    }
}
