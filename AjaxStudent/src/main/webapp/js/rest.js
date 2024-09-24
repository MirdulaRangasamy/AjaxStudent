$("#addStudent").click(function(){
		var stud = 
			{
				rollNo:$("#addRollNo").val(),
				name:$("#addName").val(),
				dept:$("#addDept").val(),
				grade:$("#addGrade").val()
			}
			Cookies.set("sname",stud.name);
		alert("From Client "+JSON.stringify(stud));
		$.ajax({
			type: "POST",
			url: "rest/studentManagement",
			contentType: "application/json",
			data: JSON.stringify(stud),
			dataType: "json",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
				
				location.href = "NewFile.html";
				//window.location.href="/NewFile.html";
			}
		});	
	});

	$("#updateStudent").click(function(){
		var stud = 
			{
				rollNo:$("#updateRollNo").val(),
				name:$("#updateName").val(),
				dept:$("#updateDept").val(),
				grade:$("#updateGrade").val()
			}
		alert("From Client "+JSON.stringify(stud));
		$.ajax({
			type: "PUT",
			url: "rest/studentManagement",
			contentType: "application/json",
			data: JSON.stringify(stud),
			dataType: "json",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
				//location.href = "success.html"
			}
		});	
	});

	$("#viewStudent").click("submit",function(){	
		var rollNo1 = $("#viewRollNo").val();
		//alert("From Client "+JSON.stringify(stud));
		alert("From Client to get a Single Student");
		alert(`rest/studentManagement/student/${rollNo1}`);
		$.ajax({
			type: "GET",
			url: `rest/studentManagement/student/${rollNo1}`,
			dataType: "json",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
				//location.href = "success.html"
			}
		});	
	});

	$("#viewAllStudent").click(function(){	
		
		//alert("From Client "+JSON.stringify(stud));
		$.ajax({
			type: "GET",
			url: `rest/studentManagement`,
			dataType: "text",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
				//location.href = "success.html"
			}
		});	
	});

	$("#deleteStudent").click(function(){	
		var rollNo = $("#deleteRollNo").val();
		alert("From Client ");
		$.ajax({
			type: "DELETE",
			url: `rest/studentManagement/${rollNo}`,
			dataType: "text",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
				//location.href = "success.html"
			}
		});	
	});
	
	$("#logout").click(function(){	
		Cookies.remove("sname");
		alert("You got logged out Successfully")
		
	});