package com.oysp.oysp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    @Column(length = 200, nullable = false)
    private String userName;

    @Column(length = 200, nullable = false)
    private String userCollege;

    @OneToMany
    @JoinColumn(name = "user_userid")
    public List<Subject> subjects = new ArrayList<>();
}
