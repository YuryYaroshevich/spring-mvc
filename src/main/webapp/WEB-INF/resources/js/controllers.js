'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('EventsCtrl', ['$scope', 'events', 'Event', 
    function ($scope, events, Event) {
        $scope.events = events;
        
        $scope.removeEvent = function (event) {
        	Event.remove(event, function (msg) {
        		console.log(msg);
        		$state.go('events');
        	}, function (error) {
        		console.log(error);
        	});
        };
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

controllers.controller('ViewEventCtrl', ['$scope', 'event',
    function ($scope, event) {
        $scope.event = event;
    }]);