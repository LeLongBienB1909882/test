package com.demo.crud.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name="XetNghiem")
data class XetNghiem(
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonBackReference
//    val id_xn: Long = 0,

    val madichvucha: String? = null,

    @Id
    @Column(nullable = false)
    val madichvu: String ,

    @Column(nullable = false)
    val tendichvu: String,

    @Column(nullable = false)
    val maloaidv: String,

    @Column(nullable = false)
    val tenloaidv: String,

    @OneToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
//    @MapsId
    @JoinColumn(name = "maloaimau")
    @JsonManagedReference
    var maloaimau: LoaiMau? =null,

    @ManyToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JoinColumn(name = "mabenhnhan")
    @JsonManagedReference
    var mabenhnhan: BenhNhan? =null,


    )

