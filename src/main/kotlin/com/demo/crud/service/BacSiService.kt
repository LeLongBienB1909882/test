package com.demo.crud.service

import com.demo.crud.model.BacSi
import com.demo.crud.repository.BacSiRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class BacSiService() {

    @Autowired
    private lateinit var bacSiRepository: BacSiRepository

    fun getAll(): List<BacSi> {
        return bacSiRepository.findAll()
    }

}