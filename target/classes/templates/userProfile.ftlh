<#import "parts/common.ftlh" as c>

<@c.page>
    Hello, ${user.username}, here is your cabinet!
    <form method="post">
        Изменить профиль<br>
        <input type="hidden" value="${_csrf.token}" name="_csrf"/>
        <input type="text" value="${user.username}" name="username"><br>
        <input type="password" value="${user.password}" name="password">
    </form>
    <br><br>
    <h2>Список ваших поездок(пассажир)</h2>
    <#list trips as trip>
        <div>
            №<b>${trip.id}</b> из <span>${trip.fromCity}</span> в <i>${trip.toCity}</i><br>
            водитель <strong>${trip.authorName}</strong>, места ${trip.seats}<br>
            ${trip.comment!}<br>
            <a href="/trip/${trip.id}">Подребнее</a><br><br>
        </div>
    <#else> Поездок нет
    </#list>
    <br><br>
    <h2>Список ваших поездок(водитель)</h2>
    <#list mytrips as trip>
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