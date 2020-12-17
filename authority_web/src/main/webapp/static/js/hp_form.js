layui.use('form', function() {
	let form = layui.form;
	
	//通用弹出层表单提交方法
	form.on('submit(demo1)', function(data){
		console.log(data.field);
		$.post($('form').attr("action"),data.field, function (e){
		/*	layer.open({
				type: 2,
				content: '${pageContext.request.contextPath}/user/save'
			});
*/
			if (e.result==true) {
				parent.closeLayer(e.msg);
			}else {
				layer.msg('操作失败：' + e.msg, {icon: 2, time: 2000});
			}
		})
		return false;
	})
	
});