'use strict';

module.controller('MatriculaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = matricula;
        $scope.datosFormulario = {};
        $scope.panelEditar = false;
        $scope.listaMateria = materia;
        $scope.listaMateriaMod = materia;
        $scope.listaEstudiante = estudiantes;

        $scope.validarCarrera = function () {
            
           $scope.listaMateria = $scope.listaMateriaMod;
           $scope.listaMateriaTmp = new Array();
           
            for (var i = 0; i< $scope.listaMateria.length; i++){
                if ( $scope.datosFormulario.estudiante.carrera.nombre==$scope.listaMateria[i].carrera.nombre){
                  $scope.listaMateriaTmp.push($scope.listaMateria[i]);
                } 
            }
//              alert( $scope.listaMateriaTmp.length); 
              
              $scope.listaMateria = $scope.listaMateriaTmp;
                 
        };

        //guardar
        $scope.nuevo = function () {
            $scope.panelEditar = true;
            $scope.datosFormulario = {};
        };

        $scope.guardar = function () {
            var index = $scope.lista.indexOf($scope.datosFormulario);
            if (index === -1) {
                $scope.datosFormulario.id = idMatricula++;
                $scope.lista.push($scope.datosFormulario);
            }
            $scope.panelEditar = false;
        };

        $scope.cancelar = function () {
            $scope.panelEditar = false;
            $scope.datosFormulario = {};
        };

        //editar
        $scope.editar = function (data) {
            $scope.panelEditar = true;
            $scope.datosFormulario = data;
        };
        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                var index = $scope.lista.indexOf($scope.datosFormulario);
                if (index > -1) {
                    $scope.lista.splice(index, 1);
                }
            }
        };

    }]);