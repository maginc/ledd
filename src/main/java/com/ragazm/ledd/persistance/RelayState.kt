package com.ragazm.ledd.persistance

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Andris
 * Date: 30-Jan-19
 * Time: 20:37
 */

@Entity
@Table(name = "relay_state")
data class RelayState(

        @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        val relay_number: Int,

        @Column(nullable = false)
        val relay_state: String
)