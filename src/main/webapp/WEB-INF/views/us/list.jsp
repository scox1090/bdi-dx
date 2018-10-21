<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
	<link rel="stylesheet" type="text/css" href="${resPath}/dhtmlx/skins/skyblue/dhtmlx.css"/>
<script>
var usGrid; 
function doInit(){
	usGrid = new dhtmlXGridObject('divGrid');
	usGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
	usGrid.setHeader('번호,아이디,비밀번호,이름,이메일,주소,전화번호,성별,취미,추천인,삭제하기');
	usGrid.setColumnIds('usno,usid,uspwd,usname,usemail,usaddress,ustel,usgender,ushobby,usrecommender,usno');
	usGrid.setColTypes('ro,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed');
	
	usGrid.attachEvent("onEditCell", function(stage,rId,cInd,nValue,oValue){
		var keyArr = ['usno','usid','uspwd','usname','usemail','usaddress','ustel','usgender','ushobby','usrecommender','remove']; 
		var ks = keyArr[cInd]; //'ustel'
		var data ={usno: usGrid.cells(rId,0).getValue()};
		data[ks] = nValue;
		if(stage==0){
			alert(ks)
		if(ks=='remove'){
				var usno = usGrid.cells(rId,0).getValue();
				var conf = {
						url:'/users/'+ usno,
						method:'DELETE', 
						param : JSON.stringify(data),
						success : function(res){ 
							res = JSON.parse(res);
						}
				}
				au.send(conf);
				location.href='/uri/us/list';
			}
		}
		if(stage==2){

			var usno = usGrid.cells(rId,0).getValue();
			var conf = {
				url:'/users/'+ usno,
				method:'PUT',
				param : JSON.stringify(data),   
				success : function(res){ 
					res = JSON.parse(res);
				}
		}
		au.send(conf);
		}
		return true;
	});
	usGrid.init();
	au.send({url:'/users',success:function(res){
		res= JSON.parse(res);
		usGrid.parse(res,'js'); 
	}});
}
function logout(){
	alert('메인페이지로 이동합니다.')
	location.href='/uri/us/main';
}

 
window.addEventListener('load', doInit);
</script>
</head>
<body>
<div id="divGrid" style="width:1000px; height:350px; background-color:white;"></div>
<button onclick="logout()">로그아웃</button>
</body> 
</html>