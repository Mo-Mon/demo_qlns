package com.example.demo_qlns.repository;

import com.example.demo_qlns.entity.LevelJapan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelJapanRepository extends JpaRepository<LevelJapan,Long> {
}
