package s21.poluianov.checkgame.datasource.mapper;

//@Component
public class Logic implements LogicHandler {

    @Override
    public boolean Win(char[][] dataset){
        for(int i=0, j=0; i<3; i++){
            for(j=0; j<3 && dataset[i][j]=='0'; j++);
            if(j==3) return true;
            for(j=0; j<3 && dataset[i][j]=='X'; j++);
            if(j==3) return true;
        }
        for(int i=0, j=0; i<3; i++){
            for(j=0; j<3 && dataset[j][i]=='0'; j++);
            if(j==3) return true;
            for(j=0; j<3 && dataset[j][i]=='X'; j++);
            if(j==3) return true;
        }
        int i=0;
        for(; i<3 && dataset[i][i]=='0'; i++);
        if(i==3) return true;
        for(i=0; i<3 && dataset[i][i]=='X'; i++);
        if(i==3) return true;
        for(i=0; i<3 && dataset[i][3-1-i]=='0'; i++);
        if(i==3) return true;
        for(i=0; i<3 && dataset[i][3-1-i]=='X'; i++);
        if(i==3) return true;
        return false;
    }
    @Override
    public boolean End(char[][] dataset) {
        int x=0,y=0;
        for(;y<3;y++) {
            for (x = 0; x < 3 && dataset[y][x] != '\0'; x++) ;
            if(x<3) break;
        }
        if(y==3) return true;
        return false;
    }
    @Override
    public int Minimax(char[][] dataset) {
        int count, x=0,y=0, i,j, reference=3;
        while(--reference>=0) {
            for (i=count=0; i < 3; count = 0, i++) {
                for (j = 0; j < 3 && dataset[i][j] != '0'; j++) {
                    if (dataset[i][j] == 'X')
                        count += 1;
                    else x = j;
                }
                if (j == 3 && count == reference){
                    dataset[i][x]='0';
                    return i*3+x;
                }
            }
            for (i = count = 0; i < 3; count = 0, i++) {
                for (j = 0; j < 3 && dataset[j][i] != '0'; j++) {
                    if (dataset[j][i] == 'X')
                        count += 1;
                    else y = j;
                }
                if (j == 3 && count == reference){
                    dataset[y][i]='0';
                    return y*3+i;
                }
            }
            for (i = count = 0; i < 3 && dataset[i][i] != '0'; i++) {
                if (dataset[i][i] == 'X')
                    count += 1;
                else x=i;
            }
            if (i == 3 && count == reference){
                dataset[x][x]='0';
                return x*3+x;
            }
            for (i = count = 0; i < 3 && dataset[i][3 - 1 - i] != '0'; i++) {
                if (dataset[i][3 - 1 - i] == 'X')
                    count += 1;
                else x=i;
            }
            if (i == 3 && count == reference){
                dataset[x][3-1-x]='0';
                return x*3+3-1-x;
            }
        }
        do {
            y = (int) (Math.random() * 3);
            x = (int) (Math.random() * 3);
        }while(dataset[y][x]!='\0');
        dataset[y][x]='0';
        return y*3+x;
    }
}