package edu.usmp.sunatmvc.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    private Integer id;
    private String rucEmisor;
    private String rucContribuyente;
    private BigDecimal montoFactura;
    private ZonedDateTime date;
    
}
