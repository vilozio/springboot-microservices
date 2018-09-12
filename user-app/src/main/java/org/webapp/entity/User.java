package org.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Data
//@ToString(exclude = "password")
//@NoArgsConstructor
//@Table(name = "User")
public class User {

//    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NonNull
    private String username;
//    @NonNull
//    @JsonIgnore
    private String password;

//    public void setPassword(String password) {
//        this.password = PASSWORD_ENCODER.encode(password);
//    }
//
//    private User() {}
//
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
}
