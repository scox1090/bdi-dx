<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
var dxForm, dxWin, updateForm;

var updateFormData = [
	{type:'settings', postion:'label-left', inputWidth:'300', labelWidth:'100'},
	{type:'fieldset', name:'login', label:'수정', inputWidth:'auto',
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
			{type:'button', name:'updatebtn', value:'수정'}
		]	
	}
]

function doInit(){
	var forms = [
		{type:'button',value:'수정',name:'update'}
	]
	var dxForm = new dhtmlXForm("dxForm",forms);
	dxForm.attachEvent('onButtonClick',function(name){
		if(name=='update'){
			if(!dxWin){
				dxWin = new dhtmlXWindows();
				dxWin.createWindow('w1',0,10,370,660);
				dxWin.window('w1').centerOnScreen();
				var updateForm = new dhtmlXForm('updateForm',updateFormData);
				dxWin.window('w1').attachObject('updateForm');
				updateForm.attachEvent('onButtonClick',function(name){
					if(name=='updatebtn'){
						if(updateForm.validate()){
						var usno = updateForm.getItemValue('usno');
						var usid = updateForm.getItemValue('usid');
						var uspwd = updateForm.getItemValue('uspwd');
						var usname = updateForm.getItemValue('usname');
						var usemail = updateForm.getItemValue('usemail');
						var usaddress = updateForm.getItemValue('usaddress');
						var ustel = updateForm.getItemValue('ustel');
						var usgender = updateForm.getCheckedValue('usgender');
						var ushobby = updateForm.getItemValue('ushobby');
						var usrecommender = updateForm.getItemValue('usrecommender');
						var conf = {
								url:'/users/' + usno,
								method:'PUT',
								param : JSON.stringify({usid:usid,uspwd:uspwd,usname:usname,usemail:usemail,usaddress:usaddress,ustel:ustel,usgender:usgender,ushobby:ushobby,usrecommender:usrecommender}),
								success : function(res){ 
									res = JSON.parse(res);
									alert(res);
								}
						}
						au.send(conf);
						}
					}
				});
			}
		}
	})
}
window.addEventListener('load',doInit);
</script>
<body>
	<div id="dxForm" style="height: 100px"></div>		
	<div id="updateForm" style="width: 260px; height: 200px;"></div>
</body>
</html>