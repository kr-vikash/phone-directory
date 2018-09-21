'use strict'

var mymodule = angular.module('edit.controllers', []);

mymodule.controller('PopupCtrl',function ($scope, $uibModalInstance, contact2,UserService) {
    function contactDatas(){
        UserService.getAllData().then(function (value) {

            $scope.allDatas= value.data;
            $scope.qDatas=value.data;
        });
    }
    $scope.editData={
        id:null,
        firstName:null,
        middleName:null,
        lastName:null,
        phoneNumber:null,
        contactType:null
    };
    $scope.editData.id = contact2.id;
    $scope.editData.firstName = contact2.firstName;
    $scope.editData.middleName = contact2.middleName;
    $scope.editData.lastName = contact2.lastName;
    $scope.editData.phoneNumber = contact2.phoneNumber;
    $scope.editData.contactType = contact2.contactType;
    $scope.close = function () {
        $uibModalInstance.close(false);
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
    $scope.updateData=function () {

        UserService.updateQueryData($scope.editData).then(function (value) {
            contactDatas();
        });
        $uibModalInstance.close(false);
    };
});
