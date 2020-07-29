package com.kostylenko.roulette.domain.repository

import com.kostylenko.roulette.domain.entity.Cell
import com.kostylenko.roulette.domain.entity.RoundStatistic
import org.springframework.data.repository.CrudRepository

interface CellRepository: CrudRepository<Cell, Int> {

    fun findByUserIdIn(userIds:List<String>): MutableList<Cell>;
}