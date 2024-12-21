package school.faang.spring3.task_48071;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private List<Person> partList;

    public PersonInfoPrinter(List<Person> partList) {
        this.partList = partList;
    }

    @Override
    public void run() {
        partList.forEach(x -> System.out.println(Thread.currentThread().getName() + " " + x));
    }
}
