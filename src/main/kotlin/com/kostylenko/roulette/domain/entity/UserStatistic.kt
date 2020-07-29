package com.kostylenko.roulette.domain.entity

import javax.persistence.*
import javax.persistence.FetchType.EAGER

@Entity
@Table(name = "user_statistic")
class UserStatistic(@Id @GeneratedValue @Column var id: Int?,
                    @Column val userId: String?,
                    @Column var rounds: Int,
                    @Column var rollsAvg: Int) {

}