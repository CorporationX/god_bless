package school.faang.java.thread2.threemags;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static final int RANGE = 100;
    public static final int N_S = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();

        for (int i = 0; i < N_S; i++) {
            completableFutures.add(new Tournament()
                                        .startTask(getNewSchool(), getNewTask())
                                        .thenApply(School::getTotalPoints)
            );
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).get();

        System.out.printf("\nMax score : %d",
                completableFutures.stream()
                        .map(integerCompletableFuture -> {
                            try {
                                System.out.printf("\n === Value get %d", integerCompletableFuture.get());
                                return integerCompletableFuture.get();
                            } catch (InterruptedException e) {
                                throw new IllegalArgumentException("EM001 - InterruptedException");
                            } catch (ExecutionException e) {
                                throw new IllegalArgumentException("EM002 - ExecutionException");
                            }
                        })
                        .max(Comparator.comparingInt(o -> o))
                        .orElse(Integer.MIN_VALUE)
        );
    }

    public static School getNewSchool() {
        return new School("School_Name_" + new Random().nextInt(N_S),
                getNewStudent(new Random().nextInt(N_S))
        );
    }

    public static List<Student> getNewStudent(int number) {
        ArrayList<Student> students = new ArrayList<>();
        while (number-- >= -1) {
            students.add(new Student("Student" + new Random().nextInt(RANGE),
                    new Random().nextInt(RANGE),
                    new Random().nextInt(RANGE))
            );
        }
        return students;
    }

    public static Task getNewTask() {
        return new Task("TaskName " + new Random().nextInt(RANGE),
                new Random().nextInt(RANGE),
                new Random().nextInt(RANGE)
        );
    }
}