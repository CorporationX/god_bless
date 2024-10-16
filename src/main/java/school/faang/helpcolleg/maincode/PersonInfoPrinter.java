package school.faang.helpcolleg.maincode;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> personList;
    public void run() {
        personList.forEach(System.out::println);
    }
}
