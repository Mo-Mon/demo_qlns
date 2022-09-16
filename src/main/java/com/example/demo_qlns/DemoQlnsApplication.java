package com.example.demo_qlns;

import com.example.demo_qlns.entity.Role;
import com.example.demo_qlns.entity.User;
import com.example.demo_qlns.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class DemoQlnsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoQlnsApplication.class, args);
    }
    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    LevelJapanRepository levelJapanRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = roleRepository.findAll();
        User user = userRepository.findByUsername("sonmnt0");
        user.setRoles(roles);
        userRepository.save(user);
//        for(int i = 0;i < 10; i++){
//            User user = new User();
//            Role role = new Role();
//            role.setName("USER");
//            user.setUsername("sonmnt" + i);
//            user.setPassword(passwordEncoder.encode("123"));
//            ArrayList<Role> list = new ArrayList<>();
//            list.add(role);
//            user.setRoles(list);
//            userRepository.save(user);
//        }
//        User user = userRepository.findByUsername("sonmnt");
//        if(user != null){
//            System.out.println("aaa"+ user.getUsername());
//            if(user.getRoles() != null)
//            System.out.println("aaa"+ user.getRoles().get(0));
//        }

    }
}
