'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('EventsCtrl', ['$scope', 'events', 
    function ($scope, events) {
        $scope.events = events;
    }]);

controllers.controller('AddEventCtrl', ['$scope', 'Event', '$state',
    function ($scope, Event, $state) {
        $scope.event = {};
        $scope.dates = [''];
        $scope.createEvent = function () {
            Event.save({dates: $scope.dates}, $scope.event, function (event) {
                $state.go('viewEvent', {id: event.id});
            }, function (error) {
                console.log(error);
            });
            
        };
    }]);

controllers.controller('ViewEventCtrl', ['$scope', 'Event', '$stateParams',
    function ($scope, event, $stateParams) {
        $scope.event = event;
    }]);