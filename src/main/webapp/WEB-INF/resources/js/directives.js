'use strict';

var directives = angular.module('directives', ['ui.bootstrap', 'ui.bootstrap.datetimepicker']);

directives.directive('multipleDatePicker',[function () {
    return {
        restrict: 'E',
        replace: true,
        templateUrl: 'resources/js/templates/multiple-date-picker.html',
        scope: {
            dates: '='
        },
        link: function (scope) {
            var DatePicker = function DatePicker (index) {
                this.index = index;
            };
            DatePicker.prototype.openCalendar = function (index) {
                scope.datePickers[index].open = true;
            };
            
            scope.datePickers = [new DatePicker(0)];
            
            scope.showRemoveDateInput = false;
            scope.addDateInput = function () {
                scope.datePickers.push(new DatePicker(scope.datePickers.length));
                var dates = scope.dates;
                dates.push('');
                scope.showRemoveDateInput = true;
                var lastIndex = dates.length - 1;
            };
            scope.removeDateInput = function () {
                scope.datePickers.pop();
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