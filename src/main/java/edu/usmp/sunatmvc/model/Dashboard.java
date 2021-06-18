package edu.usmp.sunatmvc.model;

import javax.persistence.Entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dashboard {

    private int numClientes;
    private int cantEmisores;
    private int cantContrib;
    private BigDecimal cantDinero;
    private ZonedDateTime fecha;
}
