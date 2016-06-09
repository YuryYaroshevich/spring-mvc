'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Event', ['$resource', function ($resource) {
    return $resource('event/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}]);

services.factory('Events', ['$q', 'Event', function ($q, Event) {
    return function () {
        var delay = $q.defer();
        Event.query(function (events) {
            delay.resolve(events);
        });
        return delay.promise;
    };
}]);


services.factory('EventLoader', ['Event', '$q',
    function(Event, $q) {
        return function(eventId) {
            var delay = $q.defer();
            Event.get({
                id: eventId
            }, function(event) {
                delay.resolve(event);
            }, function() {
                delay.reject('Unable to load event with id = ' + eventId);
            });
            return delay.promise;
        };
    }
]);