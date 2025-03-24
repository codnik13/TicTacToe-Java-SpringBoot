package s21.poluianov.checkgame.datasource.repository;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s21.poluianov.checkgame.web.model.SignUpRequest;
import s21.poluianov.checkgame.web.model.SignUpRequest;
import s21.poluianov.checkgame.web.model.Users;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
}