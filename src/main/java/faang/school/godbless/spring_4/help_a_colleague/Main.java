package faang.school.godbless.spring_4.help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] name = {"Harry", "Oliver", "Jack", "Charlie", "Amelia", "Oliva", "Jessica", "Emily", "Lily"};
        String[] surName = {"Adamason", "Allsop", "Barnes", "Bates", "Dean", "Dodson", "Gill", "Griffin", "James"};
        String[] workplace = {"Actor", "Animator", "Barista", "Barmen", "Librarian"};
        int size = 10_000;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            persons.add(new Person(name[new Random().nextInt(name.length)]
                    , surName[new Random().nextInt(surName.length)]
                    , new Random().nextInt(18, 66), workplace[new Random().nextInt(workplace.length)]));
        }

        
    }
}
