package com.example.demo_qlns.service.impl;

import com.example.demo_qlns.config.detail.AccountDetail;
import com.example.demo_qlns.entity.User;
import com.example.demo_qlns.repository.UserRepository;
import com.example.demo_qlns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("user không tồn tại ");
        }
        return AccountDetail.build(user);
    }
}
