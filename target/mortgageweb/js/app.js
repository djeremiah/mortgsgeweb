'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('ngdemo', [ 'ngdemo.services', 'ngdemo.controllers']);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/Admin', {templateUrl: 'partials/admin-createprocess.html', controller: 'AdminProcCtrl'});
        $routeProvider.when('/Cases', {templateUrl: 'partials/caseInstances.html', controller: 'caseCtrl' });
		$routeProvider.when('/usertasks', {templateUrl: 'partials/usertasks.html', controller: 'UserTaskCtrl'});
		$routeProvider.when('/Payment', {templateUrl: 'partials/Payment.html', controller: 'caseCtrl'});
		$routeProvider.when('/Promo', {templateUrl: 'partials/promo.html', controller: 'caseCtrl'});

        $routeProvider.otherwise({redirectTo: '/Cases'});
    }]);
