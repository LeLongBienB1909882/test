package com.demo.crud.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.validation.constraints.Null

@Entity
@Table(name="BacSi")
data class BacSi(

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonBackReference
//    val id_bs: Long = 0,
    @Id
    @Column(nullable = false)
    val mabacsi: String? = null,

    @Column(nullable = false)
    val tenbacsi: String,

    val anhchuky: String? = null,

    @ManyToOne
    @JoinColumn(name = "maphong")
    @JsonManagedReference
    val maphong: Phong? = null,

    @OneToMany(mappedBy = "mabacsi")
    @JsonBackReference
//    var list_benhnhan: List<BenhNhan>? = null
    var list_benhnhan: List<BenhNhan>?=null,


)

