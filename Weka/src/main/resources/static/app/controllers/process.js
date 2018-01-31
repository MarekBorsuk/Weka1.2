'use strict';

angular.module('WekaApp')
// Creating the Angular Controller
.controller('ProcessController', function($http, $scope) {
	
	$scope.selectedUploadFile;
	$scope.uploadFile = function(){
		var formData = new FormData();
		formData.append('file', $scope.selectedUploadFile);
		$http.post('api/process', formData,{
			transformRequest: angular.identiry,
			headers: {'Content-Type': undefined}
		}).success(function(){
			console.info('success upload file');
		});
		
	};	
});
