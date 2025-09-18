package school.faang.bjs2_89777;

public class PersonInfoPrinter implements Runnable {
    Person person;

    @Override
    public void run() {
        System.out.printf("Имя: %s%n", person.getName());
        System.out.printf("Фамилия: %s%n", person.getSurname());
        System.out.printf("Возраст: %d%n", person.getAge());
        System.out.printf("Место работы: %s%n", person.getWorkplace());
    }
}
