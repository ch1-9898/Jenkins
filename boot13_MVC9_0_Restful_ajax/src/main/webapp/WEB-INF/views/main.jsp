<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#a").on("click",function(){
			
			$.ajax({
				url:'aaa',
				type:'post',
				datType:'text',
				success:function(data,status,xhr){
					$("#result").text(data);
				},
				error:function(xhr,status,error){
					
				}
			});
		});
	});
</script>
</head>
<body>
	<button id="a">get</button>
<button id="b">post</button>
<button id="c">put</button>
<button id="d">delete</button>
<div id="result"></div>
</body>
</html>