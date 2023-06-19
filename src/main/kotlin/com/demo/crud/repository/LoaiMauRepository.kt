package com.demo.crud.repository

import com.demo.crud.model.LoaiMau
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LoaiMauRepository: JpaRepository<LoaiMau, String>