<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<script>
	var dxForm, dxWin, loginFrom;
	var loginFormData = [
		{type:'settings', postion:'label-left', inputWidth:'300', labelWidth:'200'},
		{type:'fieldset', name:'login', label:'로그인', inputWidth:'auto',
			list:[
				{type:'input', name:'id', label:'아이디',validate:'ValidAplhaNumeric',required:true},
				{type:'password', name:'pwd', label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
				{type:'button', name:'loginbtn', value:'로그인'}
			]	
		}
	]
	
	var joinFormData = [
		{type:'settings', postion:'label-left', inputWidth:'300', labelWidth:'100'},
		{type:'fieldset', name:'join', label:'회원가입', inputWidth:'auto',
			list:[
				{type:'input', name:'id', label:'아이디',validate:'ValidAplhaNumeric',required:true},
				{type:'password', name:'pwd', label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
				{type:'input', name:'name', label:'이름',required:true},
				{type:'input', name:'email', label:'이메일',required:true},
				{type:'input', name:'address', label:'주소',required:true},
				{type:'input', name:'tel', label:'전화번호',required:true},
				{type:'radio', name:'gender', label:'남', checked:true},
				{type:'radio', name:'gender', label:'여',},
				{type:'input', name:'hobby', label:'취미'},
				{type:'input', name:'commder', label:'추천인'},
				{type:'button', name:'joinbtn', value:'회원가입'}
			]	
		}
	]
	function doInit(){
		var forms = [
			{type:'button',value:'로그인',name:'login'},
			{type:'button',value:'회원가입',name:'join'}
		]
		var dxForm = new dhtmlXForm("dxForm",forms);
		dxForm.attachEvent('onButtonClick',function(name){
			if(name=='login'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					dxWin.createWindow('w1',0,10,370,240);
					dxWin.window('w1').centerOnScreen();
					var loginForm = new dhtmlXForm('loginForm',loginFormData);
					dxWin.window('w1').attachObject('loginForm');
					loginForm.attachEvent('onButtonClick',function(name){
						if(name=='loginbtn'){
							if(loginForm.validate()){
							var id = loginForm.getItemValue('id');
							var pwd = loginForm.getItemValue('pwd');
							var conf = {
									url:'/users/{usno}',
									method:'POST',
									param : JSON.stringify({id:id,pwd:pwd}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
									}
							}
							au.send(conf);
							}
						}
					})
				}
			}if(name=='join'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					dxWin.createWindow('w1',0,10,370,610);
					dxWin.window('w1').centerOnScreen();
					var joinForm = new dhtmlXForm('joinForm',joinFormData);
					dxWin.window('w1').attachObject('joinForm');
					joinForm.attachEvent('onButtonClick',function(name){
						if(name=='joinbtn'){
							if(joinForm.validate()){
							var id = joinForm.getItemValue('id');
							var pwd = joinForm.getItemValue('pwd');
							var name = joinForm.getItemValue('name');
							var email = joinForm.getItemValue('email');
							var address = joinForm.getItemValue('address');
							var tel = joinForm.getItemValue('tel');
							var gender = joinForm.getItemValue('gender');
							var hobby = joinForm.getItemValue('hobby');
							var commder = joinForm.getItemValue('commder');
							var conf = {
									url:'/users',
									method:'POST',
									param : JSON.stringify({id:id,pwd:pwd,name:name,email:email,address:address,tel:tel,gender:gender,hobby:hobby,commder:commder}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
									}
							}
							au.send(conf);
							}
						}
					})
				}
			}
		})
	}
	window.addEventListener('load',doInit);
	
</script>
<body>
	<div id="dxForm" style="height: 100px"></div>		
	<div id="loginForm" style="width: 260px; height: 200px;"></div>
	<div id="joinForm" style="width: 260px; height: 200px;"></div>
</body>
</html>