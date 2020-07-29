package com.kostylenko.roulette.domain.repository

import com.kostylenko.roulette.domain.entity.RoundStatistic
import org.springframework.data.repository.CrudRepository

interface StatisticRepository: CrudRepository<RoundStatistic, Int> {
}