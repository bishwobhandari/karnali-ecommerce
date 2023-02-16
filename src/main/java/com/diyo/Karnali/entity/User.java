package com.diyo.Karnali.entity;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="user_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    private String lastName;
    @NotNull(message = "phone number cannot be null")
    private int phone;

    private String address;


}
