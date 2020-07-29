package com.kostylenko.roulette.rest.model

import com.kostylenko.roulette.domain.entity.RoundStatistic
import com.kostylenko.roulette.domain.entity.UserStatistic

class StatisticSummary(val roundStatistic: List<RoundStatistic>,
                       val userStatistic: List<UserStatistic>) {
}