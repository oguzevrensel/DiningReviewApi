package com.example.DiningReviewApi.diningreviewapi.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "RESTAURANT_NAME")
    private String name;
    @Column(name = "POSTCODE")
    private String postCode;
    @Column(name = "CUISINE")
    private String cuisine;
}
