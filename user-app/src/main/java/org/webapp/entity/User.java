package org.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "password")
@Table(name = "User")
public class User {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @NonNull
    @JsonIgnore
    private String password;

    @SuppressWarnings("WeakerAccess")
    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    protected User() {}

    public User(String username, String password) {
        this.username = username;
        this.setPassword(password);
    }
}
