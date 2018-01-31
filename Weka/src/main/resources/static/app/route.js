angular.module('WekaApp').config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/page-not-found');
	$stateProvider.state('nav', {
		abstract : true,
		url : '',
		views : {
			'nav@' : {
				templateUrl : 'app/views/nav.html',
				controller : 'NavController'
			}
		}
	}).state('login', {
		parent : 'nav',
		url : '/login',
		views : {
			'content@' : {
				templateUrl : 'app/views/login.html',
				controller : 'LoginController'
			}
		}
	}).state('users', {
		parent : 'nav',
		url : '/users',
		data : {
			role : 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/users.html',
				controller : 'UsersController',
			}
		}	
	}).state('process', {
		parent : 'nav',
		url : '/process',
		views : {
			'content@' : {
				templateUrl : 'app/views/process.html',
				controller : 'ProcessController'	
			}
		}
	}).state('cluster', {
		parent : 'nav',
		url : '/cluster',
		views : {
			'content@' : {
				templateUrl : 'app/views/cluster.html',
				controller : 'ClusterController'
			}
		}
	}).state('about', {
		parent : 'nav',
		url : '/about',
		views : {
			'content@' : {
				templateUrl : 'app/views/about.html',
				controller : 'AboutController'
			}
		}
	}).state('classify', {
		parent : 'nav',
		url : '/classify',
		views : {
			'content@' : {
				templateUrl : 'app/views/classify.html',
				controller : 'ClassifyController'
			}
		}
	}).state('page-not-found', {
		parent : 'nav',
		url : '/page-not-found',
		views : {
			'content@' : {
				templateUrl : 'app/views/page-not-found.html',
				controller : 'PageNotFoundController'
			}
		}
	}).state('access-denied', {
		parent : 'nav',
		url : '/access-denied',
		views : {
			'content@' : {
				templateUrl : 'app/views/access-denied.html',
				controller : 'AccessDeniedController'
			}
		}
	}).state('register', {
		parent : 'nav',
		url : '/register',
		views : {
			'content@' : {
				templateUrl : 'app/views/register.html',
				controller : 'RegisterController'
			}
		}
	});
});