#language: es
Característica:  quiero realizar la creación de una solicitud de servicio para segundas veces

  @LISTCASESALTERNATIVE
  Esquema del escenario: Realizo una consulta donde el usuario existe en listas de control

    Dado Que se requiere conocer la informacion detallada de las solicitud
      | username   | password   |
      | <username> | <password> |
    Cuando Se hace la busqueda del estado de solicitud con un solo filtro

    Ejemplos:
      | username | password    |
      | admin    | password123 |