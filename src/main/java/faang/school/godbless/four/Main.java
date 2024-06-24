package faang.school.godbless.four;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        School school1 = new School("school1", Student.getFiveStudent());
        School school2 = new School("school2", Student.getFiveStudent());
        School school3 = new School("school3", Student.getFiveStudent());
        School school4 = new School("school4", Student.getFiveStudent());

        Task task1 = new Task("task1", 1, 10);
        Task task2 = new Task("task2", 1, 20);
        Task task3 = new Task("task3", 1, 30);
        Task task4 = new Task("task4", 1, 40);

        Tournament tournament = new Tournament(10);
        CompletableFuture<School> futureSchool1 = tournament.startTask(school1, task1);
        CompletableFuture<School> futureSchool2 = tournament.startTask(school2, task2);
        CompletableFuture<School> futureSchool3 = tournament.startTask(school3, task3);
        CompletableFuture<School> futureSchool4 = tournament.startTask(school4, task4);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(
                        futureSchool1, futureSchool2, futureSchool3, futureSchool4)
                .thenRun(() -> {
                    System.out.println(school1.getTotalPoints());
                    System.out.println(school2.getTotalPoints());
                    System.out.println(school3.getTotalPoints());
                    System.out.println(school4.getTotalPoints());
                });
    }
}
