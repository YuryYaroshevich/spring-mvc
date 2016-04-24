'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('EventsCtrl', ['$scope', 'events', 
    function ($scope, events) {
        $scope.events = events;
    }]);