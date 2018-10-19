<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
var usGrid; 
function doInit(){
	usGrid = new dhtmlXGridObject('divGrid');
	usGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
	usGrid.setHeader('번호,아이디,비밀번호,이름,이메일,주소,전화번호,성별,취미,추천인');
	usGrid.setColumnIds('usno,usid,uspwd,usname,usemail,usaddress,ustel,usgender,ushobby,usrecommender');
	usGrid.setColTypes('ro,link,ed,ed,ed,ed,ed,ed,ed,ed');
	usGrid.init();
	au.send({url:'/users/{usno}',success:function(res){
		res= JSON.parse(res);
		usGrid.parse(res,'js'); 
	}});	
}
</script>
<body>
</body>
</html>