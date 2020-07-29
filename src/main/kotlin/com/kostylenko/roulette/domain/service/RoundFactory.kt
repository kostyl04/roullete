package com.kostylenko.roulette.domain.service

import com.kostylenko.roulette.domain.entity.Cell
import com.kostylenko.roulette.domain.entity.Round
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class RoundFactory {

    fun createRound(): Round {
        val generateCells = generateCells();
        return Round(null, false, generateCells);
    }

    private fun generateCells(): MutableList<Cell>{
        val cells = ArrayList<Cell>(50);
        for(x in 1 .. 50){
            cells.add(Cell(null,x.toString(),generateCellWeight(), false, null, null));
        }
        return cells;
    }

    private fun generateCellWeight():Int{
        return Random.nextInt(1,11);
    }
}