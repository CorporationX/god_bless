package faang.school.godbless.async.triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School beauxbatons = getBeauxbatons();
        School hogwarts = getHogwarts();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, getRandomTask(getAllTask()));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, getRandomTask(getAllTask()));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                winnerMessage(hogwarts.getName(), hogwarts.getTotalPoints());
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                winnerMessage(beauxbatons.getName(), beauxbatons.getTotalPoints());
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static void winnerMessage(String name, int totalPoints) {
        log.info(String.format("The winner of the magical tournament is %s with %d points.", name, totalPoints));
    }

    private static School getHogwarts() {
        Student harryPotter = Student.builder()
                .name("Harry Potter")
                .year(13)
                .build();
        Student sedericDigary = Student.builder()
                .name("Sederic Digary")
                .year(16)
                .build();

        return School.builder()
                .name("Hogwarts")
                .students(List.of(sedericDigary, harryPotter))
                .build();
    }

    private static School getBeauxbatons() {
        Student fleyrDelacur = Student.builder()
                .name("Fleyr Delacur")
                .year(16)
                .build();
        Student leaDelacur = Student.builder()
                .name("Lea Delacur")
                .year(17)
                .build();

        return School.builder()
                .name("Beauxbatons")
                .students(List.of(fleyrDelacur,leaDelacur))
                .build();
    }

    private static List<Task> getAllTask(){
        Task taskFirstRound = Task
                .builder()
                .name("Battle with dragon")
                .difficulty(15)
                .reward(150)
                .build();

        Task taskSecondRound = Task.builder()
                .name("Saving yours friends")
                .difficulty(12)
                .reward(130)
                .build();

        Task taskThirdRound = Task.builder()
                .name("Impenetrable labyrinth")
                .difficulty(18)
                .reward(210)
                .build();

        return List.of(taskFirstRound, taskSecondRound, taskThirdRound);
    }

    private static Task getRandomTask(List<Task> tasks){
        Random random = new Random();
        return tasks.get(random.nextInt(tasks.size()));
    }
}
