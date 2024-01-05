Feature: Reallizacion de casos ingresando nombre de usuario y contraseña

  Scenario: Verificacion de ingreso de sesion
    Given Abrir Chrome
    When ingresar Username "user" y Password "user"
    Then inicia sesion

  Scenario: Verificacion de ingreso de sesion con contraseña y username mal escrita
    Given Abrir Chrome
    When ingresar Username "userr" y Password "12345"
    Then inicia sesion

  Scenario: Verificacion de ingreso de sesion con valor null
    Given Abrir Chrome
    When ingresar Username "" y Password ""
    Then inicia sesion
