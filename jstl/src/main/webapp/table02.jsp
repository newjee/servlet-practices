<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
  <c:set var="row" value="${param.r }" />
  <c:set var="col" value="${param.c }" />

  <c:if test="${empty row}">
    <c:set var="row" value="3"  />
  </c:if>
  <c:if test="${empty col}">
    <c:set var="row" value="3"  />
  </c:if>

  <table border="1" cellspacing="0" cellpadding="10">
    <c:forEach begin="0" end="${row-1 }" step="1" var="i">
      <tr>
        <c:forEach begin="0" end="${col-1}" step="1" var="j"></c:forEach>
      </tr>
    </c:forEach>

$END$
</body>
</html>
