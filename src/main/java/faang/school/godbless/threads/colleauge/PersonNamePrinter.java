package faang.school.godbless.threads.colleauge;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private int startIndex;
    private int endIndex;
    private List<Person> personList;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(personList.get(i).getName());
        }
    }
}
