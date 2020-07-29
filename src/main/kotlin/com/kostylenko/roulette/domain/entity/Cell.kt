package com.kostylenko.roulette.domain.entity

import javax.persistence.*

@Entity
@Table(name = "Cells")
class Cell(@Id @GeneratedValue @Column var id: Int?,
           @Column var desc: String?,
           @Column var weight: Int,
           @Column var used: Boolean,
           @Column var userId: String?,
           @ManyToOne(fetch = FetchType.LAZY) var round: Round?) {
}