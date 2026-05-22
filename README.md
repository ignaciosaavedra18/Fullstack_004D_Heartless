Heartless registro de libros

Descripcion:

Heartless es una aplicación desarrollada en Java con Spring Boot inspirada en plataformas de seguimiento y recomendación de libros como Booksmory. El sistema está enfocado en la gestión de libros, autores y reseñas, permitiendo organizar información literaria de forma simple, ordenada y eficiente.

La aplicación busca ofrecer una experiencia similar a una biblioteca digital personal, donde los usuarios pueden registrar libros, asociarlos con sus autores y almacenar reseñas u opiniones sobre cada lectura. Para ello, se implementó una arquitectura basada en capas utilizando API REST, facilitando la organización del código y la comunicación con la base de datos.

Este proyecto fue desarrollado con fines académicos para aplicar conocimientos de desarrollo Fullstack, Spring Boot, manejo de bases de datos MySQL y construcción de servicios RESTful, siguiendo buenas prácticas de programación y estructura de software.


Descripción del proyecto: 

Tecnologías utilizadas
Arquitectura del proyecto
Requisitos
Configuración de base de datos
Cómo ejecutar el proyecto
URL base de la API
Endpoints disponibles
Estructura del proyecto
Explicación por capas
Manejo global de errores
WebClient y API externa
Dependencias principales
Colección Postman
Flujo general de la aplicación
Integrantes

1️) Descripción del Proyecto
Heartless es una API REST desarrollada con Spring Boot que permite administrar:
Autores
Libros
Reseñas
Consumo de API externa de clima
El proyecto utiliza:
Arquitectura por capas
Persistencia con JPA/Hibernate
Base de datos MySQL
Validaciones
Manejo global de excepciones
Consumo de APIs externas mediante WebClient

2️) Tecnologías Utilizadas
Tecnología
Uso
Java 17
Lenguaje principal
Spring Boot 3
Framework backend
Spring Web
API REST
Spring Data JPA
Persistencia
Hibernate
ORM
MySQL
Base de datos
Lombok
Reducción de código repetitivo
Maven
Gestión de dependencias
WebClient
Consumo de API externa
Postman
Pruebas de endpoints


3️) Arquitectura del Proyecto
El proyecto utiliza arquitectura por capas:
controller   → Endpoints REST
service      → Lógica de negocio
repository   → Acceso a datos
model        → Entidades JPA
dto          → Transferencia de datos
config       → Configuración
exception    → Manejo global de errores


4️) Requisitos
Antes de ejecutar el proyecto necesitas:
Java 17
MySQL Server
Maven (opcional si usas Maven Wrapper)
IDE recomendado:
IntelliJ IDEA
VS Code
Eclipse
Postman (opcional)

5️) Configuración de Base de Datos
Archivo:
src/main/resources/application.properties

Configuración utilizada:
spring.application.name=heartless

spring.datasource.url=jdbc:mysql://localhost:3306/heartless?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

openmeteo.base-url=https://api.open-meteo.com

 Explicación
Configuración
Descripción
createDatabaseIfNotExist=true
Crea automáticamente la base de datos
ddl-auto=update
Actualiza tablas automáticamente
show-sql=true
Muestra consultas SQL en consola
openmeteo.base-url
URL de la API externa


6️) Cómo Ejecutar el Proyecto
 Opción 1 — Maven Wrapper (Recomendado)
Windows
.\mvnw.cmd spring-boot:run

Linux / macOS
./mvnw spring-boot:run


 Opción 2 — Ejecutar JAR
Compilar
./mvnw clean package

Ejecutar
java -jar target/heartless-0.0.1-SNAPSHOT.jar


7️) URL Base de la API
http://localhost:8080


8️) Endpoints Disponibles
 Autores
Ruta base:
/api/v1/autores

Método
Endpoint
Descripción
GET
/api/v1/autores
Obtener todos los autores
GET
/api/v1/autores/{id}
Obtener autor por ID
POST
/api/v1/autores
Crear autor
PUT
/api/v1/autores/{id}
Actualizar autor
DELETE
/api/v1/autores/{id}
Eliminar autor

JSON ejemplo
{
  "nombre": "Gabriel García Márquez",
  "nacionalidad": "Colombiana"
}


 Libros
Ruta base:
/api/v1/libros

Método
Endpoint
Descripción
GET
/api/v1/libros
Obtener todos los libros
GET
/api/v1/libros/{id}
Obtener libro por ID
POST
/api/v1/libros/{autorId}
Crear libro asociado a un autor
PUT
/api/v1/libros/{id}
Actualizar libro
DELETE
/api/v1/libros/{id}
Eliminar libro

JSON ejemplo
{
  "isbn": "9789561234567",
  "titulo": "Clean Code",
  "editorial": "Prentice Hall",
  "fechaPublicacion": 2008
}


 Reseñas
Ruta base:
/api/v1/resenas

Método
Endpoint
Descripción
GET
/api/v1/resenas
Obtener todas las reseñas
GET
/api/v1/resenas/{id}
Obtener reseña por ID
POST
/api/v1/resenas/{libroId}
Crear reseña asociada a un libro
PUT
/api/v1/resenas/{id}
Actualizar reseña
DELETE
/api/v1/resenas/{id}
Eliminar reseña

JSON ejemplo
{
  "comentario": "Excelente libro",
  "calificacion": 5
}


API de Clima
Ruta base:
/api/v1/clima

Método
Endpoint
Descripción
GET
/api/v1/clima
Obtener clima actual

Parámetros opcionales
Parámetro
Tipo
lat
double
lon
double

Ejemplo
GET /api/v1/clima?lat=-33.45&lon=-70.65


9️) Estructura del Proyecto
src/main/java/com/duoc/heartless/

├── config/
│   └── WebClientConfig.java
│
├── controller/
│   ├── AutorController.java
│   ├── LibroController.java
│   ├── ResenaController.java
│   └── WeatherController.java
│
├── dto/
│   └── WeatherDTO.java
│
├── exception/
│   └── GlobalExceptionHandler.java
│
├── model/
│   ├── Autor.java
│   ├── Libro.java
│   └── Resena.java
│
├── repository/
│   ├── AutorRepository.java
│   ├── LibroRepository.java
│   └── ResenaRepository.java
│
├── service/
│   ├── AutorService.java
│   ├── LibroService.java
│   ├── ResenaService.java
│   └── WeatherService.java
│
└── HeartlessApplication.java


10) Explicación por Capas
controller
Contiene los endpoints REST de la aplicación.
Controladores implementados:
AutorController
LibroController
ResenaController
WeatherController

service
Contiene la lógica de negocio.
Servicios implementados:
AutorService
LibroService
ResenaService
WeatherService

repository
Contiene el acceso a datos utilizando Spring Data JPA.
Repositorios:
AutorRepository
LibroRepository
ResenaRepository
Todos extienden:
JpaRepository<T, ID>


model
Representa las entidades de la base de datos.
Entidades:
Autor
Libro
Resena
Anotaciones utilizadas:
@Entity
@Id
@GeneratedValue
@NotBlank
@NotNull


1️1️) Manejo Global de Errores
El proyecto utiliza:
@RestControllerAdvice

Archivo:
exception/GlobalExceptionHandler.java

Permite centralizar excepciones y evitar múltiples bloques try-catch.

1️2) WebClient y API Externa
El proyecto consume la API externa Open-Meteo utilizando WebClient.
Archivo de configuración:
config/WebClientConfig.java

Servicio:
service/WeatherService.java

Ejemplo:
weatherWebClient.get()
.uri(...)
.retrieve()
.bodyToMono(WeatherDTO.class)
.block();


1️3️) Dependencias Principales
Dependencias utilizadas:
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-validation
spring-boot-starter-webflux
mysql-connector-j
lombok


1️4️) Colección Postman
El proyecto incluye colección Postman para probar endpoints.
Incluye pruebas para:
Autores
Libros
Reseñas
API de clima

1️5️) Flujo General de la Aplicación
Cliente
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL


1️6️) Integrantes
Ignacio Saavedra
Francisca Benitez
Hernaldo Silva

