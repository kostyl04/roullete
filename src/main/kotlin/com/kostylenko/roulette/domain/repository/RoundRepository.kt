package com.kostylenko.roulette.domain.repository

import com.kostylenko.roulette.domain.entity.Round
import org.springframework.data.repository.CrudRepository

interface RoundRepository : CrudRepository<Round,Int>{

    fun findByFinishedFalse(): Round?;
}