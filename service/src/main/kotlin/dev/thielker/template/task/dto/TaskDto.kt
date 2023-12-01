package dev.thielker.template.task.dto

import java.time.LocalDateTime

data class TaskDto(
    val id: Long,
    val name: String,
    val description: String,
    val checked: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
