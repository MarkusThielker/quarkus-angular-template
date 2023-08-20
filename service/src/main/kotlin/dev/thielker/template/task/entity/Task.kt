package dev.thielker.template.task.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Task : PanacheEntity() {

    companion object : PanacheCompanion<Task>

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description")
    lateinit var description: String

    @Column(name = "checked", nullable = false)
    @ColumnDefault("false")
    var checked: Boolean = false

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    lateinit var createdAt: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    lateinit var updatedAt: LocalDateTime
}
