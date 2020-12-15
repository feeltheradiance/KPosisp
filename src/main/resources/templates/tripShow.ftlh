<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="px-0">
        <div class="table-wrapper">
            <table class="table table-hover mb-0">
            <tbody>
            <tr>
                <td>Водитель</td>
                <td>${trip.authorName}</td>
            </tr>
            <tr>
                <td>Из</td>
                <td>${trip.fromCity}</td>
            </tr>
            <tr>
                <td>В</td>
                <td>${trip.toCity}</td>
            </tr>
            <tr>
                <td>Дата</td>
                <td>${trip.stringDate}</td>
            </tr>
            <tr>
                <td>Места</td>
                <td>${trip.seats}</td>
            </tr>
            <tr>
                <td>Комментарий</td>
                <td>${trip.comment!}</td>
            </tr>
            <tr>
                <td>Пассажиры</td>
                <td><#list trip.seaters as seater>
                        ${seater.username}<br>
                        <#else>
                        Нет пассажиров
                    </#list></td>
            </tr>
            </tbody>
            </table>
        </div>
    </div>
<br>
    <#if trip.seats != 0 && notinseaters == "yes">
        <div>
            <form method="post">
                <input type="hidden" value="${_csrf.token}" name="_csrf"/>
                <input type="hidden" value="${trip.id}" name="tripId"/>
                <button type="submit" class="btn btn-primary">Добавиться</button>
            </form>
        </div>
    </#if>
</@c.page>