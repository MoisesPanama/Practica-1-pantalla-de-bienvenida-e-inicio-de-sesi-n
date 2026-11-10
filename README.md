# Práctica 1 – Pantalla de bienvenida e inicio de sesión

**Estudiante:** Moisés Panamá · mpanamam@uteq.edu.ec  
**Asignatura:** Aplicaciones Móviles – UTEQ 2026

Aplicación Android en Kotlin con dos pantallas: una **bienvenida** con el logo de la UTEQ y un **inicio de sesión** con correo y contraseña usando Material Components. El botón **Ingresar** abre la pantalla de login.

## ¿Qué hace?

- **Pantalla de bienvenida:** muestra el logo de la UTEQ, un mensaje de bienvenida a la FCC y el botón para ingresar al inicio de sesión.
- **Inicio de sesión:** campos de correo y contraseña con íconos, teclado adecuado para cada campo y opción para mostrar u ocultar la contraseña.

## Tecnologías

- Kotlin
- Android Studio
- ConstraintLayout
- Material Components (`TextInputLayout`)
- Android SDK 37 (minSdk 24)

## Estructura del proyecto

```text
app/src/main/
├── java/com/example/practica1/
│   ├── MainActivity.kt      # Pantalla de bienvenida
│   └── LoginActivity.kt     # Pantalla de inicio de sesión
└── res/
    ├── drawable/            # Logo e íconos
    ├── layout/
    │   ├── activity_main.xml
    │   └── activity_login.xml
    └── values/              # Textos, colores y tema
```

## Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/MoisesPanama/Practica-1-pantalla-de-bienvenida-e-inicio-de-sesi-n.git
   ```
2. Abre la carpeta del proyecto en Android Studio.
3. Espera a que Gradle sincronice las dependencias.
4. Ejecuta la app en un emulador o dispositivo con **Run ▶**.

También puedes compilar desde la terminal:

```bash
# Windows
.\gradlew.bat assembleDebug

# Linux / macOS
./gradlew assembleDebug
```

## Evidencias

| Bienvenida | Inicio de sesión |
|:---:|:---:|
| _Agregar captura_ | _Agregar captura_ |
