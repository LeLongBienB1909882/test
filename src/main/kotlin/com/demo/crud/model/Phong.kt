package com.demo.crud.model

import com.demo.crud.model.Khoa
import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
@Table(name="Phong")
data class Phong(

    @Id
    @Column(nullable = false)
    val maphong: String,

    @Column(nullable = false)
    val tenphong: String,

    @ManyToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JoinColumn(name = "makhoa")
    @JsonManagedReference
    var makhoa: Khoa,


    @OneToMany(mappedBy = "maphong")
    @JsonBackReference
    var list_bacsi: List<BacSi>?=null,
)


