package com.ragazm.ledd.persistance


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Andris
 * Date: 29-Jan-19
 * Time: 23:07
 */
@Repository
interface TimerRepository : JpaRepository<Timers, Long>