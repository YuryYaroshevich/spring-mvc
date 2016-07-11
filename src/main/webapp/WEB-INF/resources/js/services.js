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
            }, function(msg) {
            	if (msg.data.error) {
            		console.log(msg.data.message);
            	}
            });
            return delay.promise;
        };
    }
]);

services.factory('Auditorium', ['$resource', function ($resource) {
	return $resource('auditorium/:id', {id: '@id'}, {update: {
        method: 'PUT'
    }});
}]);

services.factory('Auditoriums', ['$q', 'Auditorium', function ($q, Auditorium) {
	return function () {
		var delay = $q.defer();
		Auditorium.query(function (auditoriums) {
			delay.resolve(auditoriums);
		});
		return delay.promise;
	};
}]);


services.factory('Timetable', ['$resource', function ($resource) {
	return $resource('timetable/:id', {id: '@id'}, {
		assignAuditorium: {
			method: 'PUT'
		}
	});
}]);