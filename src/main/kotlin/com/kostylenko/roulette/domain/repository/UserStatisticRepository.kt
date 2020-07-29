package com.kostylenko.roulette.domain.repository

import com.kostylenko.roulette.domain.entity.UserStatistic
import org.springframework.data.repository.CrudRepository

interface UserStatisticRepository : CrudRepository<UserStatistic, Int> {

    fun findByUserId(userId: String?): UserStatistic?;
}