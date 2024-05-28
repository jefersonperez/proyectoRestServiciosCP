# language: es
Característica: deseo actualizar los libros


  @UPDATEBOOKING
  Escenario: Actualizar dos reservas de libros usando el token de autenticación

    Dado Que se requiere conocer la informacion detallada de las solicitud
      | username   | password   |
      | <username> | <password> |
    Cuando Se hace la busqueda del estado de solicitud con un solo filtro
    Y Se actualizan las reservas con los datos proporcionados
      | bookingid | firstname | lastname           | totalprice | depositpaid | checkin     | checkout    | additionalneeds |
      | 1         | Jose      | Gutierrez Mora     | 100        | true        | 2023-05-12  | 2023-06-28  | Comics          |
      | 2         | Javier    | Gutierrez Mora     | 356        | true        | 2023-06-20  | 2023-07-20  | Terror          |
   # Entonces El código de respuesta debe ser 200
    # Y El nombre en la respuesta debe ser "Jose" para el primer libro
   # Y El nombre en la respuesta debe ser "Javier" para el segundo libro

    Ejemplos:
      | username | password    |
      | admin    | password123 |