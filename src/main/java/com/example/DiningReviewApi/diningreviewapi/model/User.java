package com.example.DiningReviewApi.diningreviewapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "POST_CODE")
    private String postCode;
    @Column(name = "PEANUT_ALLERGY")
    private Boolean isPeanutAllergy;
    @Column(name = "EGG_ALLERGY")
    private Boolean isEggAllergy;
    @Column(name = "DAIRY_ALLERGY")
    private Boolean isDairyAllergy;

    public User(Long id, String userName, String city, String state, String postCode) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}
