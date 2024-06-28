package faang.school.godbless.async.triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
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
        Student harryPotter = Student.builder()
                .name("Harry Potter")
                .year(13)
                .build();
        Student sedericDigary = Student.builder()
                .name("Sederic Digary")
                .year(16)
                .build();
        Student fleyrDelacur = Student.builder()
                .name("Fleyr Delacur")
                .year(16)
                .build();


        School hogwarts = School.builder()
                .name("Hogwarts")
                .students(List.of(sedericDigary, harryPotter))
                .build();

        School beauxbatons = School.builder()
                .name("Beauxbatons")
                .students(List.of(fleyrDelacur))
                .build();


        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, taskFirstRound);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, taskThirdRound);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                winnerMessage(hogwarts.getName(),hogwarts.getTotalPoints());
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                winnerMessage(beauxbatons.getName(),beauxbatons.getTotalPoints());
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static void winnerMessage(String name, int totalPoints){
        log.info(String.format("The winner of the magical tournament is %s with %d points.",name,totalPoints));
    }
}
