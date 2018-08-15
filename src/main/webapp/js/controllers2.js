'use strict';

/* Controllers */

var app = angular.module('ngdemo.controllers', ['chart.js']);
/*.config(['ChartJsProvider', function (ChartJsProvider) {
    // Configure all charts
    ChartJsProvider.setOptions({
      colours: ['#FF5252', '#FF8A80'],
      responsive: false
    });
    // Configure all line charts
    ChartJsProvider.setOptions('Line', {
      datasetFill: false
    });
  }])*/
  
 /* app.controller("LineCtrl", function ($scope) {

  $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
  $scope.series = ['Series A', 'Series B'];
  $scope.data = [
    [65, 59, 80, 81, 56, 55, 40],
    [28, 48, 40, 19, 86, 27, 90]
  ];
  $scope.onClick = function (points, evt) {
    console.log(points, evt);
  };*/

  // Simulate async data update
 /* $timeout(function () {
    $scope.data = [
      [28, 48, 40, 19, 86, 27, 90],
      [65, 59, 80, 81, 56, 55, 40]
    ];
  }, 3000);
});*/


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
  app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
      $templateCache.removeAll();
    });
  });
  
  
  
  
 app.controller('SlackController', function($scope,$http,UserTaskService) {
	 
	
	   $scope.getSlack = function () {
	  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
	  $http.get(slurl).success(function(result) {  
		  $scope.messages  = result;
	       
	    }) 
	  };
	
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
    	 $scope.ssn='123456789';
    	 $scope.ageofproperty='30';
    	 $scope.addressofproperty='3018 Test Drive, Madison, WI-53719';
    	 $scope.saleprice='100000';
    	 $scope.locale='Urban';
    	 $scope.smsMobile='+16083584153';
    	 $scope.contactPhone='+16083584153';
    	 $scope.emailId='jpaulraj@redhat.com';
  	 
      }
   });
   
	app.controller('caseCtrl', function($scope,$http,$window,caseService) {
		
	
		$scope.openChildWindow = function (id) {
			
			 var url1 = 'http://localhost:8280/credit-dispute/image/?id=' +id;
			  //  $scope.htmlurl ='test2';
			   $http.post(url1).success(function(result) {  
				 // $scope.image = $sce.trustAsResourceUrl(result.data);
		       $scope.htmlurl = result;
		       var left = screen.width / 2 - 150, top = screen.height / 2 - 200
				$window.open('http://localhost:8280/credit-dispute/'+result, '', "top=" + top + ",left=" + left + ",width=800,height=1000")
		       
		    }) 
			
			};
			
			$scope.getSlack = function () {
				  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
				  $http.get(slurl).success(function(result) {  
					  $scope.messages  = result;
				       
				    })
				    
				 $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
				  $scope.series = ['Series A', 'Series B'];
				  $scope.data = [
				    [65, 59, 80, 81, 56, 55, 40],
				    [28, 48, 40, 19, 86, 27, 90]
				  ];
				  $scope.onClick = function (points, evt) {
				    console.log(points, evt);
				  };
			    
				  };
				  
				  

					$scope.sendSlack = function () {
						  var slsurl = 'http://localhost:8280/credit-dispute/sendSlackmessage/?' + "slakcMessage=" + $scope.slakcMessage;
						  $http.post(slsurl).success(function(result) {  
							  $scope.slakcMessage  = "";
							  
							  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
							  $http.get(slurl).success(function(result) {  
								  $scope.messages  = result;
							       
							    }) 
						       
						    }) 
						   
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
	 
	  $scope.getSlack = function () {
		  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
		  $http.get(slurl).success(function(result) {  
				 // $scope.image = $sce.trustAsResourceUrl(result.data);
			  $scope.messages  = result;
		       
		    }) 
		  }
	 
    };
    $scope.getPayments = function () {
		$scope.payList = { show: true }
		$scope.payList = true
		$scope.payDet=false 
		$scope.messageList={ show: true } 
  var url = 'http://localhost:8280/credit-dispute/payments';
  $scope.payments = caseService.caseinstances(url);
 
  $scope.getSlack = function () {
	  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
	  $http.get(slurl).success(function(result) {  
			 // $scope.image = $sce.trustAsResourceUrl(result.data);
		  $scope.messages  = result;
	       
	    }) 
	  }
 
};

$scope.getPayment = function(id,desc) {
	
	   var url = 'http://localhost:8280/credit-dispute/payment/?id=' +id;
    // $scope.tastdetId = taskid;
	  $scope.htmlurl ='test';
	   $scope.paymentId = id;
	   $scope.description = desc;
	  $scope.payDetail= [];
	  $scope.payDet =  { show: true }
	  $scope.payList = false
	  $scope.confirm = null;
	  $scope.procUpdate = {show: false};
	   $http.post(url).then(function (res) {
       $scope.payDetail = res.data;  
	    })
	    
	   $scope.getSlack = function () {
		  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
		  $http.get(slurl).success(function(result) {  
				 // $scope.image = $sce.trustAsResourceUrl(result.data);
			  $scope.messages  = result;
		       
		    }) 
		  };
	  
  }

$scope.getPromoAccts = function () {
	
	$scope.promoDet=false 
	//$scope.messageList={ show: true } 
	var url = 'http://localhost:8280/credit-dispute/promoAccts';
	$scope.promoaccts = caseService.caseinstances(url);



}

$scope.getPromTrans = function(id,partner) {
	 $scope.promoAccId = id;
	   $scope.partner = partner;
	   var purl = 'http://localhost:8280/credit-dispute/promotrans/?id=' +id;
 
	   $scope.promoDet =  { show: true }
	   
	   $http.get(purl).success(function(result) {  
		   $scope.transactions  = result;
		   $scope.promoId = id;
	       
	    }) 

}
$scope.addTransaction = function (id) {
	var urlup = 'http://localhost:8280/credit-dispute/addPromoTrans/?id=' + id +'&transaction.transactionDate=' + $scope.transaction.transactionDate + '&transaction.transactionAmont=' + $scope.transaction.transactionAmont + '&transaction.orderDate=' + $scope.transaction.orderDate + '&transaction.smsnumber=' + $scope.transaction.smsnumber + '&transaction.emailid=' + $scope.transaction.emailid  ;
	 $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
		 //$scope.payUpdate = {show: true};
		 $scope.transconfirm ='transaction created  Successfully'
			 $scope.transaction.transactionDate = [];
			 $scope.transaction.transactionAmont = [];
			 $scope.transaction.orderDate =[];
			 $scope.transaction.smsnumber =[];
			 $scope.transaction.emailid  =  [];
			 $scope.transconfirm = [];
			 
			 $scope.promoAccId = id;
			   $scope.partner = partner;
			   var purl = 'http://localhost:8280/credit-dispute/promotrans/?id=' +id;
		 
			   $scope.promoDet =  { show: true }
			   
			   $http.get(purl).success(function(result) {  
				   $scope.transactions  = result;
				   $scope.promoId = id;
			       
			    }) 

    
	  }) 
}
//update
$scope.paymentNotification = function (id) {
	
	  var urlup = 'http://localhost:8280/credit-dispute/paymentDueNotification/?id=' + id + '&payDetail.minBalanceAmount=' + $scope.payDetail.minBalanceAmount + '&payDetail.dueDateStr=' + $scope.payDetail.dueDateStr + '&payDetail.startDateStr=' + $scope.payDetail.startDateStr + '&payDetail.endDateStr=' + $scope.payDetail.endDateStr + '&payDetail.autoPayment=' + $scope.payDetail.autoPayment + '&payDetail.accountNumber=' + $scope.payDetail.accountNumber + '&payDetail.paymentNotificationDays=' + $scope.payDetail.paymentNotificationDays + '&payDetail.smsNotificationNo=' + $scope.payDetail.smsNotificationNo + '&payDetail.emailNotification=' + $scope.payDetail.emailNotification ;
	  
	  $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
		 $scope.payUpdate = {show: true};
		 $scope.confirm ='Notification send  Successfully'
			  
    
	  }) 
    
    }
//update
//update
$scope.paymentSchedule = function (id) {
	
	  var urlup = 'http://localhost:8280/credit-dispute/paymentSchedule/?id=' + id + '&payDetail.minBalanceAmount=' + $scope.payDetail.minBalanceAmount + '&payDetail.totalBalanceAmount=' + $scope.payDetail.totalBalanceAmount + '&payDetail.dueDateStr=' + $scope.payDetail.dueDateStr + '&payDetail.startDateStr=' + $scope.payDetail.startDateStr + '&payDetail.endDateStr=' + $scope.payDetail.endDateStr + '&payDetail.payScheduleDateStr=' + $scope.payDetail.payScheduleDateStr + '&payDetail.autoPayment=' + $scope.payDetail.autoPayment + '&payDetail.accountNumber=' + $scope.payDetail.accountNumber + '&payDetail.paymentNotificationDays=' + $scope.payDetail.paymentNotificationDays + '&payDetail.smsNotificationNo=' + $scope.payDetail.smsNotificationNo + '&payDetail.emailNotification=' + $scope.payDetail.emailNotification ;
	  
	  $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
		 $scope.payUpdate = {show: true};
		 $scope.confirm ='Notification send  Successfully'

    
	  }) 
    
    }
//update

//update
$scope.promoOffer = function (id) {
	
	  var urlup = 'http://localhost:8280/credit-dispute/promotion/?id=' + id + '&payDetail.type=' + $scope.payDetail.type + '&payDetail.minBalanceAmount=' + $scope.payDetail.minBalanceAmount + '&payDetail.totalBalanceAmount=' + $scope.payDetail.totalBalanceAmount + '&payDetail.dueDateStr=' + $scope.payDetail.dueDateStr + '&payDetail.startDateStr=' + $scope.payDetail.startDateStr + '&payDetail.endDateStr=' + $scope.payDetail.endDateStr + '&payDetail.payScheduleDateStr=' + $scope.payDetail.payScheduleDateStr + '&payDetail.autoPayment=' + $scope.payDetail.autoPayment + '&payDetail.accountNumber=' + $scope.payDetail.accountNumber + '&payDetail.paymentNotificationDays=' + $scope.payDetail.paymentNotificationDays + '&payDetail.smsNotificationNo=' + $scope.payDetail.smsNotificationNo + '&payDetail.emailNotification=' + $scope.payDetail.emailNotification ;
	  
	  $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
		 $scope.payUpdate = {show: true};
		 
		 $scope.confirm ='Notification send  Successfully'

	  }) 
    
    }

$scope.pastDue = function (id) {
	
	  var urlup = 'http://localhost:8280/credit-dispute/pastDue/?id=' + id + '&payDetail.type=' + $scope.payDetail.type + '&payDetail.minBalanceAmount=' + $scope.payDetail.minBalanceAmount + '&payDetail.totalBalanceAmount=' + $scope.payDetail.totalBalanceAmount + '&payDetail.dueDateStr=' + $scope.payDetail.dueDateStr + '&payDetail.startDateStr=' + $scope.payDetail.startDateStr + '&payDetail.endDateStr=' + $scope.payDetail.endDateStr + '&payDetail.payScheduleDateStr=' + $scope.payDetail.payScheduleDateStr + '&payDetail.autoPayment=' + $scope.payDetail.autoPayment + '&payDetail.accountNumber=' + $scope.payDetail.accountNumber + '&payDetail.paymentNotificationDays=' + $scope.payDetail.paymentNotificationDays + '&payDetail.smsNotificationNo=' + $scope.payDetail.smsNotificationNo + '&payDetail.emailNotification=' + $scope.payDetail.emailNotification ;
	  
	  $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
		 $scope.payUpdate = {show: true};
		 $scope.confirm ='Notification send  Successfully'

  
	  }) 
  
  }

//update
    $scope.caseWork = function(id) {
    	
 	   var url = 'http://localhost:8280/mortgageweb/caseDetail/?id=' +id;
       // $scope.tastdetId = taskid;
 	  $scope.htmlurl ='test';
 	   $scope.processId = id;
 	  $scope.caseDetail= [];
 	  $scope.caseDet =  { show: true }
 	  $scope.caseList = false
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    })
 	    
 	   $scope.getSlack = function () {
 		  var slurl = 'http://localhost:8280/credit-dispute/slackMessages';
 		  $http.get(slurl).success(function(result) {  
 				 // $scope.image = $sce.trustAsResourceUrl(result.data);
 			  $scope.messages  = result;
 		       
 		    }) 
 		  };
 	  
     }
    
    //update 
    
    $scope.updateProcess = function (id) {
    	
  	  var urlup = 'http://localhost:8280/credit-dispute/update/?id=' + id + '&caseDetail.accountName=' + $scope.caseDetail.accountName + '&caseDetail.merchantName=' + $scope.caseDetail.merchantName + '&caseDetail.transactionDate=' + $scope.caseDetail.transactionDate + '&caseDetail.transactionAmount=' + $scope.caseDetail.transactionAmount + '&caseDetail.areyoudisbutefullamount=' + $scope.caseDetail.areyoudisbutefullamount + '&caseDetail.disputeAmount=' + $scope.caseDetail.disputeAmount + '&caseDetail.disputeReason=' + $scope.caseDetail.disputeReason + '&caseDetail.smsMobile=' + $scope.caseDetail.smsMobile + '&caseDetail.contactPhone=' + $scope.caseDetail.contactPhone + '&caseDetail.emailId=' + $scope.caseDetail.emailId ;
  	  
  	  $http.post(urlup).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
  		 $scope.procUpdate = {show: true};
  		 
      
  	  }) 
      
      }
    //update
    
    //
    $scope.getImage = function(id) {
    // var auth ' $base64.encode("bpmsAdmin:jboss123$"), headers = {"Authorization": "Basic " + auth};
	    var url1 = 'http://localhost:8280/credit-dispute/image/?id=' +id;
	  //  $scope.htmlurl ='test2';
	   $http.post(url1).success(function(result) {  
		 // $scope.image = $sce.trustAsResourceUrl(result.data);
       $scope.htmlurl = result;
       
    }) 
    }
    //
    
    $scope.sendSignal= function(id) {
  	   var url = 'http://localhost:8280/credit-dispute/signal/?id=' +$scope.processId  +  '&signalName=' + $scope.signalName + '&signalData=' + $scope.signalData;
      
  	  $scope.caseDet =  { show: true }
  	   $http.post(url).then(function (result) {
  		   
  		 var ret = result;
       })
       
       var urlc = 'http://localhost:8280/credit-dispute/caseDetail/?id=' +id;
  	  	$http.post(urlc).then(function (result) {
		   
  	  	$scope.caseDetail = res.data;  
       })
      }
     //creare new acc
   
    $scope.newAccount= function(id) {
 	   var url = 'http://localhost:8280/case-management/createNewAccount/?id=' +$scope.processId  +  '&newAccountType=' + $scope.newAccountType + '&minamount=' + $scope.minamount;
       // $scope.tastdetId = taskid;
 	  // $scope.processId = id;
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    
      
      })
     }
     //end create new account
     //close account
      $scope.closeAccount= function(type) {
 	   var url = 'http://localhost:8280/case-management/closeAccount/?id=' +$scope.processId  +  '&type=' + type;
       // $scope.tastdetId = taskid;
 	  // $scope.processId = id;
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    
      
      })
     }
     //end close account
     //suspend accond
     //close account
      $scope.suspendAccount= function(type) {
 	   var url = 'http://localhost:8280/case-management/suspendAccount/?id=' +$scope.processId  +  '&type=' + type;
       // $scope.tastdetId = taskid;
 	  // $scope.processId = id;
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    
      
      })
     }
     //end close account
     //suspend end
     //Start adhoc task
     
     $scope.startAdhocTask = function(taskname) {
 	   var url = 'http://localhost:8280/case-management/startAdhocTask/?id=' +$scope.processId  +  '&taskname=' + taskname;
       
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    
      
      })
     }
     
     //end adhoctask
   //new dyn task
      
     $scope.newDynamicTask = function() {
 	   var url = 'http://localhost:8280/case-management/addDynamicTask/?id=' +$scope.processId  +  '&taskName=' + $scope.taskName +  '&taskType=' + $scope.taskType +  '&taskUser=' + $scope.taskUser +  '&taskGroup=' + $scope.taskGroup +  '&taskData=' + $scope.taskData;
       
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	    
      
      })
     }
   //end new dyn task
     //creare new user
   
    $scope.newUser= function(id) {
 	   var url = 'http://localhost:8280/case-management/addNewUser/?id=' +$scope.processId  +  '&userId=' + $scope.userId ;
       // $scope.tastdetId = taskid;
 	  // $scope.processId = id;
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	  
 		
      
      })
     }
     //end new user
      //creare new user
   
    $scope.newGroup= function(id) {
 	   var url = 'http://localhost:8280/case-management/addNewRole/?id=' +$scope.processId  +  '&groupId=' + $scope.groupId ;
      
 	  $scope.caseDet =  { show: true }
 	   $http.post(url).then(function (res) {
          $scope.caseDetail = res.data;  
 	   
 		
      
      })
     }
     //end new user
     
     
     // $scope.caseinstance();
	  });
	
   app.controller('UserTaskCtrl', function($scope,$http,UserTaskService) {
    $scope.doSearchTasks = function () {
	   $scope.tskState = { show: true }
	  var url = '/jbpmngwebexample/rest/json/tasks/pending?user=' +$scope.user;
	  $scope.taskresults = UserTaskService.getUserTaskData(url);
     }
 
// app.controller('UserTaskCtrl', function($scope,$http,UserTaskService) {
    $scope.getTasks = function () {
	   $scope.tskState = { show: true }
	  var url = 'http://localhost:8280/case-management/tasks' ;
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
	   // var url = '/jbpmngwebexample/rest/json/tasks/compleTask?user=' + $scope.user +'&taskId=' +$scope.tastdetId  +'&priority=' +priority +'&modelNumber=' +modelNumber +'&quantity=' +quantity;
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

	