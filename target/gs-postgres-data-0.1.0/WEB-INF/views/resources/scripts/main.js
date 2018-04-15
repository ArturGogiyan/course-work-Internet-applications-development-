var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/main', {
            templateUrl: 'main',
            controller: 'homeCtrl'
        })
        .when('/start', {
            templateUrl: 'start',
            controller: 'homeCtrl'
        });
    $routeProvider.otherwise({redirectTo: '/start'});
});


app.controller('homeCtrl', function ($scope) {
    console.log('HomeCtrl');
    $scope.model = {
        message: 'This is my homepage'
    }
});
