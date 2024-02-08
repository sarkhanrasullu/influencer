package common;

import java.util.Scanner;

public interface RunnableAsMenu {

    default void showMenu() {
        System.out.println("Hansi emeliyyati etmek isteyirsiniz?");
        System.out.println(
                        "0. ilk defe yaratmaq \n " +
                        "1. yenisini yaratmaq \n " +
                        "2. yenilemek(update) \n " +
                        "3. silmek \n " +
                        "4. axtarmaq \n " +
                        "5. hamisini gormek");
        int action = new Scanner(System.in).nextInt();
        if(action == 0) {
            initialize();
        }else if(action == 1) {
            initializeNew();
        } else if(action == 2) {
            update();
        } else if(action == 3) {
            delete();
        }else if(action == 5) {
            printAll();
        }else if(action == 4) {
            find();
        }
    }

     void initialize();

     void initializeNew();

     void update();

     void delete();

     void printAll();

     void find();

}
