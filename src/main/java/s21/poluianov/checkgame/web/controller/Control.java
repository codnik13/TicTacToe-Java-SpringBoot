package s21.poluianov.checkgame.web.controller;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import s21.poluianov.checkgame.datasource.mapper.Logic;
import s21.poluianov.checkgame.datasource.repository.GameRepository;
import s21.poluianov.checkgame.web.model.Game;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class Control {
    @Autowired
    GameRepository gameRepository;

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home.html");
    }
    @PostMapping("/home")
    public String[] startGame(@RequestBody String str) {
        String[] dataset=new String[2];
        String select=(str.split("="))[1];
        Game game=null;
        if(select.equals("1")) {
            game = gameRepository.save(new Game());
            game.setStatus(-1000);
            gameRepository.save(game);
            dataset[0]="";
        }
        else{
            List<Game> games=gameRepository.findAll();
            for(int i=0;i<games.size();i++) {
                if(games.get(i).getDelete()==-1) {
                    game=games.get(i);
                    game.setDelete(0);
                    game.setTurn(0);
                    gameRepository.save(game);
                    dataset[0]="rival";
                    break;
                }
            }
            if(game==null) {
                dataset[0]="creator";
                game = gameRepository.save(new Game());
            }
        }
         dataset[1]=game.getId().toString();
        return dataset;
    }
}
