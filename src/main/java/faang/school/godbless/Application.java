package faang.school.godbless;



import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final List<Integer> numberList = List.of(1,2,3,4,5);
    public static void main(String... args) {
        System.out.println("Hello world");

        /*Main.weatherMain();
        Main.studentsStart();
        Main.startGroupingByAge();
        Main.libraryStart();
        Main.startGroupingByHobby();
        Main.mainStartHouseGame();
        Main.MetaUneverse();
        Main.Filtermessage();
        Main.startInstagramFiltres();
        Main.startGoogleTranslator();
        Main.startEmail();
        faang.school.godbless.streamapi2.Main.*/

        faang.school.godbless.calculator.Main.product(numberList);
        faang.school.godbless.calculator.Main.sum(numberList);
    }
}