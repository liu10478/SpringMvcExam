/**
 * 
 */

var nowpage=1;

function showCustomers(page){
	alert(page);
	var pagesize=40;
	$.ajax({
		type:"GET",
		data:"pagea=" + page + "&pagesize=" + pagesize, 
		url:"showCustomer",
		dataType:"json",
		success:function(data){
			if(data.length<=0){
				alert("已经是最后一页了");
				nowpage-=1;
				showCustomers(nowpage);
			}
			var doc="<tr><td>操作</td><td>First Name</td><td>Last Name</td><td>Address</td>" +
			"<td>Email</td><td>id</td><td>Last Update</td></tr>";
			for(var i=0;i<data.length;i++){
				doc+="<tr><td><a href=''>编辑</a>|<a href=''>删除</a></td></br>"+
				"<td>"+data[i].first_name+"</td></br>" +
				"<td>"+data[i].last_name+"</td></br>" +
				"<td>"+data[i].address.address+"</td></br>" +
				"<td>"+data[i].email+"</td></br>" +
				"<td>"+data[i].customer_id+"</td></br>" +
				"<td>"+data[i].last_update+"</td></tr>"
				}
			
				$("#showCustomer").html(doc);
		}
	});	
}

	function hrefclick(id){
		nowpage=id;

		showCustomers(id);
	}

	function nextpage(){
		nowpage+=1;
	
		showCustomers(nowpage);
	}
	function beforepage(){
		if(nowpage==1){
			alert("已经是首页了");
		}else{
		nowpage-=1;
		showCustomers(nowpage);
		}
	}
	
