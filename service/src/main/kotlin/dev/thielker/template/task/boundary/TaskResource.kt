package dev.thielker.template.task.boundary

import dev.thielker.template.task.TaskDto
import dev.thielker.template.task.control.TaskService
import dev.thielker.template.task.entity.Task
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

    @GET
    fun getAll(): List<TaskDto> {
        return taskService.getAll()
    }

    @GET
    @Path("/{id}")
    fun getByPublicId(@PathParam("id") id: Long): TaskDto? {
        return taskService.getByPublicId(id)
    }

    @POST
    fun create(task: Task): TaskDto {
        return taskService.create(task)
    }

    @PUT
    fun update(task: Task): TaskDto {
        return taskService.update(task)
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) {
        taskService.delete(id)
    }
}
