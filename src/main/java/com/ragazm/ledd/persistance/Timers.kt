package com.ragazm.ledd.persistance

import javax.persistence.*

/**
 * Created by Andris
 * Date: 29-Jan-19
 * Time: 19:18
 */

@Entity
@Table(name = "timers")
data class Timers(


        @Id
       // @GeneratedValue(strategy = GenerationType.IDENTITY)
        val relay_number: Int,

        @Column(nullable = false)
        val time_on: String,

        @Column(nullable = false)
        val time_off: String,

        @Column(nullable = false)
        val description: String
)