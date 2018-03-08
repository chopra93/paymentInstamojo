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
public class PaymentRequest {

    private String phone;
    private String email;
    private String buyerName;
    private String amount;
    private String purpose;
    private String status;
    private String longURL;

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }


    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("buyerName")
    public String getBuyerName() {
        return buyerName;
    }

    @JsonProperty("buyer_name")
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("purpose")
    public String getPurpose() {
        return purpose;
    }

    @JsonProperty("purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("longURL")
    public String getLongURL() {
        return longURL;
    }

    @JsonProperty("longurl")
    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", amount='" + amount + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status='" + status + '\'' +
                ", longURL='" + longURL + '\'' +
                '}';
    }
}
