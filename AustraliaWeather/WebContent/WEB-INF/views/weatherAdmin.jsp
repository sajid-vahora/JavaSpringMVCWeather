<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Weather Admin</title>
<!-- load jquery -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/flat-ui.min.css" rel="stylesheet">

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	function submitForm(){
		var city = $("#city").val();
		if(city === '') {
			$("#admin").preventDefault(); // prevent form submit
        	alert('All fields are required.'); 
		} else {
			$("#admin").submit();
		}
	}
</script>
</head>
<body>
<form action="admin/addCity" name="admin" id="admin" method="post">
<div class="container">
	<div class="row demo-row">
		<div class="col-xs-12">
		  <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
				<span class="sr-only">Toggle navigation</span>
			  </button>
			  <a class="navbar-brand" href="#">All Weather</a>
			</div>
		  </nav><!-- /navbar -->
		</div>
	</div>
	<div class="col-xs-3">
    	<div class="form-group">
            <input type="text" value="" placeholder="City" class="form-control" id="city" name="city"></input>
    	</div>
    </div>
    <div class="col-xs-3">
          <a href="javascript: submitForm();" class="btn btn-block btn-lg btn-primary">Add City</a>
    </div>
    <div>
    <% if(request.getAttribute("message") != null) { %>
    <h6> <%= (String)request.getAttribute("message") %></h6>
    <%} %>
    </div>	
</div>
</form>
</body>

</html>