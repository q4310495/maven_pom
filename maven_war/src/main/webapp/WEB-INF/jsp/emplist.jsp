<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2018/8/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>部门管理</title>
    <!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
    <!-- Reset Stylesheet -->
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css"
          media="screen" />
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
          media="screen" />
    <script type="text/javascript" src="${pageContext.request.contextPath}\resources\widget\My97DatePicker\WdatePicker.js"></script>

    <!--                       Javascripts                       -->
    <!-- jQuery -->
    <script type="text/javascript"
            src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>

    <!-- 引入dialog的js -->
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script type="text/javascript" src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>
<!-- 引入zTree-->
    <link rel="stylesheet" href="resources/widget/zTree/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="resources\widget\zTree\jquery.ztree.all.min.js"></script>

    <link rel="stylesheet" href="resources/widget/webuploader/webuploader.css">
    <script type="text/javascript" src="resources/widget/webuploader/webuploader.min.js"></script>

    <script type="text/javascript">
       function openDialog(){
           //清空弹出框的内容
           $("#id").val("");

           //处理照片
           $("#header").attr("src", "resources/images/icons/header.jpg");

           //职工姓名
           $("#emp_name").val("");

           //邮箱
           $("#emp_email").val("");


           //性别
           $("input[name='sex'][value='1']").attr("checked","checked");


           //所属部门
           //<input type="button" value="xx"/>
           //<button>xxxxx</button>
           $("#select_dep_id").html("无");
           $("#did").val("");

           //通过js将时间进行转换
           //生日
           $("#birthday_id").val("");

           //入职时间
           $("#entrytime_id").val("");



           $("#dialog_div").dialog({
               title:'新增人员',
               width:600,
               height:500,
               modal:true
           });
       }

           function query_dep(){
               $.ajax({
                   url:"${pageContext.request.contextPath}/dep/queryAllAjax",
                   success:function(data){
                       var setting = {
                           data:{
                               key:{
                                   name:"dname"
                               },
                           simpleData:{
                               enable:true,
                               pIdKey:"pid"
                           }
                           },
                           view:{
                               showIcon:false
                           },
                           callback:{
                               onClick:function(event, treeId, treeNode){
                                   $("#select_dep_id").html(treeNode.dname);
                                   $("#did").val(treeNode.id);
                                   $("#ztree_dialog").dialog("close");
                               }
                           }


                       };
                       var zNodes=data;
                       var dags = $("#zTree");
                       var ztreeObject= $.fn.zTree.init(dags, setting, zNodes);
                       ztreeObject.expandAll(true);

                   $("#ztree_dialog").dialog({
                           width:200,
                           height:300,
                           modal:false
                       })

                   },
                   dataType:"json"
               });
       }

       function edit_emp(eid) {
           $.get("${pageContext.request.contextPath}/emp/queryEmpById",{eid:eid},
               function (data) {

               if (data.image!=null&&data.image!=""){
               $("#header").attr("src","${pageContext.request.contextPath}/img/getImg?path="+data.image)
                 $("#image").val(data.image)
               }else {
                   $("#header").attr("src", "resources/images/icons/header.jpg")
               }
               $("#id").val(data.id);

               $("#emp_name").val(data.name);

               $("#emp_email").val(data.email);

               $("#select_dep_id").html(data.did);
               $("#did").val(data.did);


              var birthday=new Date(data.birthday);
               $("#birthday_id").val(birthday.getFullYear()+"-"+birthday.getMonth()+1+"-"+birthday.getDate());

               var entrytime=new Date(data.entrytime);
               $("#entrytime_id").val(entrytime.getFullYear()+"-"+entrytime.getMonth()+1+"-"+entrytime.getDate());

                   $("#dialog_div").dialog({
                       title:'',
                       width:600,
                       height:500,
                       modal:true
                   });


               },
               "json")
       }

       function open_roles_dialog(eid) {

           $.get("${pageContext.request.contextPath}/role/queryRoleById",
               {eid:eid},
               function (data) {

               $("#eid").val(eid);
                   var html = "<ul>";
                   for(var i = 0; i < data.length; i++){
                       html += "<li>";
                       if(data[i].isHave){
                           html += "<input type='checkbox' name='rid' value='" + data[i].id + "' checked/>";
                       } else {
                           html += "<input type='checkbox' name='rid' value='" + data[i].id + "'/>";
                       }

                       html += data[i].rolename;
                       html + "</li>";
                   }
                       html += "</ul>";
                   $("#role_list").html(html);

                   //弹出dialog
                   $("#role_dialog").dialog({
                       title:"选择角色",
                       width:300,
                       height:200,
                       modal:true
                   });
           },"json")

       }

    </script>
</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>员工管理</h1>
                <table>
                    <thead>
                    <tr>
                        <th><input class="check-all" type="checkbox" /></th>
                        <th>编号</th>
                        <th>图片</th>
                        <th>姓名</th>
                        <th>邮箱</th>
                        <th>性别</th>
                        <th>出生日期</th>
                        <th>入职时间</th>
                        <th>部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                    <c:forEach items="${emps}" var="emp">
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td>${emp.id}</td>
                            <c:if test="${emp.image== null||emp.image==''}">
                                <td><img src="resources/images/icons/header.jpg" width="100"></td>
                            </c:if>
                            <c:if test="${emp.image!=null&&emp.image!=''}">

                                <td><img src="${pageContext.request.contextPath}/img/getImg?path=${emp.image}" width="100" height="90"></td>
                            </c:if>
                            <td>${emp.name}</td>
                            <td>${emp.email}</td>
                            <td>${emp.sex==1?'男':'女'}</td>
                            <td><fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${emp.entrytime}" pattern="yyyy-MM-dd"/> </td>
                            <td>${emp.dname}</td>
                            <td>
                                <!-- Icons --> <a  id="edit_emp_id" onclick="edit_emp(${emp.id});" title="Edit"><img
                                    src="resources/images/icons/pencil.png" alt="Edit" /></a>
                                <a
                                        href="${pageContext.request.contextPath}/emp/delete/${mep.id}" title="Delete"><img
                                        src="resources/images/icons/cross.png" alt="Delete" />
                                </a>
                                <a title="Edit Meta" onclick="open_roles_dialog(${emp.id});">
                                    <img
                                        src="resources/images/icons/hammer_screwdriver.png"
                                        alt="Edit Meta" /></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>


                    <!-- 表的尾部 -->
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <div class="bulk-actions align-left">
                                <shiro:hasPermission name="emp/insert">
                                <a class="mybutton" ONCLICK="openDialog()">新增员工</a>
                                </shiro:hasPermission>
                            </div>
                            <%--<div class="pagination">
                                <a href="#" title="First Page">&laquo; First</a>
                                <a href="#" title="Previous Page">&laquo; Previous</a>
                                <a href="#" class="number" title="1">1</a>
                                <a href="#" class="number" title="2">2</a>
                                <a href="#" class="number current" title="3">3</a>
                                <a href="#" class="number" title="4">4</a>
                                <a href="#" title="Next Page">Next &raquo;</a>
                                <a href="#" title="Last Page">Last &raquo;</a>
                            </div>--%> <!-- End .pagination -->

                            <!-- 分页导航 -->
                            <%@ include file="page.jsp"%>
                            <div class="clear"></div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <!-- End .content-box-content -->
    </div>
</div>
<!-- End #main-content -->
<!--新增弹出框 -->
<div id="dialog_div" style="display: none" >
        <form action="/emp/insert" method="post" >
         <p>
             <input type="hidden" id="id" name="id">
         </p>
        <p>
            <label>照片</label>
            <img id="header"  src="resources/images/icons/header.jpg" width="100">
            <input type="hidden" id="image" name="image" value="" >
            <div id="ck_img">选择图片</div>
        </p>
        <p>
            <label>员工姓名</label>
            <input type="text" name="name" id="emp_name" >
        </p>

        <p>
            <label>员工邮箱</label>
            <input id="emp_email" type="text" name="email">
        </p>
        <p>
            <label>性别</label>
            男<input type="radio" name="sex" checked="checked" value="1"><br/>
            女<input type="radio" name="sex" value="0">
        </p>
        <p>
            <label>选择部门</label>
            <button type="button" id="select_dep_id" class="mybutton" onclick="query_dep();">无</button>
            <input type="hidden" value="-1" name="did" id="did">
        </p>

        <p>
            <label>出生日期</label>
            <input type="text" name="birthday"  class="text-input small-input Wdate"
                   id="birthday_id" onclick="WdatePicker()" >
        </p>
        <p>
            <label>入职时间</label>
            <input type="text" name="entrytime"  class="text-input small-input Wdate"
                   id="entrytime_id" onclick="WdatePicker()" >
        </p>

        <p>
            <input type="submit" value="添加" >
        </p>



    </form>

</div>

<div id="ztree_dialog" style="display: none">
 <div id="zTree" class="ztree"></div>
</div>
 <div id="role_dialog" class="ztree" style="display: none">
     <form action="${pageContext.request.contextPath}/role/selectroles" method="post">
         <!-- 职工的id的隐藏域 -->
         <input type="hidden" name="eid" id="eid" value=""/>
         <!-- 角色列表 -->
         <div id="role_list"></div>
         <button class="mybutton" type="submit">提交</button>
     </form>
 </div>
<script type="text/javascript">
    uploader=WebUploader.create({
        auto:true,
        swf:'${pageContext.request.contextPath}/resources/widget/webuploader/Uploader.swf',
        server:'${pageContext.request.contextPath}/img/upload',
        pick:'#ck_img'
    });

    uploader.on('fileQueued', function(file) {
        var $li =$("#header");
        uploader.makeThumb(file, function( error, src ) {
            if ( error ) {
                return;
            }
                $li.attr("src",src );
        },100,100);

    });
    uploader.on('uploadSuccess', function(file, response){
     debugger
        $("#image").val(response.fileuploader);
    });

    uploader.on('error', function(type){
     alert('失败');
    });

</script>
</body>
</html>