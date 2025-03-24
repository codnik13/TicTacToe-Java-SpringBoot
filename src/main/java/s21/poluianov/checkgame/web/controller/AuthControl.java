package s21.poluianov.checkgame.web.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import s21.poluianov.checkgame.datasource.repository.UserRepository;
import s21.poluianov.checkgame.web.model.SignUpRequest;
import s21.poluianov.checkgame.web.model.Users;

import java.util.List;

//@Slf4j
@RestController
public class AuthControl {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("auth.html");
    }
    @PostMapping("/auth")
    public String auth(@RequestBody String str) {
        String[] strings=str.split("&");
        String select=(strings[0].split("="))[1];
        String login=(strings[1].split("="))[1];
        String pwd=(strings[2].split("="))[1];
        List<Users> users=userRepository.findAll();
        if(select.equals("1")) {
            for (int i = 0; i < users.size(); i++)
                if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(pwd))
                    return users.get(i).getId().toString();
            return "fail";
        }
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getLogin().equals(login))
                return "fail";
        Users user=userRepository.save(new Users());
        user.setLogin(login);
        user.setPassword(pwd);
        userRepository.save(user);
        return "success";
    }
    /*@PostMapping("/save")
    public String signup(String str) {
        String[] strings=str.split("&");
        String login=(strings[0].split("="))[1];
        String pwd=(strings[1].split("="))[1];
        List<Users> users=userRepository.findAll();
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getLogin().equals(login))
                return "fail";
        Users user=userRepository.save(new Users());
        user.setLogin(login);
        user.setPassword(pwd);
        userRepository.save(user);
        return "success";
    }*/
}
