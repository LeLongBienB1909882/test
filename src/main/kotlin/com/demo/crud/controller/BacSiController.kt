package com.demo.crud.controller

import com.demo.crud.model.BacSi
import com.demo.crud.model.XetNghiem
import com.demo.crud.repository.BacSiRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/bacsi")
class BacSiController() {
    @Autowired
    private lateinit var bacSiRepository: BacSiRepository;

    @GetMapping("/list", params = arrayOf("para=1"))
    fun getBacSis() = object{
        val Data = bacSiRepository.findAll()
    }

    @GetMapping("/list")
    fun getBacSi() = object{
        val Data = bacSiRepository.findAll()
    }

    @PostMapping("/add")
    fun addBacSi( @RequestBody bacSi: BacSi): BacSi =
        bacSiRepository.save(bacSi);

    @GetMapping("/{mabacsi}")
    fun getMaBacSi(@PathVariable(value = "mabacsi") mabacsinew: String): ResponseEntity<BacSi> {
        return bacSiRepository.findById(mabacsinew).map { bacSi ->
            ResponseEntity.ok(bacSi)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("{mabacsi}")
    fun updateBacSi(@PathVariable(value = "mabacsi") mabacsinew: String,
                          @Validated @RequestBody newBacSi: BacSi
    ): ResponseEntity<BacSi> {

        return bacSiRepository.findById(mabacsinew).map { existingBacSi ->
            val updateBacSi: BacSi = existingBacSi
                .copy(
                    tenbacsi = newBacSi.tenbacsi,
                    anhchuky = newBacSi.anhchuky,
                    maphong = newBacSi.maphong
                )
            ResponseEntity.ok().body(bacSiRepository.save(updateBacSi))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{mabacsi}")
    fun deleteBacSi(@PathVariable(value = "mabacsi") madichvunew: String): String {
        bacSiRepository.findById(madichvunew).map { bacSi  ->
            bacSiRepository.delete(bacSi)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build());
        return "success"
    }

}