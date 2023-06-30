package faang.school.godbless.multithreadingS4.normalGame;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<PigThread> pigs = List.of(
                new Pig1Thread(),
                new Pig2Thread(),
                new Pig3Thread()
        );


        pigs.forEach(Thread::start);

        pigs.forEach(thread -> {
            try {
                thread.join();
            } catch (Exception e){
                System.out.printf("%s has been interrupted", thread.getName());
            }
        });

        System.out.println("\n\tEveryone has finished the construction");
    }
}
