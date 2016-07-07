'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('EventsCtrl', ['$scope', '$state', 'events', 'Event', 
    function ($scope, $state, events, Event) {
        $scope.events = events;
        $scope.$state = $state;
        
        $scope.$watch('$state.$current.locals.globals.events', function (events) {
            $scope.events = events;
        });
        
        $scope.removeEvent = function (event) {
        	Event.remove({id: event.id}, function (msg) {
        		console.log(msg);
        		$state.reload();
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