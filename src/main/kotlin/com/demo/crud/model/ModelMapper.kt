package com.demo.crud.model

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ModelMapper {
    @Bean
    fun modelMappers():ModelMapper{
        return ModelMapper()
    }

//    fun modelMapper8():ModelMapper{
//        return ModelMapper()
//    }

}