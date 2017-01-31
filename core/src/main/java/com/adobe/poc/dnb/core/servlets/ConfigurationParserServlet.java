package com.adobe.poc.dnb.core.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import com.day.cq.wcm.webservicesupport.Configuration;
import com.day.cq.wcm.webservicesupport.ConfigurationManager;

@SlingServlet(methods = "GET", paths = "/bin/dnb/properties")
public class ConfigurationParserServlet extends SlingSafeMethodsServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    ConfigurationManager cfgMgr;

    String wvid;

    String integrationToken;

    String log;

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        response.setContentType("application/json");
        JSONObject jsonObject = new JSONObject();
        String path = request.getParameter("path");
        ResourceResolver resolver = request.getResourceResolver();
        cfgMgr = resolver.adaptTo(ConfigurationManager.class);
        Resource currentResource = resolver.resolve(path);
        InheritanceValueMap pageProperties = new HierarchyNodeInheritanceValueMap(currentResource);
        getwvidAndintegrationToken(pageProperties);
        try {
            jsonObject.put("wvid", wvid);
            response.getWriter().print(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getwvidAndintegrationToken(InheritanceValueMap pageProperties) {
        String[] services = (String[]) pageProperties.getInherited("cq:cloudserviceconfigs", String[].class);
        Configuration cfg = cfgMgr.getConfiguration("dnb", services);
        if (cfg != null) {
            this.wvid = (String) cfg.get("wvid", null);
        }

    }
}
