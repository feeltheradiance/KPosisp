<#import "parts/common.ftlh" as c>

<@c.page>
    List of trips
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Seats</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list trips as trip>
            <tr>
                <td>${trip.authorName}</td>
                <td>${trip.seats}</td>
                <td><a href="/trip/${trip.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>