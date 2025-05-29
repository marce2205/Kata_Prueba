Feature: Validar formulario de registro

  Scenario: Registro exitoso con datos válidos
    Given que el usuario accede al formulario de registro
    When ingresa datos válidos en todos los campos
    And hace clic en el botón Submit
    Then el sistema muestra el mensaje "Thanks for submitting the form"

  Scenario: Campo nombre con valor mínimo
    Given que el usuario accede al formulario de registro
    When ingresa un solo carácter en el campo First Name
    And completa el resto del formulario con datos válidos
    And hace clic en el botón Submit
    Then el sistema muestra el mensaje "Thanks for submitting the form"

  Scenario Outline: Combinación de género y hobby
    Given que el usuario accede al formulario de registro
    When selecciona el género "<genero>" y el hobby "<hobby>"
    And hace clic en el botón Submit
    Then el sistema muestra el mensaje "Thanks for submitting the form"

    Examples:
      | genero | hobby    |
      | Male   | Sports   |
      | Female | Music    |
      | Other  | Reading  |

  Scenario: Email inválido sin arroba
    Given que el usuario accede al formulario de registro
    When ingresa un email sin arroba
    And hace clic en el botón Submit
    Then el sistema no permite enviar el formulario

  Scenario: Registro con datos aleatorios usando Faker
    Given que el usuario accede al formulario de registro
    When completa todos los campos usando datos aleatorios
    And hace clic en el botón Submit
    Then el sistema muestra el mensaje "Thanks for submitting the form"

  Scenario: Campos obligatorios vacios
    Given que el usuario accede al formulario de registro
    When deja vacio todos los campos
    And hace clic en el botón Submit
    Then el sistema no permite enviar el formulario
