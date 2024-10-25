package com.beto.data_table.config;

import org.springframework.boot.test.context.SpringBootTest;

import com.beto.data_table.DataTableApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = DataTableApplication.class) 
public class CucumberSpringConfiguration {
}