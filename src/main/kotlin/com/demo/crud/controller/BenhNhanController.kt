package com.demo.crud.controller

import com.demo.crud.model.BenhNhan
import com.demo.crud.repository.BenhNhanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/benhnhan")
class BenhNhanController() {
    @Autowired
    private lateinit var benhNhanRepository: BenhNhanRepository

    @GetMapping("/list")
    fun getBenhNhan() = object{
        val Data = benhNhanRepository.findAll()
    }

    @PostMapping("/add")
    fun addBenhNhan(@RequestBody benhNhan: BenhNhan): BenhNhan =
        benhNhanRepository.save(benhNhan);

    @GetMapping("/{mabenhnhan}")
    fun getMaBenhNhan(@PathVariable(value = "mabenhnhan") mabenhnhannew: String): ResponseEntity<BenhNhan> {
        return benhNhanRepository.findById(mabenhnhannew).map { benhNhan ->
            ResponseEntity.ok(benhNhan)
        }.orElse(ResponseEntity.notFound().build())
    }

}