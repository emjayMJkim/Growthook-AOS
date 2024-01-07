package com.growthook.aos.data.model.response

import com.growthook.aos.domain.entity.Actionplan
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetActionplanDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: ActionplanData,
) {
    @Serializable
    data class ActionplanData(
        @SerialName("actionPlanId")
        val actionPlanId: Int,
        @SerialName("content")
        val content: String,
        @SerialName("isScraped")
        val isScraped: Boolean,
        @SerialName("isFinished")
        val isFinished: Boolean,
    )

    fun toActionplan() = Actionplan(
        actionplanId = data.actionPlanId,
        content = data.content,
        isScraped = data.isScraped,
        isFinished = data.isFinished,
    )
}
