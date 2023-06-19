package com.demo.crud.controller

import com.demo.crud.model.LoaiMau
import com.demo.crud.repository.LoaiMauRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/loaimau")
class LoaiMauController() {
    @Autowired
    private lateinit var loaiMauRepository: LoaiMauRepository

    @GetMapping("/list")
    fun getLoaiMau() = object {
        val Data = loaiMauRepository.findAll()
    }

    @PostMapping("/add")
    fun addLoaiMau(@RequestBody loaiMau: LoaiMau): LoaiMau =
        loaiMauRepository.save(loaiMau);

    @GetMapping("/{maloaimau}")
    fun getLoaiMau(@PathVariable(value = "maloaimau") maloaimaunew: String): ResponseEntity<LoaiMau> {
        return loaiMauRepository.findById(maloaimaunew).map { doiTuong ->
            ResponseEntity.ok(doiTuong)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("{maloaimau}")
    fun updateLoaiMau(@PathVariable(value = "maloaimau") maloaimaunew: String,
                       @Validated @RequestBody newLoaiMau: LoaiMau
    ): ResponseEntity<LoaiMau> {

        return loaiMauRepository.findById(maloaimaunew).map { existingloaiMau ->
            val updateLoaiMau: LoaiMau = existingloaiMau
                .copy(
                    tenloaimau = newLoaiMau.tenloaimau
                )
            ResponseEntity.ok().body(loaiMauRepository.save(updateLoaiMau))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{maloaimau}")
    fun deleteLoaiMau(@PathVariable(value = "maloaimau") maloaimaunew: String): String {
        loaiMauRepository.findById(maloaimaunew).map { loaiMau  ->
            loaiMauRepository.delete(loaiMau)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }

}