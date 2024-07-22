package dev.reinaldosantos.bankingapi.domain.paymentType;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.reinaldosantos.bankingapi.exception.CustomNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentType create(PaymentTypeDto paymentTypeDto){
        PaymentType paymentType = new PaymentType();
        paymentType.setDescription(paymentTypeDto.getDescription());
        return paymentTypeRepository.save(paymentType);
    }

    public String updateDescription(String id,PaymentTypeDto paymentTypeDto){
        PaymentType findPaymentType = paymentTypeRepository.findById(UUID.fromString(id)).orElseThrow(()-> new CustomNotFoundException("Id not found "));
        findPaymentType.setDescription(paymentTypeDto.getDescription());
        try{
            paymentTypeRepository.save(findPaymentType);
            return "Salvo com sucesso";
        }catch(Exception e){
            throw new Error(e.getMessage());
        }
    }

    public List<PaymentType> getAll(){
        return paymentTypeRepository.findAll();
    }
}
