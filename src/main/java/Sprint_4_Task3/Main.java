package Sprint_4_Task3;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int personCount = 10000;
        for (int i = 0; i < personCount; i++) {
            personList.add(new Person("name =" + i, "surname =" + i, i, "workplace ="+ i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new PersonNamePrinter(personList.subList(i*personCount/10, (i+1)*personCount/10)));
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
