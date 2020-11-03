<html>
<head>
    <title>Users</title>
</head>
<body>
<#if users?has_content>
    <ul>
        <#list users as user>
            <li>${user.name} </li>
        </#list>
    </ul>
<#else>
    <p>No users yet</p>
</#if>
</body>
</html>