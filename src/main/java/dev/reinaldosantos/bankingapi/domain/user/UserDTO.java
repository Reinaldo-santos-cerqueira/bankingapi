package dev.reinaldosantos.bankingapi.domain.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    @Min(5)
    @Max(255)
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Max(255)
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Max(255)
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;
    @NotNull(message = "Role is mandatory")
    @Pattern(regexp = "ADMIN|COMMON|ROLE_USER", message = "The user role must be ADMIN, COMMON ou ROLE_USER.")
    @Enumerated(EnumType.STRING)
    private UserRole role; 
}
