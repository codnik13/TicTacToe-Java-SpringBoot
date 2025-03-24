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
public class SoloGameControl {
    @Autowired
    GameRepository gameRepository;

    @PostMapping(value = "/solo")
    public char[][] solo(@RequestBody String str) {
        String[] strings=str.split("&");
        String field=(strings[0].split("="))[1];
        UUID id=UUID.fromString((strings[1].split("="))[1]);
        Game game=gameRepository.findById(id).get();
        char[][] dataset={{'\0','\0','\0'}, {'\0','\0','\0'}, {'\0','\0','\0'}};
        /*for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(game.getFields()[i*3+j]!='\0')
                    dataset[i][j]=game.getFields()[i*3+j];*/
        if(game.getField_0()!='\0') dataset[0][0]=(char)game.getField_0();
        if(game.getField_1()!='\0') dataset[0][1]=(char)game.getField_1();
        if(game.getField_2()!='\0') dataset[0][2]=(char)game.getField_2();
        if(game.getField_3()!='\0') dataset[1][0]=(char)game.getField_3();
        if(game.getField_4()!='\0') dataset[1][1]=(char)game.getField_4();
        if(game.getField_5()!='\0') dataset[1][2]=(char)game.getField_5();
        if(game.getField_6()!='\0') dataset[2][0]=(char)game.getField_6();
        if(game.getField_7()!='\0') dataset[2][1]=(char)game.getField_7();
        if(game.getField_8()!='\0') dataset[2][2]=(char)game.getField_8();
        /*int num=Integer.parseInt(field);
        if(game.getFields()[num]=='\0') {
            game.getFields()[num] = dataset[num/3][num%3] = 'X';
        }*/
        if(field.equals("0") && game.getField_0()=='\0') {
            game.setField_0('X');
            dataset[0][0]='X';
        }
        else if(field.equals("1") && game.getField_1()=='\0') {
            game.setField_1('X');
            dataset[0][1]='X';
        }
        else if(field.equals("2") && game.getField_2()=='\0') {
            game.setField_2('X');
            dataset[0][2]='X';
        }
        else if(field.equals("3") && game.getField_3()=='\0') {
            game.setField_3('X');
            dataset[1][0]='X';
        }
        else if(field.equals("4") && game.getField_4()=='\0') {
            game.setField_4('X');
            dataset[1][1]='X';
        }
        else if(field.equals("5") && game.getField_5()=='\0') {
            game.setField_5('X');
            dataset[1][2]='X';
        }
        else if(field.equals("6") && game.getField_6()=='\0') {
            game.setField_6('X');
            dataset[2][0]='X';
        }
        else if(field.equals("7") && game.getField_7()=='\0') {
            game.setField_7('X');
            dataset[2][1]='X';
        }
        else if(field.equals("8") && game.getField_8()=='\0') {
            game.setField_8('X');
            dataset[2][2]='X';
        }
        else return dataset;
        Logic logic=new Logic();
        if(logic.Win(dataset) || logic.End(dataset)) {
            System.out.println(gameRepository.findById(id).get().getId());
            gameRepository.deleteById(id);
            return dataset;
        }
            int area = logic.Minimax(dataset);
            //game.getFields()[area]= dataset[area/3][area%3] = '0';
            if (area == 0) {
                game.setField_0('0');
                dataset[0][0] = '0';
            } else if (area == 1) {
                game.setField_1('0');
                dataset[0][1] = '0';
            } else if (area == 2) {
                game.setField_2('0');
                dataset[0][2] = '0';
            } else if (area == 3) {
                game.setField_3('0');
                dataset[1][0] = '0';
            } else if (area == 4) {
                game.setField_4('0');
                dataset[1][1] = '0';
            } else if (area == 5) {
                game.setField_5('0');
                dataset[1][2] = '0';
            } else if (area == 6) {
                game.setField_6('0');
                dataset[2][0] = '0';
            } else if (area == 7) {
                game.setField_7('0');
                dataset[2][1] = '0';
            } else if (area == 8) {
                game.setField_8('0');
                dataset[2][2] = '0';
            }
        if(logic.Win(dataset) || logic.End(dataset)) {
            System.out.println(gameRepository.findById(id).get().getId());
            gameRepository.deleteById(id);
        }
        else gameRepository.save(game);
        return dataset;
    }
    @PostMapping("/del")
    public void delete(@RequestBody String str) {
        UUID id=UUID.fromString((str.split("="))[1]);
        System.out.println(gameRepository.findById(id).get().getId());
        gameRepository.deleteById(id);
    }
}
