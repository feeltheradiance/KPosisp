<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <span><a href="/trip/new">Новая поездка</a></span>
    </div>
    <form class="row gy-2 gx-3 align-items-center" method="get">
        <h2>ПОИСК</h2>
        <div class="col-auto">
            <input type="text" class="form-control" name="filterFrom" placeholder="From">
        </div>
        <div class="col-auto">
            <input type="text" class="form-control" name="filterTo" placeholder="To">
        </div>
        <div class="col-auto">
            <input type="date" class="form-control" name="filterDate">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Найти</button>
        </div>
    </form>
    <div>СПИСОК ПОЕЗДОК</div>
    <#list trips as trip>
        <div>
            №<b>${trip.id}</b> из <span>${trip.fromCity}</span> в <i>${trip.toCity}</i><br>
            водитель <strong>${trip.authorName}</strong>, места ${trip.seats}<br>
            ${trip.stringDate}<br>
            ${trip.comment!}<br>
            <a href="/trip/${trip.id}">Подребнее</a><br><br>
        </div>
        <#else> Поездок нет
    </#list>
</@c.page>