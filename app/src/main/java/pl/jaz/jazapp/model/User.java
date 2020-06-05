package pl.jaz.jazapp.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    private String password;
}
