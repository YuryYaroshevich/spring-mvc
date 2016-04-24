'use strict';

var directives = angular.module('directives', []);

directives.directive('multipleDatePicker',[function () {
    return {
        restrict: 'E',
        replace: true,
        templateUrl: 'resources/js/templates/multiple-date-picker.html',
        scope: {
            dates: '='
        },
        link: function (scope) {
            var elem0 = angular.element(document.querySelector('#datetimepicker0'));
            angular.element(elem0).triggerHandler('datetimepicker');
            scope.showRemoveDateInput = false;
            scope.addDateInput = function () {
                var dates = scope.dates;
                dates.push('');
                scope.showRemoveDateInput = true;
                var lastIndex = dates.length - 1;
                var elem = angular.element(document.querySelector('#datetimepicker' + lastIndex));
                angular.element(elem).triggerHandler('datetimepicker');
            };
            scope.removeDateInput = function () {
                var dates = scope.dates;
                if (dates.length > 1) {
                    dates.pop();
                } 
                if (dates.length < 2){
                    scope.showRemoveDateInput = false;
                }
            };
        }
    };
}]);