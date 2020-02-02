<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>
        <form method="get" action="/general">
            <input type="text" name="filter" value="${filter!" "}"/>
            <button type="submit">Search</button>
        </form>
    </div>
    <div>
        <form method="post">
            <input type="text" name="article"/>
            <div> <input type="text" name="text"/> </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Send</button>
        </form>
    </div>
    <div>Messages</div>
    <#list messages as message>
        <div>
            <i>${message.authorName}</i>:
            <b>${message.article}</b>
            <div> <span>${message.text}</span> </div>
        </div>
    <#else> No messages yet;
    </#list>
</@c.page>