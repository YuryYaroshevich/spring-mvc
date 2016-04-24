'use strict';

angular
    .module('springmvc', [
        'ngResource',
        'controllers',
        'services',
        'ui.router'])
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');
        
        $stateProvider.state('events', {
            url: '/',
            templateUrl: 'resources/views/events.html',
            controller: 'EventsCtrl',
            resolve: {
                events: function (Events) {
                    return Events();
                }
            }
        });
    });