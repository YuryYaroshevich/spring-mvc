'use strict';

angular
    .module('springmvc', [
        'ngResource',
        'controllers',
        'services',
        'directives',
        'ui.router'])
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');
        
        $stateProvider
        .state('events', {
            url: '/',
            templateUrl: 'resources/views/events.html',
            controller: 'EventsCtrl',
            resolve: {
                events: function (Events) {
                    return Events();
                }
            }
        })
        .state('addEvent', {
            url: '/addEvent',
            templateUrl: 'resources/views/addEvent.html',
            controller: 'AddEventCtrl'
        })
        .state('viewEvent', {
            url: '/view/:id',
            templateUrl: 'resources/views/event.html',
            controller: 'ViewEventCtrl',
            resolve: {
                event: function(EventLoader, $stateParams) {
                    return EventLoader($stateParams.id);
                },
                auditoriums: function(Auditoriums) {
                	return Auditoriums();
                }
            }
        })
    });