package com.example.demo_qlns.api;

import com.example.demo_qlns.common.request.LoginRequest;
import com.example.demo_qlns.config.detail.AccountDetail;
import com.example.demo_qlns.config.sercurity.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((AccountDetail) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }
    @GetMapping("/user/v1")
    public String randomStuff(){
        return "JWT Hợp lệ mới có thể thấy được message này";
    }
    @GetMapping("/admin/v1")
    public String randomStuff2(){
        return "JWT Hợp lệ mới có thể thấy được message này 2";
    }
}
