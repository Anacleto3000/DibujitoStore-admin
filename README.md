# Aplicación Admin - Tienda Dibujito

Esta es la aplicación de administración para la Tienda Dibujito. Está desarrollada en Java y se conecta a una base de datos MySQL para gestionar los datos de la tienda.

## 📋 Requisitos Previos

Para ejecutar este proyecto, necesitarás tener instalado:

*   **Java Development Kit (JDK):** Versión 8 o superior.
*   **MySQL:** Un servidor MySQL al cual conectarse.

## ⚙️ Configuración

Antes de ejecutar la aplicación, debes configurar las credenciales de la base de datos. 

1. En la raíz del proyecto, crea o verifica que exista un archivo llamado `config.properties`.
2. Edita el archivo `config.properties` con tus datos de conexión. Por seguridad, este archivo es ignorado por Git y no se sube al repositorio:

```properties
db.url=jdbc:mysql://<TU_HOST>:<PUERTO>/<NOMBRE_BD>
db.user=<TU_USUARIO>
db.password=<TU_CONTRASEÑA>
```

## 🚀 Cómo Ejecutar

1. Clona o descarga este repositorio en tu computadora.
2. Abre el proyecto utilizando tu IDE de Java preferido (como NetBeans, Eclipse, IntelliJ IDEA o VS Code).
3. Asegúrate de tener el archivo `config.properties` configurado correctamente en la raíz del proyecto.
4. Ejecuta la clase principal de la aplicación.

## 🔒 Seguridad

*   Nunca compartas tu archivo `config.properties` públicamente.
*   El archivo `.gitignore` ya está configurado para evitar que las credenciales de la base de datos se suban a GitHub.
