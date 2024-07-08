package dev.reinaldosantos.bankingapi.domain.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository; 
    private final BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDTO userDTO){
        User userModel = new User();
        userModel.setActive(true);
        userModel.setEmail(userDTO.getEmail());
        userModel.setName(userDTO.getName());
        userModel.setPassword(encrypt.encode(userDTO.getPassword()));
        return userRepository.save(userModel);
    }
}
