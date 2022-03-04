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

    @Column(length = 100, nullable = true)
    private Integer credit;
}
