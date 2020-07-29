package com.kostylenko.roulette.domain.entity

import javax.persistence.*
import javax.persistence.FetchType.EAGER

@Entity
@Table(name = "round_statistic")
class RoundStatistic(@Id @GeneratedValue @Column var id: Int?,
                     @Column val round: Int?,
                     @Column val users: Int) {

}