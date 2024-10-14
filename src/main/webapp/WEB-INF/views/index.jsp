<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<script src="/js/index.js"></script>
<script>

</script>
<html>
    <head>
        <meta charset="UTF-8">
        <title>주문조회</title>
    </head>
<style>
    table {
        width: 50%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: lightgray;
    }

    .btn {
        padding: 10px;
    }
</style>
<body>
    <h1>휴머스온 주문 조회 시스템</h1>


    <div>
        <div class="btn">
            <button id="reloadBtn" onclick="reloadBtn();">새로고침</button>
        </div>
        <!-- <div class="btn">
            <button>외부시스템에 데이터 전송</button>
        </div>
        <div class="btn">
            <label>주문 ID :</label>
            <input></input>
            <button>아이디 주문 조회</button>
        </div> -->
    </div>
    <div>
        <table>
            <thead>
                <tr>
                    <th>주문 ID</th>
                    <th>고객명</th>
                    <th>주문 날짜</th>
                    <th>주문 상태</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty orderList}">
                        <tr>
                            <td>주문 목록이 없습니다</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="order" items="${orderList}">
                            <tr>
                                <td>${order.orderId}</td>
                                <td>${order.orderName}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.orderType}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>