package ir.dotin.registration.entity;


import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name = "normal-user")
public class User {

    @Column(name = "id")
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Size
    private String email;

    @Size(min = 8)
    private String password;
}
