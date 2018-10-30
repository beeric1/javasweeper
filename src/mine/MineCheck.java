package mine;

public class MineCheck {

    int vSize = 10;
    int hSize = 10;
    int [][] field ;
    int mineNr = 10;
    int mineAround;
    int vFirst;
    int hFirst;

    public void createField(int vFirst, int hFirst){
        this.vFirst = vFirst;
        this.hFirst = hFirst;
        field= new int[vSize][hSize];
        int w = 0;
        for(int i = 0; i < vSize; i++){
            for (int q = 0; q < hSize; q++){
                if(w < mineNr) {
                    field[i][q] = 9;
                    w++;
                }else {
                    field[i][q] = 0;
                }
            }
        }
        shuffleField();
        countMineAround();
    }

    public void shuffleField(){
        for(int i = 0; i < field.length; i++){
            for(int q = 0; q < field[i].length; q++){
                int i1 = (int)(Math.random()* field.length);
                int q1 = (int)(Math.random()* field[i].length);

                int temp = field[i][q];
                field[i][q] = field[i1][q1];
                field[i1][q1] = temp;

            }
        }
        printOut();
        while(field[vFirst][hFirst] == 9){
            shuffleField();
        }
    }

    public void countMineAround(){
        for(int i = 0; i< vSize; i++) {
            for (int j = 0; j < hSize; j++){
                if (field[i][j] == 0) {
                    mineAround = 0;
                    if (i-1 >= 0 && field[i-1][j] == 9){
                        mineAround++;
                    }
                    if (i+1 < vSize && field[i+1][j] == 9){
                        mineAround++;
                    }
                    if (j-1 >= 0 && field[i][j-1] == 9){
                        mineAround++;
                    }
                    if (j+1 < hSize && field[i][j+1] == 9){
                        mineAround++;
                    }
                    if (i-1 >= 0 && j-1 >= 0 && field[i-1][j-1] == 9){
                        mineAround++;
                    }
                    if (i-1 >= 0 && j+1 < hSize && field[i-1][j+1] == 9){
                        mineAround++;
                    }
                    if (i+1 < vSize && j-1 >= 0 && field[i+1][j-1] == 9){
                        mineAround++;
                    }
                    if (i+1 < vSize && j+1 < hSize && field[i+1][j+1] == 9){
                        mineAround++;
                    }
                    field[i][j] = mineAround;
                }else{
                    field[i][j] = 9;
                }
            }
        }
    }

    public void printOut(){
        for(int i = 0; i < vSize; i++){
            for(int q = 0; q < hSize; q++){
                //   System.out.print(field[i][q]);
                System.out.print(field[i][q]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

}
