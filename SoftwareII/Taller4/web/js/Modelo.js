var idFacultad=3;
var facultades=[
    {"id":1, "nombre":"Ingenieria"},
    {"id":2, "nombre":"Licenciatura"}

];
var idCarrera=3;
var carreras=[
    {"id":1, "nombre":"Sistemas", "facultad":{"id":1, "nombre":"Ingenieria"}},
    {"id":2, "nombre":"Ambiental","facultad":{"id":1, "nombre":"Ingenieria"}}
];

var idMunicipio=4;
var municipios=[
    {"id":1, "nombre":"Tunja"},
    {"id":2, "nombre":"Duitama"},
    {"id":3, "nombre":"Sogamoso"},
];

var idEstudiantes=3;
var estudiantes=[
    {"id":1, "nombre":"memo", "apellido":"barrera", "codigo":"201623453", "documento":"12345","fechaNac":"08/09/1994", "carrera":{"id":1, "nombre":"Sistemas"},
    "municipio":{"id":1, "nombre":"Tunja"}},
    {"id":2, "nombre":"guillermo", "apellido":"orjuela", "codigo":"201789012", "documento":"6789","fechaNac":"24/01/1994","carrera":{"id":2, "nombre":"Ambiental"},
    "municipio":{"id":3, "nombre":"Sogamoso"}}
];

var idMateria=3;
var materia=[
    {"id":1, "nombre":"software 2", "creditos":4, "carrera":{"id":1, "nombre":"Sistemas"},"profesor":{"id":1, "nombre":"jorge", "apellido":"otalora", "documento":"100000000"},"horario":{"id":1, "dia_semana":3, "hora_inicio":10, "hora_fin":12}},
    {"id":2, "nombre":"suelos", "creditos":3,"carrera":{"id":2, "nombre":"Ambiental"},"profesor":{"id":2, "nombre":"mauricio", "apellido":"villate", "documento":"2000000"},"horario":{"id":2, "dia_semana":5, "hora_inicio":2, "hora_fin":4}}
];

var idProfesor=2;
var Profesor=[
    {"id":1, "nombre":"jorge", "apellido":"otalora", "documento":"100000000"},
    {"id":2, "nombre":"mauricio", "apellido":"villate", "documento":"2000000"},
];

var idHorario=2;
var horario=[
    {"id":1, "dia_semana":3, "hora_inicio":10, "hora_fin":12},
    {"id":2, "dia_semana":5, "hora_inicio":2, "hora_fin":4},
];

var idMatricula=2;
var matricula=[
    {"id":1, "ano":3, "semestre":10,"materia":{"id":1, "nombre":"software 2", "creditos":4},"estudiante":{"id":1, "nombre":"memo", "apellido":"barrera", "codigo":"201623453", "documento":"12345","fechaNac":"08/09/1994", "carrera":{"id":1, "nombre":"Sistemas"},
    "municipio":{"id":1, "nombre":"Tunja"}}},
];