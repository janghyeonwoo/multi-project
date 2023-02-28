package com.common.domain;

import javax.persistence.*;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    @Id
    private Long userIdx;

    @Column(name ="user_name")
    private String userName;

    @Column(name = "id")
    private String id;

    @Column(name = "passowrd")
    private String password;

}
