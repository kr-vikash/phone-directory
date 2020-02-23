package com.directory.main.modal;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "phone")
@Setter
@Getter
public class Contact {
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
    @GeneratedValue(generator = "usersSequenceGenerator")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "fname", nullable = false)
    private String firstName;

    @Column(name = "mname")
    private  String middleName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "phoneNo",length = 10, nullable =false)
    private String phoneNumber;

    @Column(name = "ctype")
    private String contactType;

}
