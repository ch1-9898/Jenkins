<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	  $("#aaa").on("click",function(){
		  $.ajax({
			url:"aaa",
			type:"get",
			dataType:"json",
			success:function(data,status,xhr){
				console.log(data, data.userid,data.passwd);
				$("#result").text(JSON.stringify(data));
			},
			error:function(xhr,status,error){}
		  }); 
	  });
	  $("#bbb").on("click",function(){
		  $.ajax({
			url:"bbb",
			type:"get",
			dataType:"json",
			success:function(data,status,xhr){
				console.log(data, data.userid,data.passwd);
				$("#result").text(JSON.stringify(data));
			},
			error:function(xhr,status,error){}
		  }); 
	  });
	  
	  $("#ccc").on("click",function(){
		  $.ajax({
			url:"ccc",
			type:"get",
			dataType:"json",
			success:function(data,status,xhr){
				console.log(data);
				console.log(data.one);
				console.log(data.two);
				
			},
			error:function(xhr,status,error){}
		  }); 
	  });
	});
</script>
</head>
<body>
	<button id="aaa">aaa호출: Login</button><br>
	<button id="bbb">bbb호출: ArrayList</button><br>
	<button id="ccc">ccc호출: HashMap</button><br>
	<div id="result"></div>
</body>
</html>