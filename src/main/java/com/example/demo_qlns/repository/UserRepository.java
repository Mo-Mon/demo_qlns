package com.example.demo_qlns.repository;


import com.example.demo_qlns.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    Page<User> findUserInfo(Pageable pageable);
}
