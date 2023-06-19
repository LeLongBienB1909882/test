package com.demo.crud.controller

import com.demo.crud.model.XetNghiem
import com.demo.crud.repository.XetNghiemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/xetnghiem")
class XetNghiemController() {
    @Autowired
    private lateinit var xetNghiemRepository: XetNghiemRepository;

    @GetMapping("/list")
    fun getObject() = object{
        val Data = xetNghiemRepository.findAll()
    }

    @PostMapping("/add")
    fun addXetNghiem( @RequestBody xetNghiem: XetNghiem): XetNghiem =
        xetNghiemRepository.save(xetNghiem);

//    @PostMapping("/add")
//    fun addTest(@Validated @RequestBody xetNghiem: XetNghiem) = object {val Data =
//        xetNghiemRepository.save(xetNghiem)}

    @GetMapping("/{madichvu}")
    fun getXetNghiem(@PathVariable(value = "madichvu") madichvunew: String): ResponseEntity<XetNghiem> {
        return xetNghiemRepository.findById(madichvunew).map { xetNghiem ->
            ResponseEntity.ok(xetNghiem)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("{madichvu}")
    fun updateXetNghiemMa(@PathVariable(value = "madichvu") madichvunew: String,
                          @Validated @RequestBody newXetNghiem: XetNghiem): ResponseEntity<XetNghiem> {

        return xetNghiemRepository.findById(madichvunew).map { existingXetNghiem ->
            val updateXetNghiem: XetNghiem = existingXetNghiem
                .copy(
                    madichvucha = newXetNghiem.madichvucha,
                    tendichvu = newXetNghiem.tendichvu,
                    maloaidv = newXetNghiem.maloaidv,
                    tenloaidv = newXetNghiem.tenloaidv
                )
            ResponseEntity.ok().body(xetNghiemRepository.save(updateXetNghiem))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{madichvu}")
    fun deleteXetNghiem(@PathVariable(value = "madichvu") madichvunew: String): String {
         xetNghiemRepository.findById(madichvunew).map { xetNghiem  ->
            xetNghiemRepository.delete(xetNghiem)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }
}