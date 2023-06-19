package com.demo.crud.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference

@Entity
@Table(name="DoiTuongBenhNhan")
data class DoiTuongBenhNhan(

    @Id
    @Column(nullable = false)
    val madoituong: String,

    @Column(nullable = false)
    val tendoituong: String,


    @OneToMany(mappedBy = "madoituong")
    @JsonBackReference
//    var list_benhnhan: List<BenhNhan>? = null
    var list_benhnhan: List<BenhNhan>? = null,
)

