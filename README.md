# Documentacion

Deben estar disponibles los puestos 8080 y 4848

Debe ingresar por medio del navegador a la url " http://localhost:8080/frontend-1.0-SNAPSHOT/ "

Listado de Palabras a Funcionar en el sistema

-  arroz  - rice
-  perro  - dog
-  gato   - cat
-  pajaro - pajaro
-  carro  - car
-  correr - run
-  abeja - bee

Pueden ser ingresadas en cualquiera de los dos idiomas, este devolvera la traduccion.

# Para correrlo debera usar los siguientes dos comandos.
Debera apoyarse de los dos WAR FILES y del DockerFile

docker build -t os .

docker run -p 8080:8080 -p 4848:4848 os

# Si descarga desde Docker Hub
Debera usar el siguiente comando.

docker run -p 8080:8080 -p 4848:4848 kincho23/os:os
