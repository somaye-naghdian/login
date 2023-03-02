package ir.dotin.registration.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;


@Entity
@Data
@Table(name = "dotin_user")
public class User {

    @Column(name = "id")
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private String email;

    @Size(min = 8)
    private String password;
}
