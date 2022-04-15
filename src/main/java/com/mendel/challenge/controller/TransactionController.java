package com.mendel.challenge.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mendel.challenge.request.TransactionRequest;
import com.mendel.challenge.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    private TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }

    @PutMapping("/{transaction_id}")
    public ResponseEntity putTransacction(@RequestBody TransactionRequest request, @PathVariable Long transaction_id) {
        try {
                LOGGER.info("[TRANSACTION_CONTROLLER][PUT_TRANSACCTION]");
                service.putTransaction(request, transaction_id);
                return ResponseEntity.ok().build();
        }catch (Exception e){
            LOGGER.error("[TRANSACTION_CONTROLLER][PUT_TRANSACCTION]Error " + e.getStackTrace());
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }

    @GetMapping("/types/{type}")
    public ResponseEntity<List<Long>> getByType(@PathVariable String type) {
        try {
            LOGGER.info("[TRANSACTION_CONTROLLER][GET_BY_TYPE]");
            List<Long> ids = service.getByType(type);
            return ResponseEntity.status(HttpStatus.OK).body(ids);
        }catch (Exception e){
            LOGGER.error("[TRANSACTION_CONTROLLER][GET_BY_TYPE] Error " + e.getStackTrace());
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }

    @GetMapping("/sum/{transaction_id}")
    public ResponseEntity<Object> getSum(@PathVariable Long transaction_id) {
        try {
            LOGGER.info("[TRANSACTION_CONTROLLER][GET_SUM]");
            double sum = service.getSum(transaction_id);
            Map<String, Object> response = new HashMap<>();
            response.put("sum", sum);
            return ResponseEntity.status(HttpStatus.OK).body(response.toString());
        }catch (Exception e){
            LOGGER.error("[TRANSACTION_CONTROLLER][GET_SUM] Error " + e.getStackTrace());
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }
}
