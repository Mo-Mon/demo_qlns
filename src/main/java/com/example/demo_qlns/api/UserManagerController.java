package com.example.demo_qlns.api;

import com.example.demo_qlns.entity.User;
import com.example.demo_qlns.repository.RoleRepository;
import com.example.demo_qlns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserManagerController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/v2")
    public ResponseEntity<?> getPage(@RequestParam("index") Integer index){
        if( index < 0 ){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("page không tồn tại");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findUserInfo(PageRequest.of(index, 4, Sort.by("username").descending())));
    }
}
