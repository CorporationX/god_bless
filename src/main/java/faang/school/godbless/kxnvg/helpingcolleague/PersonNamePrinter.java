package faang.school.godbless.kxnvg.helpingcolleague;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class PersonNamePrinter implements Runnable {

    private List<Person> personList = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName());
        }
    }
}
