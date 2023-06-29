package faang.school.godbless.multithreading.parallelism_thread.help_colleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> nameList;

    public PersonNamePrinter(List<Person> nameList) {
        this.nameList = nameList;
    }

    @Override
    public void run() {
        nameList.forEach(employee -> System.out.println(employee.getName()));
    }
}
