package s21.poluianov.checkgame.web.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s21.poluianov.checkgame.datasource.mapper.Logic;
import s21.poluianov.checkgame.datasource.repository.GameRepository;
import s21.poluianov.checkgame.web.model.Game;
import java.util.UUID;

@Slf4j
@RestController
public class DuelGameControl {
    @Autowired
    GameRepository gameRepository;

    @PostMapping("/duel")
    public char[][] duel(@RequestBody String str) {
        String[] strings=str.split("&");
        String field=(strings[0].split("="))[1];
        UUID id=UUID.fromString((strings[1].split("="))[1]);
        String who=(strings[2].split("="))[1];
        Game game=null;
        char[][] dataset={{'\0','\0','\0'}, {'\0','\0','\0'}, {'\0','\0','\0'}, {'\0','\0','\0'}};
        if(gameRepository.findById(id).isEmpty()){
            dataset[3][2]='1';
            return dataset;
        }
        game=gameRepository.findById(id).get();
        if(game.getField_0()!='\0') dataset[0][0]=(char)game.getField_0();
        if(game.getField_1()!='\0') dataset[0][1]=(char)game.getField_1();
        if(game.getField_2()!='\0') dataset[0][2]=(char)game.getField_2();
        if(game.getField_3()!='\0') dataset[1][0]=(char)game.getField_3();
        if(game.getField_4()!='\0') dataset[1][1]=(char)game.getField_4();
        if(game.getField_5()!='\0') dataset[1][2]=(char)game.getField_5();
        if(game.getField_6()!='\0') dataset[2][0]=(char)game.getField_6();
        if(game.getField_7()!='\0') dataset[2][1]=(char)game.getField_7();
        if(game.getField_8()!='\0') dataset[2][2]=(char)game.getField_8();
        if(game.getTurn()<0)
            dataset[3][2]='0';
        if(field.equals("9")){
            dataset[3][1]='1';
            if(game.getDelete()==-1)
                dataset[3][0]='9';
            game.setCanceled();
            gameRepository.save(game);
            return dataset;
        }
        if(game.isCanceled()){
            return dataset;
        }
        if(game.getDelete()>0){
            if(game.getDelete()==1) {
                game.setDelete(2);
                dataset[3][0] = '2';
            }
            else if(game.getDelete()==3) {
                game.setDelete(4);
                dataset[3][0] = '4';
            }
            gameRepository.save(game);
            return dataset;
        }
        if(field.equals("0") && game.getField_0()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_0('X');
                dataset[0][0] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_0('0');
                dataset[0][0] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("1") && game.getField_1()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_1('X');
                dataset[0][1] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_1('0');
                dataset[0][1] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("2") && game.getField_2()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_2('X');
                dataset[0][2] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_2('0');
                dataset[0][2] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("3") && game.getField_3()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_3('X');
                dataset[1][0] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_3('0');
                dataset[1][0] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("4") && game.getField_4()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_4('X');
                dataset[1][1] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_4('0');
                dataset[1][1] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("5") && game.getField_5()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_5('X');
                dataset[1][2] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_5('0');
                dataset[1][2] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("6") && game.getField_6()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_6('X');
                dataset[2][0] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_6('0');
                dataset[2][0] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("7") && game.getField_7()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_7('X');
                dataset[2][1] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_7('0');
                dataset[2][1] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        else if(field.equals("8") && game.getField_8()=='\0') {
            if(who.equals("creator") && (game.getStatus()==0 || game.getStatus()==1)) {
                game.setField_8('X');
                dataset[2][2] = 'X';
                game.setStatus(2);
                gameRepository.save(game);
            }
            else if(who.equals("rival") && (game.getStatus()==0 || game.getStatus()==2)) {
                game.setField_8('0');
                dataset[2][2] = '0';
                game.setStatus(1);
                gameRepository.save(game);
            }
        }
        Logic logic = new Logic();
        if(logic.Win(dataset)){
            dataset[3][0]='1';
            game.setDelete(1);
            gameRepository.save(game);
        }
        else if(logic.End(dataset)){
            dataset[3][0]='3';
            game.setDelete(3);
            gameRepository.save(game);
        }
        return dataset;
    }
    @PostMapping("/retrieve")
    public char[][] retrieve(@RequestBody String str) {
        System.out.println(str+"-------------------------------");
        String[] strings=str.split("&");
        UUID id=UUID.fromString((strings[0].split("="))[1]);
        Game game=null;
        char[][] dataset={{'\0','\0','\0'}, {'\0','\0','\0'}, {'\0','\0','\0'}, {'\0','\0','\0'}};
        if(gameRepository.findById(id).isEmpty()){
            dataset[3][2]='1';
            return dataset;
        }
        game=gameRepository.findById(id).get();
        if(game.getField_0()!='\0') dataset[0][0]=(char)game.getField_0();
        if(game.getField_1()!='\0') dataset[0][1]=(char)game.getField_1();
        if(game.getField_2()!='\0') dataset[0][2]=(char)game.getField_2();
        if(game.getField_3()!='\0') dataset[1][0]=(char)game.getField_3();
        if(game.getField_4()!='\0') dataset[1][1]=(char)game.getField_4();
        if(game.getField_5()!='\0') dataset[1][2]=(char)game.getField_5();
        if(game.getField_6()!='\0') dataset[2][0]=(char)game.getField_6();
        if(game.getField_7()!='\0') dataset[2][1]=(char)game.getField_7();
        if(game.getField_8()!='\0') dataset[2][2]=(char)game.getField_8();
        if(game.getTurn()<0)
            dataset[3][2]='0';
        if(game.isCanceled()){
            dataset[3][0]='0';
            dataset[3][1]='1';
        }
        else if(game.getDelete()>0){
            if(game.getDelete()==1) {
                game.setDelete(2);
                dataset[3][0] = '2';
            }
            else if(game.getDelete()==3) {
                game.setDelete(4);
                dataset[3][0] = '4';
            }
            gameRepository.save(game);
        }
        return dataset;
    }
    @PostMapping("/dlt")
    public void dlt(@RequestBody String str) {
        UUID id=UUID.fromString((str.split("="))[1]);
        System.out.println(gameRepository.findById(id).get().getId());
        gameRepository.deleteById(id);
    }
}
