package com.project.spring.service;

import com.project.spring.model.dto.AddSaleRequest;
import com.project.spring.model.dto.SaleDTO;

import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
public interface SaleService {
    List<SaleDTO> getSalesList();

    List<SaleDTO> getSalesList(Long userId);

    SaleDTO addSale(AddSaleRequest request);
}
