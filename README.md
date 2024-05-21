# Desafio Tecnico.

GeoIpService

# Prerequisitos

Ambiente de desarrollo:
- Apache maven 3.8.x o superior
- Editor de codigo de preferencia(ej. Intellij Community)
- Java 17

# Generalidades

El proposito del servicio es reunir informacion de una ip suministrada, para coordinar acciones en respuesta ante fraudes.

Se conecta con varias apis publicas para generar una estructura que ayude a identificar el comportamiento de una ip(Pais, fecha de ejecucion, fecha del pais, etc..)

El servicio tambien expone una operacion para las estadisticas:

    - Distancia mas lejana a Buenos Aires
    - Distancian mas cercana a Buenos Aires
    - Distancia promedio con todas las ejecuciones

El servicio esta conectado con la herramienta gratuita de Circle CI para verificar la compilacion del proyecto

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs/tree/teesloane-patch-5.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs/?branch=teesloane-patch-5)

[![CircleCI](https://circleci.com/gh/FreelancerATMOS/geoipservice?style=svg)](https://app.circleci.com/pipelines/circleci/bd0b3675-cd1e-482f-bb81-8911af703de4)


[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)

## Consumo del servicio



# Informacion del servicio

### Swagger del servicio
![](asset/Swagger.png)

### Reporte cobertura Jacoco
![](asset/Jacoco.png)

### Estructura integracion del servicio
![](asset/Estructura.png)

### Diagrama de clases
![](asset/DiagramaDeClases.png)



## BIBLIOGRAFIA:

[SpringBoot](https://spring.io/projects/spring-boot)

[Java](https://www.java.com/es/)


*Por: Michael Ballesteros*
