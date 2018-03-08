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
public class PaymentResponse {

    private String paymentId;
    private String status;
    private String buyerName;
    private String buyerPhone;
    private String buyerEmail;
    private String unitPrice;

    @JsonProperty("paymentId")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("payment_id")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("buyerName")
    public String getBuyerName() {
        return buyerName;
    }

    @JsonProperty("buyer_name")
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @JsonProperty("buyerPhone")
    public String getBuyerPhone() {
        return buyerPhone;
    }

    @JsonProperty("buyer_phone")
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    @JsonProperty("buyerEmail")
    public String getBuyerEmail() {
        return buyerEmail;
    }

    @JsonProperty("buyer_email")
    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @JsonProperty("unitPrice")
    public String getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("unit_price")
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "paymentId='" + paymentId + '\'' +
                ", status='" + status + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
