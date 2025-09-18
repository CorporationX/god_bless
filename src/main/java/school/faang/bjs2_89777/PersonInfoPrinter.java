package school.faang.bjs2_89777;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons) {
            System.out.printf("Имя: %s. ", person.getName());
            System.out.printf("Фамилия: %s. ", person.getSurname());
            System.out.printf("Возраст: %d. ", person.getAge());
            System.out.printf("Место работы: %s.%n", person.getWorkplace());
        }
    }
}
