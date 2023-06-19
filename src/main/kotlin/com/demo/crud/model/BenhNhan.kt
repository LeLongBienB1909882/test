package com.demo.crud.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.DateTimeException
import java.util.Date

@Entity
@Table(name="BenhNhan")
data class BenhNhan(

    @Id
    @Column(nullable = false)
    val mabenhnhan: Int,

    @Column(nullable = false)
    val tenbenhnhan: String,

    @Column(nullable = false)
    val namsinh: Int,

    val sinhnhat: Date? = null,

    @Column(nullable = false)
    val gioitinh: String,

    @Column(nullable = false)
    val diachi: String,

    val sodienthoai: String? = null,

    val email: String? = null,

    val cannang: Int? = null,

    val chieucao: Int? = null,

    val nhommau: String? = null,

    val sohochieu: String? = null,

    val quoctich: String? = null,

    val ngayhethanhochieu: Date? = null,

    val idcongdan: String? = null,


    @ManyToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JoinColumn(name = "madoituong")
    @JsonManagedReference
    var madoituong: DoiTuongBenhNhan? = null,

    @ManyToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JoinColumn(name = "mabacsi")
    @JsonManagedReference
    var mabacsi: BacSi? = null,

    @OneToMany(mappedBy = "mabenhnhan")
    @JsonBackReference
    var list_xetnghiem: List<XetNghiem>?=null,
//madoituong	string
//tendoituong	string
//mabacsi	string
//tenbacsi	string
//makhoa	string
//tenkhoa	string
//maphong	string
//tenphong	string
)


