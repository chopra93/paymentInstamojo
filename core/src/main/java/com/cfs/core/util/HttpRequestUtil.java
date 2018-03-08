package com.cfs.core.util;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.UnknownHostException;

public class HttpRequestUtil {
    private static final Logger LOGGER = Logger.getLogger(HttpRequestUtil.class);

    public static HttpResponse post(String url, Header[] headers) {
        HttpPost post = new HttpPost(url);
        post.setHeaders(headers);
        return null;
    }

    public static HttpResponse post(HttpClient client, HttpPost post, String custId) throws ClientProtocolException, IOException {
        HttpResponse response = null;
        int callCount = 1;
        while (callCount < 4) {
            try {
                response = client.execute(post);
                LOGGER.debug("Response Status: " + response.getStatusLine().getStatusCode());
                break;
            } catch (UnknownHostException e) {
                LOGGER.error("UnknownHostException while initiating a POST method call to PG " + custId + e);
                e.printStackTrace();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    LOGGER.error("InterruptedException while waiting to re-try on UnknownHostException for a POST method call " + custId);
                    e.printStackTrace();
                }
            } finally {
                callCount++;
            }
        }
        return response;
    }

    public static HttpResponse get(HttpClient client, HttpGet get, String custId) throws ClientProtocolException, IOException {
        HttpResponse response = null;
        int callCount = 1;
        while (callCount < 4) {
            try {
                response = client.execute(get);
                break;
            } catch (UnknownHostException e) {
                LOGGER.error("UnknownHostException while initiating a GET method call to PG " + custId + e);
                e.printStackTrace();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    LOGGER.error("InterruptedException while waiting to re-try on UnknownHostException for a GET method call " + custId);
                    e.printStackTrace();
                }
            } finally {
                callCount++;
            }
        }
        return response;
    }
}
