@serenityBDD @piano
Feature: Reproducir el Himno de la Alegría en el piano virtual

  Background:
    Given que el usuario abre el sitio del piano

  Scenario: Escenario 1 - Himno de la Alegría (secuencia simple)
    When el usuario reproduce la secuencia "si si do re re do si la sol sol la si si la la"
    Then el piano debería estar visible

  Scenario: Escenario 2 - Repetir secuencia dos veces
    When el usuario reproduce la secuencia "si si do re re do si la sol sol la si si la la" two times
    Then el piano debería estar visible

  Scenario: Escenario 3 - Secuencia extendida y repetición
    When el usuario reproduce la secuencia "si si do re re do si la sol sol la si la sol sol la si sol la si do si sol la si do si sol sol fa re"
    And el usuario repite el escenario 1
    Then el piano debería estar visible
