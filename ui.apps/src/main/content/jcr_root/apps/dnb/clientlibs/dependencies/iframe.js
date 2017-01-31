var iframe;
iframe = document.createElement('iframe');
iframe.style = 'display:none;position:absolute;clip:rect(0px 0px 0px 0px)';
iframe.name = "__dnbframe";
iframe.src = "about:blank";
document.body.appendChild(iframe);

var tag = document.createElement("script");
tag.type = "text/javascript";
tag.src = "http://ecf.d41.co/sync/";
document.getElementsByTagName('head')[0].appendChild(tag);

var dnbStore = ContextHub.getStore("dnb-persisted-store");
//Set WVID Key using cloud config
var wvid_key = "${wvid.key}";

dnbvid.getData(wvid_key, "json", "t", function (dnb_Data) {
    console.log("Called WVID with status: " + dnb_Data.status);
    if (dnb_Data.status === "200") {
        dnbStore.setItem('duns', dnb_Data.duns);
        dnbStore.setItem('companyName', dnb_Data.companyName);
        dnbStore.setItem('companyMSA', dnb_Data.companyMSA);
        dnbStore.setItem('companyCountry', dnb_Data.companyCountry);
        dnbStore.setItem('parentDUNS', dnb_Data.parentDUNS);
        dnbStore.setItem('domesticUltimateDUNS', dnb_Data.domesticUltimateDUNS);
        dnbStore.setItem('ultimateDUNS', dnb_Data.ultimateDUNS);
        dnbStore.setItem('industryNAICS', dnb_Data.industryNAICS);
        dnbStore.setItem('salesAnnual', dnb_Data.salesAnnual);
        dnbStore.setItem('employeesInAllLocations', dnb_Data.employeesInAllLocations);
        dnbStore.setItem('jobFunction', dnb_Data.jobFunction);
        dnbStore.setItem('jobSeniority', dnb_Data.jobSeniority);
    }
});