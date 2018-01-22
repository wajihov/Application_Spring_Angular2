var app = angular.module("myApp", ["ui.router"]);

app.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider.state('home', {
    url: 'home',
    templateUrl: "vues/home.html",
    controller: 'HomeController'
  })
});

app.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider.state('chercher', {
    url: 'chercher',
    templateUrl: "vues/chercher.html",
    controller: 'myController'
  })
});

app.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider.state('newProduit', {
    url: 'newProduit',
    templateUrl: "vues/newProduit.html",
    controller: 'newProduitController'
  });
});


app.controller("HomeController", function() {});

app.controller("newProduitController", function($scope, $http) {
  $scope.produit = {};
  $scope.mode = 0;
  $scope.saveProduit = function() {
    $http({
      method: "post",
      url: "http://localhost:8080/produits",
      data: $scope.produit
    }).then(function(response) {
      data = response.data;
      $scope.produit = data;
      alert("dans ajouter : " + data);
      $scope.mode = 1;
    }), function(reason) {
      console.log("Failed : " + reason);
      alert("Failed : " + reason);
    }
  }
  $scope.modeForm = function() {
    $scope.mode = 0;
  }
/*$scope.saveProduit = function() {
  $http.post("http://localhost:8080/produits", $scope.produit)
    .success(function(data) {
      alert("les donnée sont : " + data);
    }).error(function(error) {
    console.log("l 'erreur est la suivante : " + error);
  })
}*/
});

app.controller("myController", function($scope, $http) {
  $scope.produitS = null;
  $scope.motCle = "";
  $scope.pageCourante = 0;
  $scope.size = 6;
  $scope.pages = [];
  $scope.chercherProduit = function() {
    $http({
      method: "GET",
      url: "http://localhost:8080/findProducts?mc=" + $scope.motCle + "&page=" + $scope.pageCourante + "&size=" + $scope.size
    }).then(function(response) {
      data = response.data;
      $scope.produitS = data;
      $scope.pages = new Array(data.totalPages);
    }), function(error) {
      console.log(error);
    }
  }
  $scope.getProduit = function() {
    $scope.pageCourante = 0;
    $scope.chercherProduit();
  }
  $scope.gotopages = function(p) {
    $scope.pageCourante = p;
    $scope.chercherProduit();
  }
});