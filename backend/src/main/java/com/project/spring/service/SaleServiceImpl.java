package com.project.spring.service;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Sale;
import com.project.spring.model.dto.AddSaleRequest;
import com.project.spring.model.dto.SaleDTO;
import com.project.spring.model.mapper.SaleMapper;
import com.project.spring.repository.ApplicationUserRepository;
import com.project.spring.repository.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final ApplicationUserRepository applicationUserRepository;
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public List<SaleDTO> getSalesList() {
        return saleRepository.findAll()
                .stream()
                .map(sale -> {
                    return saleMapper.mapSaleAndSalePersonToSaleDTO(sale, sale.getUser());
                }).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> getSalesList(Long userId) {
        ApplicationUser applicationUser = applicationUserRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);

        return saleRepository.findAllByUser(applicationUser)
                .stream()
                .map(sale -> {
                    return saleMapper.mapSaleAndSalePersonToSaleDTO(sale, sale.getUser());
                }).collect(Collectors.toList());
    }

    @Override
    public SaleDTO addSale(AddSaleRequest request) {
        ApplicationUser applicationUser = applicationUserRepository.findById(request.getUserId())
                .orElseThrow(EntityNotFoundException::new);

        Sale sale = saleRepository
                .findByUserAndSaleDateAndProductName(applicationUser, LocalDate.now(), request.getProductName())
                .orElse(null);

        if (sale == null) {
            // stworzyliśmy nowy rekord ze sprzedażą
            sale = saleMapper.mapAddSaleRequestToNewSale(request);
        } else {
            // musimy dopisać ilość/cenę itd. do istniejącego rekordu
            double priceSum = sale.getUnitPrice().doubleValue() * sale.getQuantity();
            double priceSumNewSale = request.getUnitPrice().doubleValue() * request.getQuantity();

            sale.setQuantity(sale.getQuantity() + request.getQuantity());
            sale.setUnitPrice(BigDecimal.valueOf(sale.getQuantity() / (priceSum + priceSumNewSale)));
        }

        // zapis do bazy
        sale.setUser(applicationUser);
        sale = saleRepository.save(sale);

        // zwracamy rekord
        return saleMapper.mapSaleAndSalePersonToSaleDTO(sale, sale.getUser());
    }
}
