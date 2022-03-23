package com.oysp.oysp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    @Column(length = 200, nullable = false)
    private String userName;

    @Column(length = 200, nullable = false)
    private String userCollege;

//    @OneToMany(mappedBy = "user")
    @OneToMany
    @JoinColumn(name = "user_userid")
    public List<Subject> subjects = new ArrayList<Subject>();

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        System.out.println("this rep"+this);
//        if (subject.getUser() != this) {
//            subject.setUser(this);
//        }
    }
}
