package com.mendel.challenge.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TransactionRequest {

    private String type;
    private Long parent_id;
    private double amount;
}
