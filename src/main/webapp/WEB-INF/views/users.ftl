<h1>${greeting}</h1>
<table>
    <tr>
        <th>User</th>
        <th>Email</th>
    </tr>
    <#list users as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.email}</td>
    </tr>
    </#list>
</table>