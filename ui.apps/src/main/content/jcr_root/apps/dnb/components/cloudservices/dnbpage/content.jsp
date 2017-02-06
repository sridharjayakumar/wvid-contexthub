<%@page session="false"%>
<%@page contentType="text/html"
            pageEncoding="utf-8"
%><%@include file="/libs/foundation/global.jsp"
%><%@include file="/libs/wcm/global.jsp"
%><%@include file="/libs/cq/cloudserviceconfigs/components/configpage/init.jsp"
%>
<cq:setContentBundle/>
<div>
    <h3><fmt:message key=“DnB WVID config/></h3>
     <img src="<%= xssAPI.encodeForHTML(thumbnailPath)%>" alt="<%= xssAPI.encodeForHTML(serviceName)%>" style="float: left;" />
     <ul style="float: left; margin: 0px;">
       <li><div class="li-bullet"><strong><fmt:message key=“WVID key"/>: </strong><%= xssAPI.encodeForHTML(properties.get("wvid", "")) %></div></li>
       <li class="config-successful-message when-config-successful" style="display: none">
       <fmt:message key="WVID key is set successfully" /><br>

       </li>
    </ul>
</div>
