package faang.school.godbless.Sprint4.HelpToColleague;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new LinkedList<>();
        ExecutorService executors = Executors.newFixedThreadPool(4);

        for (int i=0;i<10000;i++){
            persons.add(new Person("Name "+i,"Surname "+i,i,"any work place "));
        }

        //нигде не нашел информацию о том, что мы можем выбрать конкретный поток,
        //который буде выполнять, поэтому при разделение списка на группы нет никакого смысла
        //т.к. все задачи идут все равно в один пул
        for (int i=0;i<persons.size();i++){
            executors.submit(new PersonNamePrinter(persons.get(i)));
        }
        executors.shutdown();
        executors.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("END");
    }
}
