package com.kostylenko.roulette.rest.service

import com.kostylenko.roulette.domain.service.RouletteService
import com.kostylenko.roulette.domain.service.StatisticService
import com.kostylenko.roulette.rest.model.Roll
import com.kostylenko.roulette.rest.model.StatisticSummary
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/roulette")
class RouletteRest constructor(
        val rouletteService: RouletteService,
        val statisticService: StatisticService) {

    @PostMapping("/roll")
    fun roll(@RequestBody roll: Roll): Roll {
        val cell = rouletteService.roll(roll.userId);
        return Roll(roll.userId, cell?.desc);
    }

    @GetMapping("/statistics")
    fun getStatistics(): StatisticSummary {
        val roundStatistics = statisticService.getRoundStatistics();
        val userStatistics = statisticService.getUserStatistics();
        return StatisticSummary(roundStatistics, userStatistics);
    }
}