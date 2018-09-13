<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29 0029
  Time: 下午 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/"/>
    <title>Title</title>
    <script type="text/javascript"
            src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>

</head>
<body>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>部门名称</th>
        <th>所属父部门</th>
        <th>部门描述</th>
        <th>成立时间</th>
        <th>操作</th>
    </tr>
    </thead>

    <!-- 表的内容 -->
    <tbody>
    <c:forEach items="${deps}" var="dep">
        <tr>
            <td>${dep.id}</td>
            <td>${dep.dname}</td>
            <td>${dep.parent.dname != null ? dep.parent.dname : '无'}</td>
            <td>${dep.dinfo}</td>
            <td></td>
                <%--
                                            <td><fmt:formatDate value="${dep.createtime}" pattern="yyyy-MM-dd"/></td>
                --%>
            <td>
                <!-- Icons --> <a href="#" title="Edit"><img
                    src="resources/images/icons/pencil.png" alt="Edit" /></a>
                <a
                        href="${pageContext.request.contextPath}/dep/delete/${dep.id}" title="Delete"><img
                        src="resources/images/icons/cross.png" alt="Delete" />
                </a>
                <a
                        href="#" title="Edit Meta"><img
                        src="resources/images/icons/hammer_screwdriver.png"
                        alt="Edit Meta" /></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
