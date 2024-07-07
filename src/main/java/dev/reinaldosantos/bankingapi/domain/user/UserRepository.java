package dev.reinaldosantos.bankingapi.domain.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
}