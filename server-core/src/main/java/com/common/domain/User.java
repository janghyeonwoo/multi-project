package com.common.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "user2")
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

}
