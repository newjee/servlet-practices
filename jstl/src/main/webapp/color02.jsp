<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <c:choose>
        <c:when test='${param.c == "red"} '>
            <h1 style="color:red">Hello World</h1>
        </c:when>

        <c:when test='${param.c == "red"} '>
            <h1 style="color:green">Hello World</h1>
        </c:when>

        <c:when test='${param.c == "red"} '>
            <h1 style="color:blue">Hello World</h1>
        </c:when>

    </c:choose>
</body>
</html>
