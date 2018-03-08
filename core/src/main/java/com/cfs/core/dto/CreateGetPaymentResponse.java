package com.cfs.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chopra
 * 08/03/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateGetPaymentResponse {

    private String success;
    private PaymentRequest paymentRequest;
    private PaymentResponse paymentResponse;

    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(String success) {
        this.success = success;
    }

    @JsonProperty("paymentRequest")
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    @JsonProperty("payment_request")
    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    @JsonProperty("payment")
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    @JsonProperty("payment")
    public void setPaymentResponse(PaymentResponse paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    @Override
    public String toString() {
        return "CreateGetPaymentResponse{" +
                "success='" + success + '\'' +
                ", paymentRequest=" + paymentRequest +
                ", paymentResponse=" + paymentResponse +
                '}';
    }
}
