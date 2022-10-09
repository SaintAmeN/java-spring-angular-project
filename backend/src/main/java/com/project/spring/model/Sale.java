package com.project.spring.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 * <p>
 * product name
 * sale date and time
 * quantity
 * unit price
 * contract number - nie wysyłamy tego w DTO, ukryte pole
 * <p>
 * Constraints:
 * - nie można dodać więcej niż jednej sprzedaży produktu o tej samej nazwie danego dnia i tego samego sprzedawcy (user'a)
 * - zamiast tego
 * - quantity sumujemy
 * - obliczamy średnią cene za jednostkę
 * -
 */
@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"product_name", "sale_date"})})
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @CreationTimestamp
    @Column(name = "sale_date")
    private LocalDate saleDate;

    @CreationTimestamp
    private LocalTime saleTime;

    private int quantity;
    private BigDecimal unitPrice;
    private String contractId;

    // Linked entities
    //
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ApplicationUser user;
}
