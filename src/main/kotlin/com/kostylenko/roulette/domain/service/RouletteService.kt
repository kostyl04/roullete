package com.kostylenko.roulette.domain.service

import com.kostylenko.roulette.domain.entity.Cell
import com.kostylenko.roulette.domain.entity.Round
import com.kostylenko.roulette.domain.repository.RoundRepository
import com.kostylenko.roulette.util.findRandomCell
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class RouletteService(val roundRepository: RoundRepository,
                      val roundFactory: RoundFactory,
                      val statisticService: StatisticService) {

    @Transactional
    @Synchronized
    fun roll(userId: String): Cell? {
        var currentRound = roundRepository.findByFinishedFalse();
        if (currentRound == null) {
            currentRound = roundFactory.createRound();
            currentRound = roundRepository.save(currentRound);
        }
        val notUsedCells = currentRound.getNotUsedCells();
        if (notUsedCells.isEmpty()) {
            return finishRound(currentRound, userId);
        }
        val randomCell = findRandomCell(notUsedCells);
        randomCell?.used = true;
        randomCell?.userId = userId;
        return randomCell;
    }

    private fun finishRound(currentRound: Round, userId: String): Cell {
        currentRound.finished = true;
        val jackpotCell = Cell(null, "Jackpot", 0, true, userId, currentRound);
        currentRound.cells.add(jackpotCell);
        roundRepository.save(currentRound);
        statisticService.calculateStatistic(currentRound);
        return jackpotCell;
    }
}