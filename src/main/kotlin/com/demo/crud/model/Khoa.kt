package com.demo.crud.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
@Table(name="Khoa")
data class Khoa(
    @Id
    @Column(nullable = false)
    val makhoa: String,

    @Column(nullable = false)
    val tenkhoa: String,

    @Column(nullable = false)
    val noitru: Boolean,

    @OneToMany(mappedBy = "makhoa")
    @JsonBackReference
//    var list_phong: List<Phong>? = null
    var list_phong: List<Phong>?=null,

//    @OneToMany(mappedBy = "makhoa")
//    @JsonBackReference
//    //    var list_phong: List<Phong>? = null
//    var list_benhnhan: List<BenhNhan>,

)

