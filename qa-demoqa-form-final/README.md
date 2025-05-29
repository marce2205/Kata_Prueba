# Automatización QA - Formulario de Registro

Este proyecto automatiza la validación del formulario en [demoqa.com](https://demoqa.com/automation-practice-form) usando **Java**, **Selenium**, **Cucumber** y **Faker**.

## ✅ Requisitos

- Java 17+
- Maven
- Google Chrome

## ▶ Cómo ejecutar

### Requisitos previos

- Java JDK 11 o superior instalado
- Maven instalado y configurado en el PATH
- ChromeDriver compatible con la versión de Chrome instalada
- Conexión a internet para acceder al sitio de pruebas

### Pasos

1. Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/qa-demoqa-form.git
cd qa-demoqa-form

## 📋 Escenarios Automatizados

1. Registro exitoso con datos válidos
2. Campo nombre con valor mínimo
3. Combinación de género y hobby
4. Email inválido
5. Datos generados con Faker
6. Envio de formulario vacio

## 📁 Evidencias

- Se generan reportes HTML en la carpeta `target/`.


## 💡 Uso de Inteligencia Artificial

Esta solución fue guiada y asistida por **IA (ChatGPT)** para:
- Generar la estructura del proyecto.
- Justificar uso de Faker y ejecutar en paralelo con JUnit.

## 🧪 Ejecución en paralelo

Configurado en `src/test/resources/junit-platform.properties`.


