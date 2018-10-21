<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<script>

	var dxForm, dxWin, loginForm, joinForm,idckForm;
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
		{type:'fieldset', name:'login', label:'회원가입', inputWidth:'auto',
			list:[
				{type:'input', name:'usid', label:'아이디',validate:'ValidAplhaNumeric',required:true},
				{type:'password', name:'uspwd', label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
				{type:'input', name:'usname', label:'이름',required:true},
				{type:'input', name:'usemail', label:'이메일',required:true},
				{type:'input', name:'usaddress', label:'주소',required:true},
				{type:'input', name:'ustel', label:'전화번호',required:true},
						{type:'fieldset', name:'gender', label:'성별', inputWidth:'auto',
							list:[
								{type:'radio', name:'usgender', value:'남',label:'남',checked:true},
								{type:'radio', name:'usgender', value:'여',label:'여'}
							]
						},
				{type:'input', name:'ushobby', label:'취미'},
				{type:'input', name:'usrecommender', label:'추천인'},
				{type:'button', name:'joinbtn', value:'회원가입'}
			]	
		}
	]
	
	var idckFormData = [
		{type:'settings', postion:'label-left', inputWidth:'300', labelWidth:'200'},
		{type:'fieldset', name:'idck', label:'중복확인', inputWidth:'auto',
			list:[
				{type:'input', name:'id', label:'아이디',validate:'ValidAplhaNumeric',required:true},
				{type:'button', name:'idckbtn', value:'중복확인'}
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
									url:'/users/login',
									method:'POST',
									param : JSON.stringify({usid:id,uspwd:pwd}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
										location.href='/uri/us/list';
									}
							}
							au.send(conf);
							}
						}
					})
				}
			}
			
			 if(name=='join'){
					if(!dxWin){
						dxWin = new dhtmlXWindows();
						dxWin.createWindow('w1',0,10,370,660);
						dxWin.window('w1').centerOnScreen();
						var joinForm = new dhtmlXForm('joinForm',joinFormData);
						dxWin.window('w1').attachObject('joinForm');
						joinForm.attachEvent('onButtonClick',function(name){
							if(name=='joinbtn'){
								if(joinForm.validate()){
									if(status==500){
										alert("아이디 중복입니다.");
									}
									var usid = joinForm.getItemValue('usid');
									var uspwd = joinForm.getItemValue('uspwd');
									var usname = joinForm.getItemValue('usname');
									var usemail = joinForm.getItemValue('usemail');
									var usaddress = joinForm.getItemValue('usaddress');
									var ustel = joinForm.getItemValue('ustel');
									var usgender = joinForm.getCheckedValue('usgender');
									var ushobby = joinForm.getItemValue('ushobby');
									var usrecommender = joinForm.getItemValue('usrecommender');
									var conf = {
										url:'/users',
										method:'POST',
										param : JSON.stringify({usid:usid,uspwd:uspwd,usname:usname,usemail:usemail,usaddress:usaddress,ustel:ustel,usgender:usgender,ushobby:ushobby,usrecommender:usrecommender}),
										success : function(res){
											res = JSON.parse(res);
											alert(res.msg);
										}
									};
								au.send(conf);
								}
								
							}
						});
					}
				}
			 
			if(name=='idck'){
				dxWin = new dhtmlXWindows();
				dxWin.createWindow('w1',0,10,370,660);
				dxWin.window('w1').centerOnScreen();
				var idckForm = new dhtmlXForm('idckForm',idckFormData);
				dxWin.window('w1').attachObject('idckForm');
				idckForm.attachEvent('onButtonClick',function(name){
					if(name=='idckbtn'){
						if(idckForm.validate()){
							var id = idckForm.getItemValue('id');
							var conf = {
									url:'/users/idck',
									method:'POST',
									param : JSON.stringify({usid:id}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
										joinFormData[1].list[0].value =res.value;

									if(res.msg=='아이디를 만들 수 있습니다.'){
										var joinForm = new dhtmlXForm('joinForm',joinFormData);
										dxWin.window('w1').attachObject('joinForm');		
									}
								}
							}
							au.send(conf);
						}
					}
				});
			}
		});
	}
	window.addEventListener('load',doInit);

	function goMain(){
		
	}
</script>
<body>
	<div id="dxForm" style="height: 100px"></div>		
	<div id="loginForm" style="width: 260px; height: 200px;"></div>
	<div id="joinForm" style="width: 260px; height: 200px;"></div>
	<div id="idckForm" style="width: 260px; height: 200px;"></div>
</body>
</html>