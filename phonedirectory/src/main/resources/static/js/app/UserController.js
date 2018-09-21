'use strict'

var module = angular.module('demo.controllers', []);
module.controller("UserController", [ "$scope", "UserService","$http","$filter","$uibModal",
			function($scope, UserService, $http, $filter,$uibModal) {
                contactDatas();
              function contactDatas(){
                  UserService.getAllData().then(function (value) {

                      $scope.allDatas= value.data;
                      $scope.qDatas=value.data;
                  });
              }

	        $scope.queryData={
	        	firstName:null,
				middleName:null,
				lastName:null,
				phoneNumber:null,
                contactType:null
			};
                $scope.disableBtn=true;
                $scope.isValidPhoneNo=false;
                $scope.cType=["Home", "Work","Other"];
                $scope.phoneNumbr = /^[1-9]\d{0}\d{9}$/;
                $scope.phoneNoValidation=function(phone){
                    var patt = new RegExp($scope.phoneNumbr);
                    if(patt.test(phone)){
                        $scope.isValidPhoneNo=false;
                        $scope.disableBtn=false;
                    }else{
                        $scope.isValidPhoneNo=true;
                        $scope.disableBtn=true;
                    }
                };

                $scope.getData=function(text) {
                var allData=$scope.allDatas;
                var searchTerms = text.split(' ');
                if (text.length !== 0 && text && allData.length!==0) {
                    searchTerms.forEach(function (term) {
                        if (term && term.length)
                            allData = $filter('filter')(allData, term);
                    });
                }
                    $scope.qDatas = allData;
                };

			$scope.saveData=function () {

			  UserService.sendQueryData($scope.queryData).then(function (value) {
                  if(value.data!=null && value.data!==""){
                      alert("Phone number already exists ");
                  }else {
                      $scope.queryData=null;
                  }
                  contactDatas();
              });
            };
			$scope.deleteData=function (id) {
                   console.log(id+"here");
                UserService.sendDeleteData(id).then(function (value) {
                    $scope.allDatas= value.data;
                    $scope.qDatas=value.data;
                });

            };
                $scope.edit = function (contact) {
                    var modalInstance = $uibModal.open({
                        templateUrl: '/views/popup.html',
                        controller: 'PopupCtrl',
                        resolve: {
                            contact2: function () {
                                return contact;
                            }
                        }
                    });
                }

            } ]);