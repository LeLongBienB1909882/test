package com.demo.crud.controller

import com.demo.crud.model.DoiTuongBenhNhan
import com.demo.crud.model.Khoa
import com.demo.crud.repository.DoiTuongBenhNhanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/dtbn")
class DoiTuongBNController() {
    @Autowired
    private lateinit var doiTuongBenhNhanRepository: DoiTuongBenhNhanRepository

    @GetMapping("/list")
    fun getDoiTuong() = object {
        val Data = doiTuongBenhNhanRepository.findAll()
    }

    @PostMapping("/add")
    fun addKhoa(@RequestBody doiTuongBenhNhan: DoiTuongBenhNhan): DoiTuongBenhNhan =
        doiTuongBenhNhanRepository.save(doiTuongBenhNhan);

    @GetMapping("/{madt}")
    fun getDoiTuong(@PathVariable(value = "madt") madtnew: String): ResponseEntity<DoiTuongBenhNhan> {
        return doiTuongBenhNhanRepository.findById(madtnew).map { doiTuong ->
            ResponseEntity.ok(doiTuong)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("{madt}")
    fun updateDoiTuong(@PathVariable(value = "madt") madtnew: String,
                   @Validated @RequestBody newDoiTuongBenhNhan: DoiTuongBenhNhan
    ): ResponseEntity<DoiTuongBenhNhan> {

        return doiTuongBenhNhanRepository.findById(madtnew).map { existingDoiTuong ->
            val updateDoiTuong: DoiTuongBenhNhan = existingDoiTuong
                .copy(
                    tendoituong = newDoiTuongBenhNhan.tendoituong
                )
            ResponseEntity.ok().body(doiTuongBenhNhanRepository.save(updateDoiTuong))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{madt}")
    fun deleteDoiTuong(@PathVariable(value = "madt") madtnew: String): String {
        doiTuongBenhNhanRepository.findById(madtnew).map { doiTuong  ->
            doiTuongBenhNhanRepository.delete(doiTuong)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }

}