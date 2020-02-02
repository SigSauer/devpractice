<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <b>Registration Page</b>
    ${message!" "}
    <@l.login "/registration" />
    <a href="/login">Login</a>
</@c.page>