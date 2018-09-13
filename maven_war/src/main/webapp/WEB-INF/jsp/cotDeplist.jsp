<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/7 0007
  Time: 下午 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/"/>
     <script src="resources/scripts/echarts.min.js"></script>
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css"
          media="screen" />
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
          media="screen" />
    <script type="text/javascript" src="resources/scripts/jquery-1.8.3.min.js"></script>
    <!-- jQuery Configuration -->
    <script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>

    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script type="text/javascript" src="resources/widget/dialog/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript">
        function openDialogz() {
            $("#Dialogz").dialog({
                width:500,
                height:400,
                modal:false
            })

        }
        function openDialogb() {
            $("#Dialogb").dialog({
                width:500,
                height:400,
                modal:false
            })

        }
        
    </script>
</head>
<body>
<div id="main-content">
    <div class="content-box">
        <!-- End .content-box-header -->
        <div class="content-box-content">
            <div class="tab-content default-tab" id="tab1">

                <h1>按部门统计管理</h1>
                <button class="mybutton" onclick="openDialogz()">柱状图</button><br/>
                <button class="mybutton" onclick="openDialogb()">饼状图</button>
                <table border="1" width="1" >
                    <thead>
                    <tr>
                        <th>部门</th>
                        <th>人数</th>
                    </tr>
                    </thead>

                    <!-- 表的内容 -->
                    <tbody>
                    <c:forEach items="${depCounts}" var="depCount">
                    <tr>
                        <td>${depCount.dname}</td>
                        <td>${depCount.count}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<div id="Dialogz" style="display: none">
        <div id="main" style="width: 500px;height:250px;">
        </div>
</div>

<div id="Dialogb" style="display: none">
            <div  class="content-box-content" id="mainb" style="width: 400px;height:250px;">
            </div>
</div>
<script>
    var sdm=${sex.man/(sex.man+sex.woman)};
        sdm = sdm.toFixed(2);
    var myChart = echarts.init(document.getElementById('mainb'))
    var option = {
        title : {
            text: '部门人员统计',
            subtext: '人员统计',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [<c:forEach items="${depCounts}" var="depCount">
                '${depCount.dname}',
                </c:forEach>]
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    <c:forEach items="${depCounts}" var="depCount">
                    {value:${depCount.count}, name: '${depCount.dname}'},
                  </c:forEach>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
</script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '部门统计表'
        },
        tooltip: {},
        legend: {
            data:['部门']
        },
        xAxis: {
            data: [
                <c:forEach  items="${depCounts}" var="depCount">
                "${depCount.dname}",
                </c:forEach>
                ]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: [ <c:forEach  items="${depCounts}" var="depCount">
                "${depCount.count}",
                </c:forEach>]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script>

</script>


</body>
</html>
