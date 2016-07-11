<!doctype html>
<html>
<head>
<link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/bower_components/angular-bootstrap2/ui-bootstrap-custom-1.3.3-csp.css" />
<link rel="stylesheet" href="resources/css/custom.css" />
<script type="text/javascript" src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="resources/bower_components/angular/angular.js"></script>
<script
	src="resources/bower_components/angular-resource/angular-resource.js"></script>
<script
	src="resources/bower_components/angular-ui-router/release/angular-ui-router.js"></script>
<script type="text/javascript" src="resources/bower_components/angular-bootstrap2/ui-bootstrap-custom-tpls-1.3.3.min.js"></script>
<script type="text/javascript" src="resources/bower_components/bootstrap-ui-datetime-picker/dist/datetime-picker.min.js"></script>


<script src="resources/js/app.js"></script>
<script src="resources/js/controllers.js"></script>
<script src="resources/js/services.js"></script>
<script src="resources/js/directives.js"></script>
<meta charset="utf-8">
<title>CINEMA</title>
</head>
<body ng-app="springmvc">
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">event pusher</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Events</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="./">Default <span
							class="sr-only">(current)</span></a></li>
					<li><a href="../navbar-static-top/">Static top</a></li>
					<li><a href="../navbar-fixed-top/">Fixed top</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
		<div>
			<ui-view><i>Events are going to load...</i></ui-view>
		</div>
	</div>
</body>
</html>