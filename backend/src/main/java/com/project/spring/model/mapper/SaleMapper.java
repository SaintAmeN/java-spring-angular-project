package com.project.spring.model.mapper;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Sale;
import com.project.spring.model.dto.AddSaleRequest;
import com.project.spring.model.dto.SaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Paweł Recław, AmeN
 * @project project_spring
 * @created 10.09.2022
 */
@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "productName", source = "productName"),
            @Mapping(target = "saleDate", ignore = true),
            @Mapping(target = "saleTime", ignore = true),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "unitPrice", source = "unitPrice"),
            @Mapping(target = "contractId", source = "contractId"),
    })
    Sale mapAddSaleRequestToNewSale(AddSaleRequest request);

    @Mappings(value = {
            @Mapping(target = "saleId", source = "sale.id"),
            @Mapping(target = "productName", source = "sale.productName"),
            @Mapping(target = "saleDateTime", expression = "java(sale.getSaleDate().atTime(sale.getSaleTime()))"),
            @Mapping(target = "quantity", source = "sale.quantity"),
            @Mapping(target = "avgUnitPrice", source = "sale.unitPrice"),
            @Mapping(target = "salesPersonFirstName", source = "applicationUser.firstName"),
            @Mapping(target = "salesPersonLastName", source = "applicationUser.lastName"),
    })
    SaleDTO mapSaleAndSalePersonToSaleDTO(Sale sale, ApplicationUser applicationUser);

}