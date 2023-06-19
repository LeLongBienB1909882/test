package com.demo.crud.repository

import com.demo.crud.model.BenhNhan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BenhNhanRepository: JpaRepository<BenhNhan, String>
