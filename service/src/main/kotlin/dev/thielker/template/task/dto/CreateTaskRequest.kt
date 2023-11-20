package dev.thielker.template.task.dto

data class CreateTaskRequest(
    val name: String,
    val description: String,
    val checked: Boolean,
)
