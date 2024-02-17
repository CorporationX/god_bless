package faang.school.godbless;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String... args) throws IOException {
        System.out.println("Hello world");

        Main.weatherMain();
        Main.studentsStart();
        Main.startGroupingByAge();
        Main.libraryStart();
        Main.startGroupingByHobby();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] reversNum = Example.reverse(numbers);
        for (int j : reversNum) {
            System.out.print(j);
            Main.mainStartBook();
        }

        }

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}

