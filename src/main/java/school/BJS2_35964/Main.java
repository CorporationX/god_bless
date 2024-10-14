package school.BJS2_35964;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static String[] workerName = {"Рома", "Денис", "Евгений", "Иван", "Юрий", "Александр"};
    private static String[] workerSurname = {"Петров", "Сидоров", "Алекснадров", "Демьянинков", "Аненков", "Попов", "Бессонов"};
    private static String[] workPlace = {"Sber", "T-bank", "Alpha-bank", "Gas-prom bank"};
    private static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        final int THREAD_SIZE = 5;

        initialize();

        int sizeOfListForEveryThreads = Math.round(persons.size() / THREAD_SIZE);

        ExecutorService executors = Executors.newFixedThreadPool(THREAD_SIZE);

        //проверяет условие: если лист не 1000, а нечетное число и нужно охватывать весь список
        for (int i = 0; i < THREAD_SIZE; i++) {
            List<Person> listForExecutors = new ArrayList<>();
            for (int j = 0; j < sizeOfListForEveryThreads; j++) {
                if (i != THREAD_SIZE - 1) {
                    listForExecutors.add(persons.get(j + (i * sizeOfListForEveryThreads)));
                } else {
                    for (int k = i * sizeOfListForEveryThreads; k < persons.size(); k++) {
                        listForExecutors.add(persons.get(k));
                    }
                }
            }
            executors.execute(new PersonInfoPrinter(listForExecutors));
        }
        executors.shutdown();

        executors.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Все потоки завершили работу");
    }

    private static void initialize() {
        Random random = new Random();
        for (int i = 0; i < 938; i++) {
            String name = workerName[random.nextInt(workerName.length)];
            String surname = workerSurname[random.nextInt(workerSurname.length)];
            String job = workPlace[random.nextInt(workPlace.length)];
            int age = random.nextInt(40) + 18;
            Person person = new Person(name, surname, age, job);
            persons.add(person);
        }
    }
}
