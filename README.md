# ✅ SmartTask — Gestor de Tareas por Consola

Aplicación de consola desarrollada en Java que permite gestionar tareas diarias de forma simple y eficiente. Proyecto desarrollado durante el bootcamp de desarrollo de software.

## 🚀 ¿Cómo ejecutar el proyecto?

### Opción 1 — Ejecutar el .jar (sin instalar nada)
1. Descarga el archivo `SmartTask.jar` desde [Releases](../../releases)
2. Abre una terminal en la carpeta donde lo descargaste
3. Ejecuta:
```bash
java -jar SmartTask.jar
```

### Opción 2 — Compilar desde el código fuente
1. Clona el repositorio:
```bash
git clone https://github.com/MiloNegrete/smart_task.git
```
2. Entra a la carpeta:
```bash
cd smart_task/src/main/java
```
3. Compila:
```bash
javac *.java
```
4. Ejecuta:
```bash
java SmartTask
```

## 📋 Funcionalidades

- **Agregar tareas** normales o urgentes
- **Listar tareas** con estado y fecha de creación
- **Marcar como completada** una tarea por ID
- **Eliminar tareas** por ID
- **Validación de entradas** — el programa no crashea con datos inválidos

## 🏗️ Arquitectura del proyecto

```
smart_task/
├── src/
│   └── main/
│       └── java/
│           ├── SmartTask.java       → Punto de entrada, menú principal
│           ├── GestorTareas.java    → Lógica de gestión de tareas
│           ├── Tarea.java           → Clase abstracta base
│           ├── TareaNormal.java     → Tarea de prioridad normal
│           ├── TareaUrgente.java    → Tarea de prioridad urgente
│           └── Accionable.java      → Interfaz con operaciones principales
├── pom.xml
├── .gitignore
└── README.md
```

## 🧠 Conceptos de POO aplicados

- **Herencia** — `TareaNormal` y `TareaUrgente` extienden `Tarea`
- **Abstracción** — `Tarea` es una clase abstracta
- **Polimorfismo** — instanciación dinámica según tipo de tarea
- **Interfaces** — `Accionable` define el contrato del gestor

## 🛠️ Tecnologías

- Java 11+
- Maven

## 👤 Autor

**Milo Negrete** — [github.com/MiloNegrete](https://github.com/MiloNegrete)