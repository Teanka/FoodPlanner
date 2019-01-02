<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<jsp:include page="../dashboard/header.jsp"/>
<jsp:include page="../dashboard/nav.jsp"/>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
       <form:form method="post" modelAttribute="plan">
             <div class="col noPadding">
                <h3 class="color-header text-uppercase">NOWY PLAN</h3>
            </div>

            <div class="col d-flex justify-content-end mb-2 noPadding">
                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
            </div>
        </div>

        <div class="schedules-content">
                <div class="form-group row">
                    <label for="planName" class="col-sm-2 label-size col-form-label">
                        Nazwa planu
                    </label>
                    <div class="col-sm-10">
                      <form:input path="name" type="text" class="form-control" name="name" id="planName"
                       placeholder="Nazwa planu"/>
                      <form:errors path="name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="planDescription" class="col-sm-2 label-size col-form-label">
                        Opis planu
                    </label>
                    <div class="col-sm-10">
                         <form:textarea type="textarea" class="form-control" id="planDescription" rows="5"
                          path="description" placeholder="Opis planu"/>
                         <form:errors path="description"/>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="../dashboard/footer.jsp"/>