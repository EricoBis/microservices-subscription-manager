package com.engsof2.payment_service.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long codAssinatura;

    private Double valorPago;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
}
