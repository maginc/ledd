package com.ragazm.ledd.persistance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Andris
 * Date: 30-Jan-19
 * Time: 20:39
 */

@Repository
interface RelayStateRepository : JpaRepository<RelayState, Long>