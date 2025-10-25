package com.ejemplo.retotecnico.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Runner de Cucumber + Serenity para ejecutar las features del piano.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/piano.feature",
        glue = "com.ejemplo.retotecnico.stepsdefinitions",
        plugin = {"pretty"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PianoRunnerTest {
}
