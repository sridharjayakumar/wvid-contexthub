D&B WVID (Web Visitor ID) ContextHub for AEM

What it does?
-------------
Provides information about the visitor and their company based on cookies and IP. The component can be used to analyze visitor data and define segmentation rules based on visitor and company attributes.

How to install?
---------------
Using Apache Maven 3:

If you have a running AEM instance you can build and package the whole project and deploy into AEM with
mvn clean install -PautoInstallPackage

Or to deploy it to a publish instance, run
mvn clean install -PautoInstallPackagePublish

Or to deploy only the bundle to the author, run
mvn clean install -PautoInstallBundle

How is D&B WVID integrated?
---------------------------
WVID pixel uses an iframe and two JS dependencies (local dnb_coretag_v2.min.js and remote http://ecf.d41.co/sync/) which are loaded as clientlibs dependencies.
Once loaded WVID pixel makes two external API calls to fetch the visitor data using cookies and IP as input. After the data is fetched, it is being persisted in the store.

Package containing WVID pixel dependencies and sample store and renderer implementation:
src/main/content/jcr_root/apps/sample/clientlibs

How to configure?
-----------------
WVID requires a user key which can be configured in two ways:

1. At install: mvn clean install -PautoInstallPackage -Dwvid.key=ADE9999 (will set wvid.key in src/main/content/jcr_root/apps/sample/clientlibs/dependencies/iframe.js)

2. Using a servlet (com.adobe.poc.sample.core.servlets.ConfigurationParserServlet.java)
