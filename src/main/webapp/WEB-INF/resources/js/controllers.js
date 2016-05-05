'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('EventsCtrl', ['$scope', 'events', 
    function ($scope, events) {
        $scope.events = events;
    }]);

controllers.controller('AddEventCtrl', ['$scope', 'Event',
    function ($scope, Event) {
        $scope.event = {};
        $scope.dates = [''];
        $scope.createEvent = function () {
            $scope.event.dates = $scope.dates;
            Event.save($scope.event, 
                    function (resp) {
                        console.log(resp);
                    }, function (error) {
                        console.log(error);
                    });
        };
        
    }]);