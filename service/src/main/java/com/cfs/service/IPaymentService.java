package com.cfs.service;

import com.cfs.core.dto.CreateGetPaymentResponse;
import com.cfs.core.dto.CreatePaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * @author chopra
 * 08/03/18
 */
public interface IPaymentService {
    CreateGetPaymentResponse createPayment(CreatePaymentRequest paymentRequest) throws IOException;
    CreateGetPaymentResponse fetchPayment(String paymentId) throws IOException;
}
