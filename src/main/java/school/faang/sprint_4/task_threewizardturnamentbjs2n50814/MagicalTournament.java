package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0),
                new Student("Herberd", 4, 0));
        
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0),
                new Student("Bob", 5, 0));
        
        List<School> schools = new ArrayList<>(List.of(
                new School("Hogwarts", hogwartsTeam),
                new School("Beauxbatons", beauxbatonsTeam)));

        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Triwizard Tournament", 10, 100),
                new Task("Yule Ball Preparations", 7, 70)));

        CompletableFuture<School>[] schoolCompletableFutures = new CompletableFuture[schools.size()];
        for (int i = 0; i < schools.size(); i++) {
            schoolCompletableFutures[i] = tournament.startTask(schools.get(i), tasks.get(i));
        }
        
        CompletableFuture.allOf(schoolCompletableFutures)
                .thenRun(() -> log.info("Tournament has finished !"))
                .thenRun(() -> log.info("WINNER : school '{}'",
                                Tournament.findWinner(schools).getName()))
                .join();

        log.info("Tournament statistics:");
        for(School school : schools) {
            log.info("----------- '{}' team -----------", school.getName());
            for (Student student : school.getTeam()) {
                log.info("'{}' has {} points", student.getName(), student.getPoints());
            }
        }
    }
}
