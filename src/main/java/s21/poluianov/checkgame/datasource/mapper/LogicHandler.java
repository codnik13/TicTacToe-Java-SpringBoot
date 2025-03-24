package s21.poluianov.checkgame.datasource.mapper;

//@Service
public interface LogicHandler {
    boolean Win(char[][] dataset);
    boolean End(char[][] dataset);
    int Minimax(char[][] dataset);
}
