<!DOCTYPE html>
<html ng-app="ngdemo">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>Angularjs Demo</title>
  
  
	<link href="Content/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="Content/customerManagementStyles.css" rel="stylesheet" />


	 
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
 
  <body>
 

  <div class="container" ng-controller="caseCtrl"  />
     
      <!-- Static navbar -->
      <div class="navbar navbar-default">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Rad Hat PAM Mortgage Application</a>
        </div>
       
      </div>
 
      <!-- Main component for a primary marketing message or call to action -->
	  <div class="row">
		
			<div class="col-md-3 panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#/Admin">Credit Dispute Process</a>
							<!-- a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#panel1">Credit Dispute Process</a> -->
						</h4>
					</div>
					<div id="panel1" class="panel-collapse collapse">
						<div class="panel-body">
							<li><a href="#/Admin">Create New Mortgage</a></li>
						    
							
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<!-- <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#panel2">All Cases </a> -->
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#/Cases"> Mortgage Processes </a>
						</h4>
					</div>
					<div id="panel2" class="panel-collapse collapse">
						<div class="panel-body">
							<li><a href="#/Cases">Mortgage Processes</a></li>
						    
							
						</div>
					</div>
				</div>
			
		
			</div>
			
			
		<div ng-view></div>
	
    </div> <!-- /container -->
   <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
  	
		  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="Scripts/bootstrap.min.js"></script>

   


		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular-resource.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-animate.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-sanitize.js"></script>	
		<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.2.5.js"></script>
		
	<!-- <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>-->
	    
	 
     <script src="js/app.js"></script>
    <script src="js/controllers.js"></script>
    <script src="js/services.js"></script>

	
  </body>
</html>

