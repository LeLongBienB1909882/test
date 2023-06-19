package com.demo.crud.controller

import com.demo.crud.model.Khoa
import com.demo.crud.model.Phong
import com.demo.crud.repository.PhongRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/phong")
class PhongController() {
    @Autowired
    private lateinit var phongRepository: PhongRepository

    @GetMapping("/list")
    fun getPhong() = object {
        val Data = phongRepository.findAll()
    }

    @PostMapping("/add")
    fun addPhong(@RequestBody phong: Phong): Phong =
        phongRepository.save(phong);

    @GetMapping("/{maphong}")
    fun getPhong(@PathVariable(value = "maphong") maphongnew: String): ResponseEntity<Phong> {
        return phongRepository.findById(maphongnew).map { phong ->
            ResponseEntity.ok(phong)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("{maphong}")
    fun updatePhong(@PathVariable(value = "maphong") maphongnew: String,
                          @Validated @RequestBody newPhong: Phong
    ): ResponseEntity<Phong> {

        return phongRepository.findById(maphongnew).map { existingPhong ->
            val updateBacSi: Phong = existingPhong
                .copy(
                    tenphong = newPhong.tenphong,
                    makhoa = newPhong.makhoa
                )
            ResponseEntity.ok().body(phongRepository.save(updateBacSi))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{maphong}")
    fun deletePhong(@PathVariable(value = "maphong") maphongnew: String): String {
        phongRepository.findById(maphongnew).map { phong ->
            phongRepository.delete(phong)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }

}
