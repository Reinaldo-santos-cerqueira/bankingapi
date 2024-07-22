package dev.reinaldosantos.bankingapi.domain.paymentType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController()
@RequestMapping("/paymentType")
@RequiredArgsConstructor
public class PaymentTypeControllers {
    private final PaymentTypeService paymentTypeService;

    @GetMapping("")
    public ResponseEntity<List<PaymentType>> getAll() {
        return ResponseEntity.ok(this.paymentTypeService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<PaymentType> create(@Valid @RequestBody PaymentTypeDto paymentTypeDto) {
        return ResponseEntity.ok(this.paymentTypeService.create(paymentTypeDto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDescription(@PathVariable String id,@Valid @RequestBody PaymentTypeDto paymentTypeDto) {
        return ResponseEntity.ok(this.paymentTypeService.updateDescription(id,paymentTypeDto));
    }
}
