package com.oysp.oysp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Long subjectCode;

    @Column(length = 200, nullable = false)
    private String subjectName;

    @Column(length = 100, nullable = false)
    private Integer credit;

//    @ManyToOne
//    @JoinColumn(name = "USER_USERID")
//    private User user;
//
//    public void setUser(User user) {
//        if (this.user != null) {
//            this.user.getSubjects().remove(this);
//        }
//        this.user = user;
//        user.getSubjects().add(this);
//    }


}
