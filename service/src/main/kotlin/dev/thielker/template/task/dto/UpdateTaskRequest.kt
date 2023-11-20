package dev.thielker.template.task.dto

data class UpdateTaskRequest(
    val id: Long?,
    val name: String,
    val description: String,
    val checked: Boolean,
)
