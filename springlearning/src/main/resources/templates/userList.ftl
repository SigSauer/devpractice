<#import "parts/common.ftl" as c>

<@c.page>
    List of Users

    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username!}</td>
                <td>
                    <#list user.roles as role>${role}<#sep>, </#list>
                </td>
                <td><a href="/users/${user.id}">Edit</a> </td>
            </tr>
        <#else>

            <label title="No users on request"/>

        </#list>
        </tbody>

    </table>
</@c.page>