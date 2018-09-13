<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8 0008
  Time: 下午 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
     <script type="text/javascript">
    $(function () {
         $("#exportDep_id").click(function() {
             location.href ='/exe/export';
         });
     }

    $("#exportEmp_id").click(function() {
        location.href ='/exe/export';
    })

     )
     </script>
</head>
<body>

<button class="btn" id="exportDep_id">导出部门</button>
<button class="btn" id="exportEmp_id">导出职工</button>
</body>
</html>
