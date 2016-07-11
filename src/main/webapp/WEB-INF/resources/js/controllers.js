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
        	Event.remove({id: event.id}, function () {
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

controllers.controller('ViewEventCtrl', ['$scope','$state', '$uibModal', 
                                         'Event', 'event', 'auditoriums',
                                         'Timetable',
    function ($scope, $state, $uibModal, Event, event, auditoriums, Timetable) {
        $scope.event = event;
        
        /*$scope.$watch('$state.$current.locals.globals.event', function (event) {
            $scope.event = event;
        });*/
        
        $scope.removeEvent = function (event) {
        	Event.remove({id: event.id}, function (msg) {
        		console.log(msg);
        		$state.go('events');
        	}, function (error) {
        		console.log(error);
        	});
        };
        
        $scope.assignAuditorium = function () {
        	var modalInstance = $uibModal.open({
            	animation: true,
            	templateUrl: 'resources/js/templates/modal/content.html',
            	controller: 'AuditoriumModalCtrl',
            	size: 'modal-sm',
            	resolve: {
    	        	auditoriums: function () {
    	        		return auditoriums;
    	        	}
            	},
            	backdrop: 'static'
            });
        	
        	modalInstance.result.then(function (selectedAuditorium) {
        		Timetable.assignAuditorium({id: $scope.event.id, auditoriumId: selectedAuditorium.id}, 
        				function (data) {
        					console.log(data);
        					$state.reload();
        				},
        				function (error) {
        					console.log(data);
        				}
        		);
            });
        };
    }]);

controllers.controller('AuditoriumModalCtrl', ['$scope', '$uibModalInstance', 'auditoriums', 
    function ($scope, $uibModalInstance, auditoriums) {
		$scope.auditoriums = auditoriums;
		
		$scope.selected = {
			selectedIndex: 0
		};
		$scope.select = function () {
			$uibModalInstance.close($scope.auditoriums[$scope.selected.selectedIndex]);
		};

		$scope.cancel = function () {
			$uibModalInstance.dismiss();
		};
}]);