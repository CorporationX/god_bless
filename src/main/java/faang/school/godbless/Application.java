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

        faang.school.godbless.Main.weatherMain();
        faang.school.godbless.Main.studentsStart();
        faang.school.godbless.Main.startGroupingByAge();
        faang.school.godbless.Main.libraryStart();
        faang.school.godbless.Main.startGroupingByHobby();
        faang.school.godbless.googletranslator.Main.startGoogleTranslator();
        Main.mainStartHouseGame();
        Main.MetaUneverse();
        Main.Filtermessage();
        Main.startInstagramFiltres();
        Main.startEmail();


        faang.school.godbless.streamapi1.Main.streamAPI1();
        faang.school.godbless.streamapi1.Main.streamAPI2();
        faang.school.godbless.streamapi1.Main.streamAPI3();
        faang.school.godbless.streamapi1.Main.streamAPI4();
        faang.school.godbless.streamapi1.Main.streamAPI5();
        faang.school.godbless.streamapi1.Main.streamAPI6();
        faang.school.godbless.streamapi1.Main.streamAPI7();
        faang.school.godbless.streamapi1.Main.streamAPI8();
        faang.school.godbless.streamapi1.Main.streamAPI9();
    }
}