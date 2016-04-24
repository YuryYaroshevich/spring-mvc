'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Event', ['$resource', function ($resource) {
    return $resource('event');
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