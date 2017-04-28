package com.studioprintf.service;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by lucifer on 17-4-26.
 */
public class SSLTrustManager implements javax.net.ssl.X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
