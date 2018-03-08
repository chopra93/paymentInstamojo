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
public class CreatePaymentRequest {

    private Boolean allowRepeatedPayments;
    private String amount;
    private String buyerName;
    private String purpose;
    private String redirectURL;
    private Boolean sendEmail;
    private String webhook;
    private Boolean sendSMS;
    private String email;

    @JsonProperty("allow_repeated_payments")
    public Boolean getAllowRepeatedPayments() {
        return allowRepeatedPayments;
    }

    @JsonProperty("allowRepeatedPayments")
    public void setAllowRepeatedPayments(Boolean allowRepeatedPayments) {
        this.allowRepeatedPayments = allowRepeatedPayments;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("buyer_name")
    public String getBuyerName() {
        return buyerName;
    }

    @JsonProperty("buyerName")
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @JsonProperty("purpose")
    public String getPurpose() {
        return purpose;
    }

    @JsonProperty("purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @JsonProperty("redirect_url")
    public String getRedirectURL() {
        return redirectURL;
    }

    @JsonProperty("redirectURL")
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    @JsonProperty("send_email")
    public Boolean getSendEmail() {
        return sendEmail;
    }

    @JsonProperty("sendEmail")
    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    @JsonProperty("webhook")
    public String getWebhook() {
        return webhook;
    }


    @JsonProperty("webhook")
    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }


    @JsonProperty("send_sms")
    public Boolean getSendSMS() {
        return sendSMS;
    }


    @JsonProperty("sendSMS")
    public void setSendSMS(Boolean sendSMS) {
        this.sendSMS = sendSMS;
    }


    @JsonProperty("email")
    public String getEmail() {
        return email;
    }


    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CreatePaymentRequest{" +
                "allowRepeatedPayments=" + allowRepeatedPayments +
                ", amount='" + amount + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", redirectURL='" + redirectURL + '\'' +
                ", sendEmail=" + sendEmail +
                ", webhook='" + webhook + '\'' +
                ", sendSMS=" + sendSMS +
                ", email='" + email + '\'' +
                '}';
    }
}
