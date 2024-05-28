# language: es
Característica:  quiero eliminar libros creados

  @LISTCASESALTERNATIVE
  Esquema del escenario: Eliminar libros creados
    Dado Que se requiere conocer la informacion detallada de las solicitud
      | username   | password   |
      | <username> | <password> |
    Y Que se requiere eliminar los libros creados
    Cuando Se consume el servicio DeleteBooking para eliminar los libros
   # Entonces El código de respuesta debe ser 201
   # Y La respuesta del servicio debe ser "Created"

    Ejemplos:
      | username | password    |
      | admin    | password123 |