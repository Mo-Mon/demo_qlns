package com.example.demo_qlns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "leader_id")
    private User leader;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Collection<User> users;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
