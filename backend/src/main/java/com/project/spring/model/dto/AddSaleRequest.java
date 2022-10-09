package com.project.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSaleRequest {
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private String contractId;
    private Long userId;

}
