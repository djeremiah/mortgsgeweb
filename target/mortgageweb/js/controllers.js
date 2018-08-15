'use strict';

/* Controllers */

var app = angular.module('ngdemo.controllers', ['chart.js']);
// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
  app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
      $templateCache.removeAll();
    });
  });
  
 

app.controller('AdminProcCtrl', function($scope, $http,UserTaskService) {
    $scope.CreateProcess = function () {
	
	  $scope.tskState = { show: true }
	  var url = 'http://localhost:8280/mortgageweb/newCase?' + 'downpayment=' + $scope.downpayment + '&yrsofamortization=' + $scope.yrsofamortization + '&name=' + $scope.name + '&annualincome=' + $scope.annualincome + '&ssn=' + $scope.ssn + '&ageofproperty=' + $scope.ageofproperty + '&addressofproperty=' + $scope.addressofproperty + '&locale=' + $scope.locale + '&saleprice=' + $scope.saleprice + '&smsMobile=' + $scope.smsMobile + '&contactPhone=' + $scope.contactPhone + '&emailId=' + $scope.emailId ;
	  
	  $scope.procStat = UserTaskService.getUserTaskData(url,$scope); 
         
		 if($scope.procStat)
			 
	       $scope.procCreate = {show: true};
    
    }
    $scope.initmortgage = function () {
    	
    	 $scope.downpayment='30000';
    	 $scope.yrsofamortization='30';
    	 $scope.name='Jey';
    	 $scope.ssn='111-11-1112';
    	 $scope.ageofproperty='30';
    	 $scope.addressofproperty='129 West 81st St, 5B, New York, NY 10024';
    	 $scope.saleprice='100000';
    	 $scope.annualincome='80000';
    	 $scope.locale='Urban';
    	 $scope.smsMobile='+16083584153';
    	 $scope.contactPhone='+16083584153';
    	 $scope.emailId='jpaulraj@redhat.com';
  	 
      }
   });
   
	app.controller('caseCtrl', function($scope,$http,$window,caseService) {
		
	
		$scope.openChildWindow = function (id) {
			
			 var url1 = 'http://localhost:8280/mortgageweb/image/?id=' +id;
			  //  $scope.htmlurl ='test2';
			   $http.post(url1).success(function(result) {  
				 // $scope.image = $sce.trustAsResourceUrl(result.data);
		       $scope.htmlurl = result;
		       var left = screen.width / 2 - 150, top = screen.height / 2 - 200
				$window.open('http://localhost:8280/mortgageweb/'+result, '', "top=" + top + ",left=" + left + ",width=800,height=1000")
		       
		    }) 
			
			};
			$scope.openChildWindow1 = function (id) {
				
				 var url1 = 'http://localhost:8280/mortgageweb/imagedisplay/?id=' +id;
				 
			       var left = screen.width / 2 - 150, top = screen.height / 2 - 200
					$window.open(url1, '', "top=" + top + ",left=" + left + ",width=800,height=1000")
		
				};
			

			
		$scope.getAlcases = function () {
			$scope.caseList = { show: true }
			$scope.caseList = true
			var curl = 'http://localhost:8080/kie-server/services/rest/server/queries/containers/mortgage-process_1.0.0-SNAPSHOT/process/instances?sort=&sortOrder=true&status=1&status=0&status=4&page=0&pageSize=10';
		
			//var auth = Base64.encode('rhpamAdmin:jboss$123');
			var auth = btoa('rhpamAdmin:jboss$123');
			//var auth = 'tooluser:jboss$123';
			var config = {
	                headers : {
	                   'Content-Type': 'application/json',
	                   'Authorization': 'Basic ' + auth
	                 //  'Access-Control-Allow-Origin':'*',
	                   //'Access-Control-Allow-Headers':'Origin,X-Requested-With,Content-Type,Accept,Authorization',
	                   //'Access-Control-Methods':'POST,PUT,OPTIONS,GET,DELETE'
	                }
	            }
			$http.get(curl,config).success(function(result) {  
				 // $scope.image = $sce.trustAsResourceUrl(result.data);
				 $scope.caseinstances  = result;
			       
			    }).error(function(result, status) {
			    	$scope.errorMsg = result ;
			    })
		};
		
		
		$scope.getAllcases = function () {
			$scope.caseList = { show: true }
			$scope.caseList = true
			$scope.caseDet=false 
			$scope.messageList={ show: true } 
	  var url = 'http://localhost:8280/mortgageweb/cases';
			
	  $scope.caseinstances = caseService.caseinstances(url);
 
    };
   
    $scope.caseWork = function(id,status) {
    	
  	   var url = 'http://localhost:8280/mortgageweb/caseDetail/?id=' +id + "&status="+status;
        // $scope.tastdetId = taskid;
  	  $scope.htmlurl ='test';
  	   $scope.processId = id;
  	  $scope.caseDetail= [];
  	  $scope.caseDet =  { show: true }
  	  $scope.caseList = false
  	   $http.post(url).then(function (res) {
           $scope.caseDetail = res.data;  
  	    })
  	    
  	   
  	  
      }
    
    $scope.processTask = function(id,status) {
    	
   	   var url = 'http://localhost:8280/mortgageweb/processTask/?id=' +id + "&status="+status;
         // $scope.tastdetId = taskid;
   	 
   	   $http.post(url).then(function (res) {
             
   	    })
   	    
   	   
   	  
       }
   
  
     // $scope.caseinstance();
	  });
	
   app.controller('UserTaskCtrl', function($scope,$http,UserTaskService) {
    $scope.doSearchTasks = function () {
	   $scope.tskState = { show: true }
	  //var url = '/jbpmngwebexample/rest/json/tasks/pending?user=' +$scope.user;
	  //$scope.taskresults = UserTaskService.getUserTaskData(url);
     }
 
// app.controller('UserTaskCtrl', function($scope,$http,UserTaskService) {
    $scope.getTasks = function () {
	   $scope.tskState = { show: true }
	  var url = 'http://localhost:8280/mortgageweb/tasks' ;
	  $scope.tasks = UserTaskService.getUserTaskData(url);
     }
   
     $scope.taskWork = function (id) {
	  // $scope.taskDet = { show: true }
	  var url = 'http://localhost:8280/case-management/taskDetail/?id=' + id ;
	  //$scope.task = UserTaskService.getUserTaskData(url);
	  $http.post(url).then(function (res) {
		  $scope.task = res.data;  
		     $scope.taskDet = { show: true }
		     if($scope.taskDet.status == 'Ready'){
		    	 $scope.claim = true;
		     };
		    
		     if($scope.taskDet.status == 'Reserved'){
		    	 $scope.start = true;
		     };
			 
			 
	     
	     })
     }
   
	 $scope.CompleteTask = function(id,status) {
		 $scope.taskDet = { show: true }
		 var url = 'http://localhost:8280/case-management/completeTask/?id=' + id +'&status=' +status ;
		 $scope.task = UserTaskService.getUserTaskData(url);
		
	 }
	 
	$scope.taskWork1 = function(processId,taskid) {
	   var url = '/jbpmngwebexample/rest/json/tasks/processparams?processId=' +processId;
       $scope.tastdetId = taskid;
	    $scope.processId = processId;
	   
	   $http.post(url).then(function (res) {
         $scope.taskdetldata = res.data;  
	     $scope.taskDet = { show: true }
		 $scope.quantity = res.data.quantity;
		 $scope.modelNumber = res.data.modelNumber;
		 $scope.priority = res.data.priority;
		 
     
     })
    }
	   
	
   });

	