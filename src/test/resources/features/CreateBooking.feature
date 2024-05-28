# language: es
Característica:  quiero realizar la creación de una solicitud de servicio para segundas veces

  @LISTCASESALTERNATIVE
  Esquema del escenario: Crear dos reservas de libros usando el token de autenticación

    Dado Que se requiere conocer la informacion detallada de las solicitud
      | username   | password   |
      | <username> | <password> |
    Cuando Se hace la busqueda del estado de solicitud con un solo filtro
    Y Se crean las reservas con los datos proporcionados
      | firstname | lastname             | totalprice | depositpaid | checkin     | checkout    | additionalneeds |
      | Pedro     | Gutierrez Jaramillo  | 100        | true        | 2024-03-01  | 2024-04-01  | Comics          |
      | Javier    | Gutierrez Jaramillo  | 356        | true        | 2024-03-15  | 2024-04-15  | Terror          |
    Entonces El código de respuesta debe ser 200
    Y El nombre en la respuesta debe ser "Pedro" para el primer libro
    Y El nombre en la respuesta debe ser "Javier" para el segundo libro

    Ejemplos:
      | username | password    |
      | admin    | password123 |