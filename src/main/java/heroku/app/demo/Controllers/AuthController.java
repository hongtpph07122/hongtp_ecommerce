package heroku.app.demo.Controllers;

import heroku.app.demo.DTOs.AccountDTO;
import heroku.app.demo.Entities.Account;
import heroku.app.demo.Payload.LoginRequest;
import heroku.app.demo.Payload.LoginResponse;
import heroku.app.demo.Repositories.AccountRepository;
import heroku.app.demo.Services.AccountService;
import heroku.app.demo.Spring_Security.CustomUserDetails;
import heroku.app.demo.Spring_Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository repository;
    @Autowired
    AccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
        // Xac thuc username va password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = jwtTokenProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new LoginResponse("Login success", jwt));

    }
    @GetMapping("/logup")
    public void logup(){
        Account account = new Account();
        account.setFullname("Trần Phúc Hống");
        account.setImage("Image1");
        account.setIsActive(1);
        account.setPhoneNumber("0375115451");
        account.setUsername("hongtpph07122");
        account.setPassword(passwordEncoder.encode("context"));
        repository.save(account);
    }

    @PostMapping( value = "/signup")
    public ResponseEntity<?> signupAccountClient(@RequestBody AccountDTO dto) {
        return ResponseEntity.ok(accountService.signupAccountClient(dto));
    }
    @GetMapping( value = "/random")
    @PreAuthorize("hasRole('ADMIN')")
    public LoginResponse getRandom() {
        return new LoginResponse("Dang nhap moi xem duoc tin nhan nay","");
    }
}
