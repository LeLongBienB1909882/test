package com.demo.crud.service

import com.demo.crud.DTO.PhongDTO
import com.demo.crud.model.Phong
import com.demo.crud.repository.PhongRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*


@Service
class PhongService() {

    @Autowired
    private lateinit var phongRepository: PhongRepository

    fun getAll(): List<Phong> {
        return phongRepository.findAll()
    }


}