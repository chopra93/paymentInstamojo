package com.cfs.api;

import com.cfs.core.constants.PaymentConstants;
import com.cfs.core.dto.CreateGetPaymentResponse;
import com.cfs.core.dto.CreatePaymentRequest;
import com.cfs.service.IPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * @author chopra
 * 08/03/18
 */
@RestController
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class);

    @Autowired
    private IPaymentService paymentService;

    @RequestMapping(value = "/v1/test", method = RequestMethod.GET)
    public ResponseEntity testFunction(){
        return ResponseEntity.ok("ok");
    }

    @RequestMapping(value = "/v1/pay", method = RequestMethod.POST)
    public ResponseEntity sendPayment(@RequestBody CreatePaymentRequest paymentRequest,
                                      @Context HttpServletRequest requestContext){
        try {
            if (paymentRequest != null){
                paymentRequest.setAllowRepeatedPayments(false);
                paymentRequest.setSendEmail(false);
                paymentRequest.setSendSMS(false);
                paymentRequest.setWebhook(PaymentConstants.WEBHOOK_URL);
                paymentRequest.setRedirectURL(PaymentConstants.REDIRECT_URL);
            }
            CreateGetPaymentResponse paymentResponse = paymentService.createPayment(paymentRequest);
            if (paymentResponse!= null){
                return ResponseEntity.ok(paymentResponse);
            }
            else {
                return new ResponseEntity<>(PaymentConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOGGER.info(PaymentConstants.ERROR);
            return new ResponseEntity<>(PaymentConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/v1/getInfo", method = RequestMethod.GET)
    public ResponseEntity getPayment(@RequestParam(name = "paymentId", required = true)String paymentId,
                                      @Context HttpServletRequest requestContext){
        try {
            CreateGetPaymentResponse paymentResponse = paymentService.fetchPayment(paymentId);
            if (paymentResponse!= null){
                return ResponseEntity.ok(paymentResponse);
            }
            else {
                return new ResponseEntity<>(PaymentConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOGGER.info(PaymentConstants.ERROR);
            return new ResponseEntity<>(PaymentConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
