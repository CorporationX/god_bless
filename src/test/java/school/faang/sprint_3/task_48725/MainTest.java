package school.faang.sprint_3.task_48725;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testChoreExecution() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Chore chore = new Chore("подмести пол");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(chore);
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.yield();
        }

        String output = outputStream.toString();
        assertTrue(output.contains("выполняет поток: подмести пол"));
        assertTrue(output.contains("завершил поток: подмести пол"));
    }

    @Test
    void testMultipleChoresExecution() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");

        ExecutorService executor = Executors.newCachedThreadPool();

        chores.stream()
                .map(Chore::new)
                .forEach(executor::submit);

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        String output = outputStream.toString();
        chores.forEach(chore -> {
            assertTrue(output.contains("выполняет поток: " + chore));
            assertTrue(output.contains("завершил поток: " + chore));
        });
    }

    @Test
    void testThreadReuse() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");

        ExecutorService executor = Executors.newCachedThreadPool();
        chores.stream()
                .map(Chore::new)
                .forEach(executor::submit);

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        String output = outputStream.toString();
        long uniqueThreads = output.lines()
                .filter(line -> line.contains("выполняет поток:"))
                .map(line -> line.split(" ")[0])
                .distinct()
                .count();
        assertTrue(uniqueThreads <= chores.size());
    }
}