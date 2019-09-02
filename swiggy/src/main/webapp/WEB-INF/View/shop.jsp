<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop for food</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

</head>
<body>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
		
	</script>
	<div class="container">
	<div class="jumbotron text-center">
		<h1>eat till you die</h1>
		<p>ORDER FROM PANDA YOU WONT STOP</p>
	
	</div>
	
			<div class="card-columns">
		<c:forEach var="fd" items="${food}">

			 <div class="col-12 col-lg-6">
			<div class="card"
				style="width: 250px; height: 400px;  ">
				<img class="card-img-top" src="${fd.path}" alt="Card image"
					width="200" height="200">
				<div class="card-body">
					<h4 class="card-title">${fd.name}</h4>
					<input class="in" type="hidden" value="${fd.id}" name="id" id="id">
					<p class="card-text">Quantity Available: ${fd.qnt}</p>
					<p class="card-text">Amount: ${fd.amt}</p>
					<input class="bur" id="qnt" name="qnt" type="number" min="1"
						max="${fd.qnt}">
					<button value="${fd.id}" onclick="AddToCart(this)">AddToCart</button>
				</div>


			</div>
			
			</div>
		
		</c:forEach>
	</div>
	
		<h1>Cart</h1>
		<p>Food ready to be shipped</p>

		<br>
		<div>
			<div>
				<div>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>Quantity</th>
								<th>Cost</th>
							</tr>
						</thead>
						<tbody id="tbody">

						</tbody>
						
					</table>
					<br>
		
					<input type="button" id="total1" value="Order" onclick="addTotal(this)">
		
				
					Total Cost: <label id="total"  ></label>
					
				</div>
			</div>
			<br>

		</div>



	</div>


	<script>
     var j=0;
 	var ids=[10];		
		function AddToCart(e) {
			var x = document.getElementsByClassName("bur");
			var y = document.getElementsByClassName("in");
			var q = $(e).attr('value');
			var quantity = x[q - 1].value;
		
			console.log(quantity);
			var id = y[q - 1].value;
			console.log(id);
			var html = '';
			var bool=Check(id);
			if(bool){
			$.ajax({
				url : "calculateCost",
				type : "POST",
				data : {
					quantity : quantity,
					id : id
				},
				success : function(data) {
					console.log(data);
					$("#tbody").empty();
					var sum=0;
					for (var i = 0; i < data.length; i++) {

						html += '<tr><td>' + data[i].name + '</td><td>'
								+ data[i].quant + '</td><td>' + data[i].cost
								+ '</td></tr>'
								sum=sum+data[i].cost;
					}
					$("#total").text(sum);
					 $('#total1').attr('name', sum);
					$("#tbody").append(html);

				}
			});
			}
			else{
				alert("already in cart");
			}
		}
			
		function Check(id) {
			
			for(var i=0;i<ids.length;i++){
				if(id==ids[i])
				return false;
			}
			ids[j]=id;
			j++
			return true;

				}
	function addTotal(e) {
		var total=e.name;
		console.log(total);
		$.ajax({
			url : "order/total",
			type : "GET",
			success:function(data){
				console.log(data);
			}	
			});

				
	}
		
	</script>

</body>
</html>