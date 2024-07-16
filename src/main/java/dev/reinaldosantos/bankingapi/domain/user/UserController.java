package dev.reinaldosantos.bankingapi.domain.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        User createdUser = userService.create(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> postMethodName(@Valid @RequestBody UserLoginDto userLoginDto) {
        Map<String, Object> response = new HashMap<>();

        String token = userService.login(userLoginDto);
        if (token == "") {
            response.put("message", "Password incorrect");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
    }
}
