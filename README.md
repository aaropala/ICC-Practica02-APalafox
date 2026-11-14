# 📚 ICC - Práctica 02 | APalafox
## 📝 Descripción

Repositorio correspondiente a la **Práctica 02** de la asignatura de Introducción a las Ciencias de la Computación (ICC).
Profesor: Salvador López Mendoza
Ayudante de laboratorio: Rosa Victoria Villa Padilla
Ayudante: Yanahi Demetrio Torres

El proyecto contiene dos programas desarrollados en Java, enfocados en la manipulación de fechas y la simulación de inversiones mediante cálculos de interés simple.

## 🚀 Contenido

### 1. 📅 Clase `Fecha`

Implementa operaciones relacionadas con el calendario gregoriano, considerando años bisiestos y validaciones de fechas.

**Funcionalidades principales:**
- Inicialización de fechas mediante parámetros.
- Validación de días, meses y años.
- Identificación de años bisiestos.
- Cálculo de días correspondientes a un mes.
- Cálculo de diferencias entre dos fechas.
- Suma y resta de días a una fecha.
- Conversión entre números y nombres de meses.
- Cálculo de días transcurridos del año.
- Comparación de fechas.
- Representación de fechas en formato `dd/mm/aaaa`.

### 2. 💰 Clase `TiempoDeInversion`

Simula una inversión financiera utilizando una tasa de interés simple anual.

**Funcionalidades principales:**
- Registro del nombre del inversionista.
- Captura y validación del capital inicial.
- Establecimiento de fechas de inicio y término.
- Validación de fechas y años bisiestos.
- Cálculo de la duración de la inversión en días.
- Cálculo del rendimiento mediante interés simple.
- Obtención del valor final de la inversión.
- Realización de múltiples simulaciones consecutivas.

## 📂 Estructura del proyecto

```text
ICC-Practica02-APalafox/
│
├── APalafox/
│   └── practica02/
│       └── src/
│           └── icc/
│               ├── Fecha.java
│               └── TiempoDeInversion.java
│
└── README.md
```

## ⚙️ Tecnologías utilizadas

- **Lenguaje:** Java
- **Entrada de datos:** `Scanner`
- **Paradigma:** Programación orientada a objetos.
- **Entorno de ejecución:** Java Virtual Machine (JVM).

## ▶️ Ejecución

Es necesario contar con el JDK de Java instalado.

Desde la carpeta `src/icc/`, compilar los archivos:

```bash
javac Fecha.java TiempoDeInversion.java
```

Ejecutar la clase `Fecha`:

```bash
java Fecha
```

Ejecutar la clase `TiempoDeInversion`:

```bash
java TiempoDeInversion
```

## 📐 Fundamentos aplicados

Durante el desarrollo se utilizaron conceptos fundamentales de programación:

- Clases y objetos.
- Atributos y métodos.
- Encapsulamiento.
- Sobrecarga de métodos.
- Estructuras condicionales.
- Ciclos de repetición.
- Validación de datos.
- Operaciones aritméticas.
- Manejo de fechas y cálculos financieros.

## 👨‍💻 Autor

**Aarón Palafox Solís**

Estudiante de la Universidad Nacional Autónoma de México (UNAM).

---

<p align="center">
  <i>UNAM · Introducción a las Ciencias de la Computación</i>
  <br/>
  <b>Práctica 02</b>
</p>
