package edu.usmp.sunatmvc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "user_id")
    private String ruc;
    private String password;
    
}
