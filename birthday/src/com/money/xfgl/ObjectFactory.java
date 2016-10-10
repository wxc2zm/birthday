
package com.money.xfgl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.money.xfgl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GuestLogin_QNAME = new QName("http://appInterface.xfgl.money.com/", "guestLogin");
    private final static QName _GuestLoginResponse_QNAME = new QName("http://appInterface.xfgl.money.com/", "guestLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.money.xfgl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuestLoginResponse }
     * 
     */
    public GuestLoginResponse createGuestLoginResponse() {
        return new GuestLoginResponse();
    }

    /**
     * Create an instance of {@link GuestLogin }
     * 
     */
    public GuestLogin createGuestLogin() {
        return new GuestLogin();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuestLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://appInterface.xfgl.money.com/", name = "guestLogin")
    public JAXBElement<GuestLogin> createGuestLogin(GuestLogin value) {
        return new JAXBElement<GuestLogin>(_GuestLogin_QNAME, GuestLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuestLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://appInterface.xfgl.money.com/", name = "guestLoginResponse")
    public JAXBElement<GuestLoginResponse> createGuestLoginResponse(GuestLoginResponse value) {
        return new JAXBElement<GuestLoginResponse>(_GuestLoginResponse_QNAME, GuestLoginResponse.class, null, value);
    }

}
