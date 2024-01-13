package com.growthook.aos.data.repository

import com.growthook.aos.data.datasource.remote.ReviewDataSource
import com.growthook.aos.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(private val reviewDataSource: ReviewDataSource) :
    ReviewRepository {
    override suspend fun getReviewDetail(actionplanId: Int): Result<Unit> = runCatching {
        reviewDataSource.getReviewDetail(actionplanId)
    }
}
