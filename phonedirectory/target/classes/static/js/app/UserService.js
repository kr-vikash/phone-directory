'use strict'

angular.module('demo.services', []).factory('UserService',
		[ "$http", function($http) {
			var service = {};
			service.sendQueryData= function (queryData) {
				return $http.post("/detail/create", queryData);
            };
            service.getAllData= function () {
                return $http.get("/detail/all");
            };
            service.sendDeleteData= function (id) {
                return $http.delete("/detail/"+id);
            };
            service.updateQueryData=function (updatedData) {
                return $http.put("/detail/update",updatedData);
            };

            service.createUserAccount= function (user) {
                 return $http.post("/api/signup", user);
            }
            service.loginPage= function () {
                             return $http.get("/login");
            }

			return service;
		} ]);