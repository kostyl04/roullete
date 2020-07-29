package com.kostylenko.roulette.domain.entity

import javax.persistence.*
import javax.persistence.FetchType.EAGER

@Entity
@Table(name = "Rounds")
class Round constructor(@Id @GeneratedValue @Column var id: Int?,
                        @Column var finished: Boolean,
                        @OneToMany(fetch = EAGER, cascade = [CascadeType.ALL], mappedBy = "round") var cells: MutableList<Cell>
) {
    init {
        cells.forEach { cell -> cell.round = this }
    }

    fun getNotUsedCells(): List<Cell> {
        return cells.filter { cell -> !cell.used };
    }
}