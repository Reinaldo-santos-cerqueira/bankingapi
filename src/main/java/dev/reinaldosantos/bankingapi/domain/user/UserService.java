package dev.reinaldosantos.bankingapi.domain.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.reinaldosantos.bankingapi.exception.CustomNotFoundException;
import dev.reinaldosantos.bankingapi.security.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository; 
    private final BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public User create(UserDTO userDTO){
        User userModel = new User();
        userModel.setActive(true);
        userModel.setEmail(userDTO.getEmail());
        userModel.setName(userDTO.getName());
        userModel.setRole(userDTO.getRole());
        userModel.setPassword(encrypt.encode(userDTO.getPassword()));
        return this.userRepository.save(userModel);
    }

    public String login(UserLoginDto userLoginDto){
        User findUser = this.userRepository.findByEmail(userLoginDto.getEmail()).orElseThrow(()-> new CustomNotFoundException("Email not found "));
        if (passwordEncoder.matches(userLoginDto.getPassword(), findUser.getPassword())) {
            return this.tokenService.generateToken(findUser);
        } else {
            return "";
        }
    }
}
