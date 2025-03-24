package s21.poluianov.checkgame.web.model;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
public class SignUpRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name="login")
    String login;
    @Column(name="password")
    String password;

    public UUID getId() {
        return id;
    }

    //public void setId(UUID id) {
    //this.id = id;
    //}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
