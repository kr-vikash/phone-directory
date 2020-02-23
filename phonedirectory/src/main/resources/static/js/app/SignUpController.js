'use strict'

var module = angular.module('signup.controllers', []);
module.controller("SignUpController", [ "$scope", "$location","UserService", "$http","$window",
			function($scope,$location, UserService, $http,$window) {
           	$scope.user={
	        	username:"sw",
				email:null,
				password:null
			};
            $scope.confirmPassword=null;


              $scope.createUser =function(){
                 if($scope.confirmPassword!= $scope.user.password){
                   console.log("password not same");
                    return;
                 }
                 UserService.createUserAccount($scope.user).then(function (value) {
                             let host = $window.location.href;
                             let landingUrl = host.replace("signup","login");
                             $window.location.href = landingUrl;

                         });
              };

            } ]);