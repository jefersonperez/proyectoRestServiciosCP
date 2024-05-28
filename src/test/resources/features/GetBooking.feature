# language: es
Característica: Consultar libros creados

  Esquema del escenario: Consultar libros creados


    Cuando Se consultan los libros creados
    Entonces El código de respuesta debe ser 200
    Y El nombre en la respuesta debe ser "Pedro" para el primer libro
    Y El nombre en la respuesta debe ser "Javier" para el segundo libro

