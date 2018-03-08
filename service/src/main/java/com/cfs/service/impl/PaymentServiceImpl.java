package com.cfs.service.impl;

import com.cfs.core.constants.PaymentConstants;
import com.cfs.core.dto.CreateGetPaymentResponse;
import com.cfs.core.dto.CreatePaymentRequest;
import com.cfs.core.util.HttpRequestUtil;
import com.cfs.core.util.JsonUtils;
import com.cfs.service.IPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author chopra
 * 08/03/18
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    private static final Logger LOGGER = Logger.getLogger(PaymentServiceImpl.class);

    @Override
    public CreateGetPaymentResponse createPayment(CreatePaymentRequest paymentRequest) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(PaymentConstants.CREATE_PAYMENT);

        Header[] headers = {
                new BasicHeader(HttpHeaders.CONTENT_TYPE, PaymentConstants.CONTENT_TYPE),
                new BasicHeader(PaymentConstants.API_KEY_HEADER, PaymentConstants.API_KEY),
                new BasicHeader(PaymentConstants.AUTH_TOKEN_HEADER, PaymentConstants.AUTH_TOKEN) };

        postRequest.setHeaders(headers);
        String body = JsonUtils.serialize(paymentRequest);
        postRequest.setEntity(new StringEntity(body, StandardCharsets.UTF_8));

        HttpResponse response;
        response = HttpRequestUtil.post(client, postRequest, String.valueOf(paymentRequest.getEmail()));

        int responseStatus = response.getStatusLine().getStatusCode();
        String responseContent = EntityUtils.toString(response.getEntity());
        LOGGER.info("responseStatus=" + responseStatus + "responseContent = "+responseContent);

        CreateGetPaymentResponse createGetPaymentResponse = null;
        switch (responseStatus) {
            case HttpStatus.SC_CREATED:
                ObjectMapper mapper = new ObjectMapper();
                createGetPaymentResponse = mapper.readValue(responseContent, CreateGetPaymentResponse.class);
                break;
        }

        LOGGER.info("payment response = "+createGetPaymentResponse);
        return createGetPaymentResponse;
    }

    @Override
    public CreateGetPaymentResponse fetchPayment(String paymentId) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(PaymentConstants.GET_PAYMENT+paymentId);

        Header[] headers = {
                new BasicHeader(PaymentConstants.API_KEY_HEADER, PaymentConstants.API_KEY),
                new BasicHeader(PaymentConstants.AUTH_TOKEN_HEADER, PaymentConstants.AUTH_TOKEN) };

        getRequest.setHeaders(headers);

        HttpResponse response;
        response = HttpRequestUtil.get(client, getRequest, String.valueOf(paymentId));

        int responseStatus = response.getStatusLine().getStatusCode();
        String responseContent = EntityUtils.toString(response.getEntity());
        LOGGER.info("responseStatus=" + responseStatus + "responseContent = "+responseContent);

        CreateGetPaymentResponse createGetPaymentResponse = null;
        switch (responseStatus) {
            case HttpStatus.SC_OK:
                ObjectMapper mapper = new ObjectMapper();
                createGetPaymentResponse = mapper.readValue(responseContent, CreateGetPaymentResponse.class);
                break;
        }

        LOGGER.info("fetch payment response = "+createGetPaymentResponse);
        return createGetPaymentResponse;
    }
}
