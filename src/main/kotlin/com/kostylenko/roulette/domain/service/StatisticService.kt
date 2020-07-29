package com.kostylenko.roulette.domain.service

import com.kostylenko.roulette.domain.entity.Round
import com.kostylenko.roulette.domain.entity.RoundStatistic
import com.kostylenko.roulette.domain.entity.UserStatistic
import com.kostylenko.roulette.domain.repository.CellRepository
import com.kostylenko.roulette.domain.repository.StatisticRepository
import com.kostylenko.roulette.domain.repository.UserStatisticRepository
import org.springframework.stereotype.Service

@Service
class StatisticService(val statisticRepository: StatisticRepository,
                       val cellRepository: CellRepository,
                       val userStatisticRepository: UserStatisticRepository) {

    fun calculateStatistic(round: Round) {
        createRoundStatistic(round);
        createUserStatistic(round);
    }

    fun getUserStatistics(): List<UserStatistic> {
        return userStatisticRepository.findAll().filterNotNull();
    }

    fun getRoundStatistics(): List<RoundStatistic> {
        return statisticRepository.findAll().filterNotNull();
    }

    private fun createUserStatistic(round: Round) {
        val cells = cellRepository.findByUserIdIn(round.cells.mapNotNull { cell -> cell.userId });
        val userRolls = cells.groupBy { cell -> cell.userId };
        val userStatistics = ArrayList<UserStatistic>();
        userRolls.forEach { entry ->
            run {
                val userId = entry.key;
                val rounds = entry.value.map { cell -> cell.round?.id }.distinct().count();
                val roundAvg = entry.value.groupBy { cell -> cell.round }
                        .mapValues { entry -> entry.value.size }
                        .values
                        .average()
                        .toInt();
                userStatistics.add(UserStatistic(null, userId, rounds, roundAvg));
            }
        }
        userStatistics.forEach { userStatistic ->
            val existingStatistic = userStatisticRepository.findByUserId(userStatistic.userId);
            if (existingStatistic != null) {
                userStatistic.id = existingStatistic.id;
            }
            userStatisticRepository.save(userStatistic);
        }
    }

    private fun createRoundStatistic(round: Round) {
        val users = round.cells.map { cell -> cell.userId }.distinct().count();
        statisticRepository.save(RoundStatistic(null, round.id, users));
    }
}