package com.demo.crud.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
@Table(name="LoaiMau")
data class LoaiMau(

    @Id
    @Column(nullable = false)
    val maloaimau: String,

    @Column(nullable = false)
    val tenloaimau: String,

    @OneToOne(mappedBy = "maloaimau", cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JsonBackReference
//    @JsonManagedReference
    val xetNghiem: XetNghiem? = null
)

