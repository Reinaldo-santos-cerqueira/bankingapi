package dev.reinaldosantos.bankingapi.domain.paymentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentTypeDto {
    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;
}
