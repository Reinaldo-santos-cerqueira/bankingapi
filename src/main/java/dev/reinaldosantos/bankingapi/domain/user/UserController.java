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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController()
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody UserLoginDto userLoginDto) {
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
    
    @PutMapping("/tradePassword/{id}")
    public ResponseEntity<Map<String, Object>> changePassword(@PathVariable String id, @Valid @RequestBody UserLoginDto userLoginDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", this.userService.updatePassword(id,userLoginDto));

        return ResponseEntity.ok(response);
    }
}
