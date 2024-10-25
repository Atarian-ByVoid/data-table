package com.beto.data_table.config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // feature do cucumber
    glue = {"com.beto.data_table.steps", "com.beto.data_table.config"},  // Aponta para a classe e as config dos testes
    plugin = {"pretty", "html:target/cucumber-reports"}, // Embeleza o console
    snippets = SnippetType.CAMELCASE // Metodos anotados em camel ou snake
    )
public class CucumberTestRunner {
}
