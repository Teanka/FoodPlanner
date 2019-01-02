<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="../dashboard/header.jsp"/>
<jsp:include page="../dashboard/nav.jsp"/>


    <div class="m-4 p-3 width-medium">
        <div class="dashboard-content border-dashed p-3 m-4 view-height">
            <div class="row border-bottom border-3 p-1 m-1">
             <form:form method="post"  modelAttribute="recipePlan">
                <div class="col noPadding">
                    <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
                </div>
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4" type="submit">Zapisz
                    </button>
                </div>
            </div>
            <div class="schedules-content">
                <div class="form-group row">
                    <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                        Wybierz plan
                    </label>
                    <div class="col-sm-3">
                        <form:select class="form-control" path="plan.id" items="${plans}" itemLabel="name"
                                     itemValue="id" id="choosePlan"/>
                        <form:errors path="plan" element="div" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nameId" class="col-sm-2 label-size col-form-label">
                        Nazwa posiłku
                    </label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" path="mealName" id="nameId"
                                    placeholder="Nazwa posiłku"/>
                        <form:errors path="mealName" element="div" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="numberId" class="col-sm-2 label-size col-form-label">
                        Numer posiłku
                    </label>
                    <div class="col-sm-2">
                        <form:input type="number" class="form-control" path="order" id="numberId"
                                    placeholder="Numer posiłku"/>
                        <form:errors path="order"  cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="recipeId" class="col-sm-2 label-size col-form-label">
                        Przepis
                    </label>
                    <div class="col-sm-4">
                        <form:select class="form-control" path="recipe" items="${recipes}"
                                     itemLabel="name" itemValue="id" id="recipeId"/>
                        <form:errors path="recipe"  cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dayId" class="col-sm-2 label-size col-form-label">
                        Dzień
                    </label>
                    <div class="col-sm-2">
                        <form:select class="form-control" path="dayName.id" items="${days}" itemLabel="name"
                                     itemValue="id" id="dayId"/>
                        <form:errors path="dayName.id"  cssClass="error"/>
                    </div>
                </div>
            </div>
            </form:form>
        </div>
    </div>

<jsp:include page="../dashboard/footer.jsp"/>