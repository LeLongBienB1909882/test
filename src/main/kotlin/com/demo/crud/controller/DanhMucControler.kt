package com.demo.crud.controller

import com.demo.crud.DTO.BacSiDTO
import com.demo.crud.DTO.PhongDTO
import com.demo.crud.DTO.XetNghiemDTO
import com.demo.crud.model.*
import com.demo.crud.repository.*
import com.demo.crud.service.BacSiService
import com.demo.crud.service.PhongService
import com.demo.crud.service.XetNghiemService
import org.modelmapper.ModelMapper
import org.springframework.web.bind.annotation.*
import java.util.*

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.stream.Collectors

@RestController
@RequestMapping("/LIS_DanhMuc")
//?para=value
class DanhMucControler {
    @Autowired
    private lateinit var xetNghiemRepository: XetNghiemRepository

    @Autowired
    private lateinit var bacSiRepository: BacSiRepository;

    @Autowired
    private lateinit var khoaRepository: KhoaRepository

    @Autowired
    private lateinit var phongRepository: PhongRepository

    @Autowired
    private lateinit var doiTuongBenhNhanRepository: DoiTuongBenhNhanRepository

    @Autowired
    private lateinit var loaiMauRepository: LoaiMauRepository


    @Autowired
    private lateinit var phongService: PhongService

    @Autowired
    private lateinit var xetNghiemService: XetNghiemService

    @Autowired
    private lateinit var bacSiService: BacSiService

    @Autowired
    private lateinit var modelMapper: ModelMapper

//    fun getXetNghiem() = object{
//        var Data = xetNghiemRepository.findAll()
//    }

//    fun getBacSi() = object{
//        val Data = bacSiRepository.findAll()
//    }

    fun getKhoa() = object {
        var Data = khoaRepository.findAll()
    }

//    fun getPhong() = object{
//        var Data = phongRepository.findAll()
//    }

    fun getDoiTuongBenhNhan() = object {
        var Data = doiTuongBenhNhanRepository.findAll()
    }

    fun getLoaiMau() = object {
        var Data = loaiMauRepository.findAll()
    }

    fun getPhong(): ResponseEntity<Result> {
        val list_phong: List<Phong> = phongService.getAll()
        var list_phongDTO: List<PhongDTO> =
            list_phong.stream().map { Phong -> modelMapper.map(Phong, PhongDTO::class.java) }.collect(
                Collectors.toList()
            )
        return ResponseEntity(Result(list_phongDTO), HttpStatus.OK)
    }

    fun getXetNghiem(): ResponseEntity<Result> {
        val list_xetnghiem: List<XetNghiem> = xetNghiemService.getAll()
        var list_xetnghiemDTO: List<XetNghiemDTO> =
            list_xetnghiem.stream().map { XetNghiem -> modelMapper.map(XetNghiem, XetNghiemDTO::class.java) }.collect(
                Collectors.toList()
            )
        return ResponseEntity(Result(list_xetnghiemDTO), HttpStatus.OK)
    }

    fun getBacSi(): ResponseEntity<Result> {
        val list_bacsi: List<BacSi> = bacSiService.getAll()
        var list_bacsiDTO: List<BacSiDTO> =
            list_bacsi.stream().map { BacSi -> modelMapper.map(BacSi, BacSiDTO::class.java) }.collect(
                Collectors.toList()
            )
        return ResponseEntity(Result(list_bacsiDTO), HttpStatus.OK)
    }

    @GetMapping
    fun getLIS(@RequestParam para: Int): Any {
        if (para == 1)
            return getXetNghiem();
        if (para == 2)
            return getBacSi();
        if (para == 3)
            return getKhoa();
        if (para == 4)
            return getPhong();
        if (para == 6)
            return getDoiTuongBenhNhan();
        if (para == 8)
            return getLoaiMau();

        else
            return "Không tìm thấy yêu cầu";
    }

}
