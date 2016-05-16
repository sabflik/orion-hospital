// Athena angularjs app
// loads config and routing
angular.module('springtemplate', ['ui.router'])
.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('dashboard', {
            abstract: true,
            templateUrl: '/templates/dashboard.html'
        })
        .state('dashboard.welcome', {
            url: '/welcome',
            templateUrl: '/templates/dashboard-welcome.html',
            controller: 'DashboardWelcomeCtrl'
        });

    // For any unmatched url, redirect to /welcome
    $urlRouterProvider.otherwise("/welcome");
});