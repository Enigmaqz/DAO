package ru.netology.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@Builder
@Table(name = "orders", schema = "netology_new")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false, name = "product_name")
    private String productName;


}
