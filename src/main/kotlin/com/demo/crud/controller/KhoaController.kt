package com.demo.crud.controller

import com.demo.crud.model.Khoa
import com.demo.crud.repository.KhoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/khoa")
class KhoaController() {
    @Autowired
    private lateinit var khoaRepository: KhoaRepository

    @GetMapping("/list")
    fun getKhoa() = object{
        val Data = khoaRepository.findAll()
    }

    @PostMapping("/add")
    fun addKhoa( @RequestBody khoa: Khoa): Khoa =
        khoaRepository.save(khoa);

    @GetMapping("/{makhoa}")
    fun getKhoa(@PathVariable(value = "makhoa") makhoanew: String): ResponseEntity<Khoa> {
        return khoaRepository.findById(makhoanew).map { khoa ->
            ResponseEntity.ok(khoa)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("{makhoa}")
    fun updateKhoa(@PathVariable(value = "makhoa") makhoanew: String,
                    @Validated @RequestBody newKhoa: Khoa
    ): ResponseEntity<Khoa> {

        return khoaRepository.findById(makhoanew).map { existingKhoa ->
            val updateKhoa: Khoa = existingKhoa
                .copy(
                    tenkhoa = newKhoa.tenkhoa,
                    noitru = newKhoa.noitru
                )
            ResponseEntity.ok().body(khoaRepository.save(updateKhoa))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{makhoa}")
    fun deleteKhoa(@PathVariable(value = "makhoa") madichvunew: String): String {
        khoaRepository.findById(madichvunew).map { khoa  ->
            khoaRepository.delete(khoa)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }

}