package com.project.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private Long saleId;
    private String productName;

    private LocalDateTime saleDateTime;
    private int quantity;
    private BigDecimal avgUnitPrice;

    private String salesPersonFirstName;
    private String salesPersonLastName;
}
