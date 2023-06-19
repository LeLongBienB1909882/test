package com.demo.crud.service

import com.demo.crud.model.XetNghiem
import com.demo.crud.repository.XetNghiemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class XetNghiemService() {

    @Autowired
    lateinit var xetNghiemRepository: XetNghiemRepository
    fun getAll(): List<XetNghiem> {
        return xetNghiemRepository.findAll()

    }
}