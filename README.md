# 📱 Proyecto Android - Gestión de Personajes (PMDM02)

Este proyecto forma parte del módulo **Programación Multimedia y de Dispositivos Móviles (PMDM02)** del ciclo **Desarrollo de Aplicaciones Multiplataforma (DAM)**.  
El objetivo es poner en práctica los fundamentos del desarrollo Android moderno: navegación entre fragmentos, gestión de preferencias, localización, e interfaces dinámicas con `RecyclerView`.

---

## 🧩 **Descripción General**

La aplicación permite **visualizar un listado de personajes**, consultar su **detalle individual** y **ajustar preferencias** como el idioma.  
Está estructurada bajo una arquitectura modular basada en *Fragments*, *RecyclerView* y *Navigation Component*.

---

## 🚀 **Características Principales**

- 📚 **Listado dinámico de personajes** con `RecyclerView` y `ViewHolder`.
- 🧍 **Pantalla de detalle** con imagen, descripción y habilidades del personaje.
- 🌐 **Soporte multidioma** (es/en), configurable desde `SharedPreferences`.
- 🧭 **Navegación estructurada** mediante `NavController` y `DrawerLayout`.
- ⚙️ **Gestión de preferencias** desde `PreferencesFragment`.
- 💬 **Diálogo “Acerca de”** con versión y créditos.

---

## 🧱 **Arquitectura del Proyecto**

📦 com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02
┣ 📜 MainActivity.java → Control principal de la app (UI, navegación y locale)
┣ 📜 CharactersListFragment.java → Muestra la lista de personajes
┣ 📜 CharacterDetailFragment.java → Muestra los detalles de un personaje
┣ 📜 CharacterRecyclerViewAdapter.java → Enlaza datos con la lista
┣ 📜 CharacterViewHolder.java → Gestiona vistas individuales del RecyclerView
┣ 📜 CharacterData.java → Modelo de datos de los personajes
┗ 📜 PreferencesFragment.java → Configuración y preferencias del usuario

---

## 🧭 **Navegación y Flujo de la App**

​    A[MainActivity] --> B[CharactersListFragment]
​    B -->|Seleccionar personaje| C[CharacterDetailFragment]
​    A --> D[PreferencesFragment]
​    A --> E[AboutDialog]

🛠️ **Tecnologías Utilizadas**

- Lenguaje: Java
- Entorno: Android Studio
- Arquitectura: Fragments + Navigation Component
- UI: RecyclerView, DrawerLayout, Toolbar, Material Design
- Gestión de estado: SharedPreferences
- Compatibilidad: Múltiples densidades (hdpi, xhdpi, xxhdpi, etc.)
- Internacionalización: values/, values-en/, values-night/

⚙️ **Instalación y Ejecución**

1. Clona el repositorio:

```
git clone https://github.com/franjrodriguez/Rodriguez_Ruiz_Francisco_Jose_PMDM02.git
```

2. Ábrelo en Android Studio (versión recomendada: Giraffe o posterior).

3. Espera la sincronización de Gradle.

4. Ejecuta la aplicación en un emulador o dispositivo físico Android (API 24+).

   

   📸 **Capturas de Pantalla (opcional)**
   Añade aquí imágenes de las pantallas principales: lista, detalle y ajustes.

   

   💡 **Decisiones Técnicas Destacadas**
   Implementación del cambio de idioma persistente con SharedPreferences + recreate().
   Control del DrawerLayout mediante ActionBarDrawerToggle adaptativo según fragment.
   Uso del patrón ViewHolder para mejorar rendimiento del RecyclerView.
   Modularidad total de la interfaz a través de fragments reutilizables.

   

   🔮 **Posibles Mejoras Futuras**
   Integración de una base de datos local (Room).
   Carga dinámica de personajes desde API REST.
   Inclusión de animaciones entre fragmentos.
   Diseño adaptativo con Jetpack Compose.

   

   👤 Autor
   Francisco José Rodríguez Ruiz
   💼 Estudiante de Desarrollo de Aplicaciones Multiplataforma (DAM)
   📍 Guadix, España
   “Cada línea de código es una oportunidad de aprender algo nuevo.”
