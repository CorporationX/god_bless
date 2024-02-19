package faang.school.godbless;

import java.io.IOException;
import faang.school.godbless.gmail.Main;

public class Application {
    public static void main(String... args) throws IOException {
        System.out.println("Hello world");

        /*Main.weatherMain();
        Main.studentsStart();
        Main.startGroupingByAge();
        Main.libraryStart();
        Main.startGroupingByHobby();*/
        Main.startEmail();
    }
}