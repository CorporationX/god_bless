package faang.school.godbless;


import faang.school.godbless.googletranslator.Main;

import faang.school.godbless.HogwartsLambdas.SpellCaster;
import static faang.school.godbless.User.groupUsers;

import java.io.IOException;


public class Application {
    public static void main(String... args) throws IOException {
        System.out.println("Hello world");

        Main.weatherMain();
        Main.studentsStart();
        Main.startGroupingByAge();
        Main.libraryStart();
        Main.startGroupingByHobby();


        Main.startGoogleTranslator();
    }
}