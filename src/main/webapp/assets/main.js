var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'test',
            controller: 'homeCtrl'
        })
        .when('/orders', {
            templateUrl: 'orders',
            controller: 'homeCtrl'
        })
        .when('/employee', {
            templateUrl: 'employee',
            controller: 'homeCtrl'
        })
        .when('/newOrder', {
            templateUrl: 'newOrder',
            controller: 'homeCtrl'
        })
        .when('/autentification', {
            templateUrl: 'autentification',
            controller: 'homeCtrl'
        })
        .when('/planetBase', {
            templateUrl: 'planetBase',
            controller: 'homeCtrl'
        })
        .when('/priceList', {
            templateUrl: 'priceList',
            controller: 'homeCtrl'
        })
        .when('/signUp', {
            templateUrl: 'signUp',
            controller: 'homeCtrl'
        })
        .when('/indexx', {
            templateUrl: 'indexx',
            controller: 'homeCtrl'
        }).when('/Workers', {
        templateUrl: 'workers',
        controller: 'homeCtrl'
    }).when('/Flights', {
        templateUrl: 'flights',
        controller: 'homeCtrl'
    }).when('/Ships', {
        templateUrl: 'ships',
        controller: 'homeCtrl'
    }).when('/atmosphere', {
        templateUrl: 'atmosphere',
        controller: 'homeCtrl'
    }).when('/planet', {
        templateUrl: 'planet',
        controller: 'homeCtrl'
    })

});

app.controller('homeCtrl', function ($scope) {
    console.log('HomeCtrl');
    $scope.model = {
        message: 'This is my beautifull homepage'
    }
});
