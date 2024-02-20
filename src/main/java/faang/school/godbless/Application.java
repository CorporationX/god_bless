package faang.school.godbless;


import faang.school.godbless.HogwartsLambdas.SpellCaster;
import faang.school.godbless.instagramfilters.Main;
import faang.school.godbless.googletranslator.Main;
import faang.school.godbless.filterspam.Main;
import faang.school.godbless.gmail.Main;
import static faang.school.godbless.User.groupUsers;
import java.io.IOException;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");

        Main.weatherMain();
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
    }
}