var app = angular.module("myApp", [ "ui.router" ]);

app.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('home', {
		url : '/home',
		templateUrl : "views/home.html",
		controller : 'HomeController'
	});
	$stateProvider.state('chercher', {
		url : '/chercher',
		templateUrl : 'views/chercher.html',
		controller : 'MyControllor'
	});
	$stateProvider.state('newProduit', {
		url : '/newProduit',
		templateUrl : 'views/newProduit.html',
		controller : 'newProduitController'
	});

});
/*app.controller("MyControllor", function($scope, $http) {
$scope.produitS = null;
$http.get("http://localhost:8081/findProducts?mc=").success(function(data) {
	$scope.produitS = data;
}).error(function(error) {
	console.log("erreur de données " + error);
})
});*/

app.controller('HomeController', function() {})
app.controller('newProduitController', function($scope, $http) {
	$scope.produit = {};
	$scope.saveProduit = function() {
		$http({
			method : "post",
			url : "http://localhost:8080/produits",
			data : $scope.produit
		}).then(function(response) {
			data = response.data;
			$scope.produit = data;
			alert("dans ajouter : " + data);
		}),function(reason){
			console.log("Failed : "+reason);
			alert("Failed : "+reason);
		}
		}
		});
	
/*	$scope.modeForm = function() {
		$scope.produit = {
			designation : "",
			prix : 0.0,
			quantite : 0
		};
		$scope.mode = 0;
	}
});*/
app.controller("MyControllor", function($scope, $http) {
	$scope.produitS = null;
	$scope.motCle = "";
	$scope.pageCourante = 0;
	$scope.size = 4;
	$scope.pages = [];
	$scope.getProduit = function() {
		$scope.pageCourante = 0;
		$scope.ChercherProduit();
	}
	$scope.ChercherProduit = function() {
		$http({
			method : 'get',
			url : "http://localhost:8080/findProducts?mc=" + $scope.motCle + "&page=" + $scope.pageCourante
				+ "&size=" + $scope.size
		}).then(function(response) {
			console.log(response, "res");
			data = response.data;
			$scope.produitS = data;
			$scope.pages = new Array(data.totalPages);
		}, function(error) {
			console.log(error, "can not get data");
		});
	}
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.ChercherProduit();
	}

});