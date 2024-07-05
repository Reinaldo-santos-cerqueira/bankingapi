package dev.reinaldosantos.bankingapi.domain.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="users")
public class UserModel {
    @GeneratedValue(generator = "UUID")
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Boolean active;

}
