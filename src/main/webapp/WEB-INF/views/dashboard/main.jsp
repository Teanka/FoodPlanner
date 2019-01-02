<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<div class="m-4 p-4 width-medium">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="<c:url value='/recipes/add'/>">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="<c:url value='/plans/add'/>">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj plan</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="<c:url value='/recipes/plan/add'/>">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis do planu</span>
                </a>
            </div>
        </div>

        <div class="dashboard-alerts">
            <div class="alert-item alert-info">
                <i class="fas icon-circle fa-info-circle"></i>
                <span class="font-weight-bold">Liczba przepisów: ${recipes_count}</span>
            </div>
            <div class="alert-item alert-light">
                <i class="far icon-calendar fa-calendar-alt"></i>
                <span class="font-weight-bold">Liczba planów: ${plans_count}</span>
            </div>
        </div>
    </div>
    <div class="m-4 p-4 border-dashed">
        <h2 class="dashboard-content-title">
            <span>Ostatnio dodany plan:</span> ${last_plan_name}
        </h2>
        <c:forEach var="entry" items="${last_plan}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">${entry.key}</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${entry.value}">
                    <tr class="d-flex">
                        <td class="col-2">${dto.mealName}</td>
                        <td class="col-8">${dto.recipeName}</td>
                        <td class="col-2">
                            <a href="<c:url value='/recipes/${dto.recipeId}'/>">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>
</div>
<jsp:include page="footer.jsp"/>