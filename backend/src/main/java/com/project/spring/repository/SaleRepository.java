package com.project.spring.repository;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByUser(ApplicationUser user);
    Optional<Sale> findByUserAndSaleDateAndProductName(ApplicationUser user, LocalDate date, String productName);
}
