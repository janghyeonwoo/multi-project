package com.common.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Table(name = "user")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    @Id
    private Long userIdx;

    @Column(name ="user_name")
    private String userName;

    @Column(name = "id")
    private String userId;

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns=@JoinColumn(name = "user_role_idx", referencedColumnName = "user_idx"))
    private Set<String> roles = new HashSet<>();

}
