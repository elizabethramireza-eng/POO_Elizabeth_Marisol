# 📚 Sistema de Gestión de Biblioteca — Modelado UML

Este repositorio contiene la solución técnica y el diseño del **Diagrama de Clases UML** para un **Sistema de Gestión de Biblioteca**, desarrollado como parte de la evaluación de Programación Orientada a Objetos (POO).

El objetivo principal de este trabajo es aplicar los fundamentos de la POO junto con los principios de diseño SOLID, logrando una arquitectura de software limpia, escalable y fácil de mantener.

---

## 👥 Integrantes del Equipo

* **Elizabeth** — *Estudiante de Tecnología en Desarrollo de Software*
* **Marisol** — *Estudiante de Tecnología en Desarrollo de Software*

---

## 📌 Descripción del Sistema

El sistema está diseñado para resolver las necesidades operativas de una biblioteca moderna. Permite administrar el catálogo de publicaciones, llevar el registro de autores, gestionar las solicitudes de préstamo por parte de los usuarios y controlar el cálculo de multas o sanciones.

### Entidades y Estructura Principal:
1. **`Libro` (Clase Abstracta):** Define los atributos comunes (`isbn`, `titulo`, `anioPublicacion`, `disponible`) y el método abstracto `obtenerInformacion()`.
2. **`LibroFisico` y `LibroDigital` (Subclases):** Heredan de `Libro` e implementan comportamientos específicos para el tipo de formato (ubicación física en estantes frente a URL de descarga y formato de archivo).
3. **`Autor`:** Almacena la información de los creadores de los libros y mantiene una relación de agregación con el catálogo.
4. **`Usuario`:** Modela a los miembros de la biblioteca habilitados para realizar solicitudes de préstamo.
5. **`Prestamo` y `DetallePrestamo`:** Gestionan la transacción del préstamo, fechas límite, fechas de devolución reales y el cálculo de multas asociadas.

---

## 📐 Diagrama de Clases UML

A continuación se presenta la representación visual de la arquitectura del sistema:

![Diagrama de Clases UML](./diagramas/POO_Elizabeth_Marisol.png)

*(Si la imagen no carga directamente, puedes encontrar el archivo `.png` dentro de la carpeta `/diagramas`).*

---

## 🛠️ Justificación Técnica y Principios de Diseño

### Pilares de la Programación Orientada a Objetos (POO):
* **Abstracción:** Identificamos únicamente los atributos y métodos relevantes del dominio de la biblioteca, encapsulándolos en clases especializadas.
* **Encapsulamiento:** Definimos todos los atributos con modificadores de acceso privados (`-`) o protegidos (`#`), garantizando que la modificación de datos se realice mediante métodos expuestos.
* **Herencia:** Creamos una jerarquía partiendo de la clase abstracta `Libro` hacia `LibroFisico` y `LibroDigital` para reutilizar código y evitar duplicidad.
* **Polimorfismo:** El método `obtenerInformacion()` se comporta de manera distinta dependiendo de si la instancia corresponde a un libro en físico o a un recurso digital.

### Principios SOLID Aplicados:
* **Single Responsibility Principle (SRP):** Cada clase tiene un único propósito delimitado (por ejemplo, `Prestamo` calcula el estado de la transacción mientras que `DetallePrestamo` administra tarifas y días).
* **Open/Closed Principle (OCP):** El sistema permite agregar nuevos tipos de publicaciones (como Revistas o Audiolibros) extendiendo la clase `Libro` sin necesidad de modificar el código existente.
* **Dependency Inversion Principle (DIP):** Las clases de alto nivel dependen de abstracciones (`Libro`) y no de clases concretas directamente.

---

## 📁 Estructura del Repositorio

```text
ea1-poo-biblioteca/
├── README.md                
├── docs/
│   └── EA1_DiagramaClases_Grupo6.pdf
└── diagramas/
    ├── POO_Elizabeth_Marisol.drawio
    └── POO_Elizabeth_Marisol.png