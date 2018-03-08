package com.cfs.core.constants;

/**
 * @author chopra
 * 08/03/18
 */
public class PaymentConstants {

    public static final String API_KEY_HEADER = "X-Api-Key";
    public static final String AUTH_TOKEN_HEADER = "X-Auth-Token";

    public static final String API_KEY = "777f5964fdadf64860acbddcf407969e";
    public static final String AUTH_TOKEN = "ee4398c936bcda0e90459d39382aee4f";

    public static final String CREATE_PAYMENT = "https://www.instamojo.com/api/1.1/payment-requests/";
    public static final String GET_PAYMENT = "https://www.instamojo.com/api/1.1/payments/";

    public static final String ERROR = "error";
    public static final String CONTENT_TYPE = "application/json";

    public static final String REDIRECT_URL = "http://cfs.com";
    public static final String WEBHOOK_URL = "http://cfs.com";
}
