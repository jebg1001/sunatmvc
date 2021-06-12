package edu.usmp.sunatmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_factura")
public class Fact{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rucEmisor;
    private String rucContribuyente;
    private BigDecimal montoFactura;
    @Temporal(TemporalType.DATE)
    private Date date;
}
