package com.kostylenko.roulette.util

import com.kostylenko.roulette.domain.entity.Cell
import kotlin.random.Random

fun findRandomCell(cells: Collection<Cell>): Cell? {
    val sortedCells = cells.sortedBy { cell -> cell.weight }
    var i = 1;
    val map = HashMap<Int, Cell>();
    sortedCells.forEach { cell ->
        val weight = cell.weight;
        for (x in i until i + weight) {
            map.put(x, cell);
        }
        i += weight;
    }
    return map[Random.nextInt(1, i)]
}