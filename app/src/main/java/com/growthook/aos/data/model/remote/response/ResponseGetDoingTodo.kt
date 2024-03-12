package com.growthook.aos.data.model.remote.response

import com.growthook.aos.domain.entity.ActionlistDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetDoingTodo(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<DoingTodo>,
) {
    @Serializable
    data class DoingTodo(
        @SerialName("actionPlanId")
        val actionPlanId: Int,
        @SerialName("content")
        val content: String,
        @SerialName("isScraped")
        val isScraped: Boolean,
        @SerialName("seedId")
        val seedId: Int,
        @SerialName("hasReview")
        val hasReview: Boolean,
    )

    fun toDoingTodo() = data.map { todo ->
        ActionlistDetail(
            todo.actionPlanId,
            todo.content,
            todo.isScraped,
            todo.seedId,
            todo.hasReview,
        )
    }
}
