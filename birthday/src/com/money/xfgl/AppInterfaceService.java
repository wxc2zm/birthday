
package com.money.xfgl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AppInterfaceService", targetNamespace = "http://appInterface.xfgl.money.com/", wsdlLocation = "http://192.168.2.105:8080/Service/AppInterfaceService?wsdl")
public class AppInterfaceService
    extends Service
{

    private final static URL APPINTERFACESERVICE_WSDL_LOCATION;
    private final static WebServiceException APPINTERFACESERVICE_EXCEPTION;
    private final static QName APPINTERFACESERVICE_QNAME = new QName("http://appInterface.xfgl.money.com/", "AppInterfaceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.2.105:8080/Service/AppInterfaceService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        APPINTERFACESERVICE_WSDL_LOCATION = url;
        APPINTERFACESERVICE_EXCEPTION = e;
    }

    public AppInterfaceService() {
        super(__getWsdlLocation(), APPINTERFACESERVICE_QNAME);
    }

    public AppInterfaceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), APPINTERFACESERVICE_QNAME, features);
    }

    public AppInterfaceService(URL wsdlLocation) {
        super(wsdlLocation, APPINTERFACESERVICE_QNAME);
    }

    public AppInterfaceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, APPINTERFACESERVICE_QNAME, features);
    }

    public AppInterfaceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AppInterfaceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AppInterface
     */
    @WebEndpoint(name = "AppInterfacePort")
    public AppInterface getAppInterfacePort() {
        return super.getPort(new QName("http://appInterface.xfgl.money.com/", "AppInterfacePort"), AppInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppInterface
     */
    @WebEndpoint(name = "AppInterfacePort")
    public AppInterface getAppInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://appInterface.xfgl.money.com/", "AppInterfacePort"), AppInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (APPINTERFACESERVICE_EXCEPTION!= null) {
            throw APPINTERFACESERVICE_EXCEPTION;
        }
        return APPINTERFACESERVICE_WSDL_LOCATION;
    }

}
