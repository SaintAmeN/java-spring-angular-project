package com.project.spring.controller;

import com.project.spring.component.PrincipalComponent;
import com.project.spring.model.dto.AddSaleRequest;
import com.project.spring.model.dto.SaleDTO;
import com.project.spring.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
@Slf4j
@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final PrincipalComponent principalComponent;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<SaleDTO> getAllSales() {
        log.info("getAllSales called");
        return saleService.getSalesList();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public List<SaleDTO> getUserSales(UsernamePasswordAuthenticationToken principal, @PathVariable Long userId) {
        log.info("getUserSales called");
        principalComponent.getUser(principal, userId);

        return saleService.getSalesList(userId);
    }

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public SaleDTO addSale(UsernamePasswordAuthenticationToken principal, @RequestBody AddSaleRequest request) {
        log.info("addSale called");
        principalComponent.getUser(principal, request.getUserId());

        return saleService.addSale(request);
    }
}
