package com.directory.main.modal;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @GenericGenerator(
            name = "usersSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "usersSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @Column(name="userid")
    @GeneratedValue(generator = "usersSequenceGenerator")
    private Long Id;

    private String username;

    private String email;

    private String password;

    public User(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

}
