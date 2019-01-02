<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="../dashboard/header.jsp"/>
<jsp:include page="../dashboard/nav.jsp"/>
<div class="m-4 p-4 border-dashed" style="width: 100%;">
    <h1 class="dashboard-content-title">
        <span>Czy na pewno chcesz usunąć <strong>${item.name}</strong>?</span>
    </h1>
    <div style="text-align: center;">
        <a href="<c:url value='/plans'/>" class="btn btn-info rounded-0 text-light m-1">Anuluj</a>
        <form action="/plans/delete/${item.id}" method="post" style="display: inline-block;">
            <input type="submit" class="btn btn-danger rounded-0 text-light m-1" value="Usuń">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
<jsp:include page="../dashboard/footer.jsp"/>