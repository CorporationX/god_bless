package school.faang.sprint_4.task_51820;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<School> schools = List.of(
                Data.getHogwartsTeam(),
                Data.getBeauxbatonsTeam(),
                Data.getDurmstrangTeam(),
                Data.getIlvermornyTeam()
        );
        List<Task> tasks = Data.getTasks();
        List<CompletableFuture<School>> futureSchools = new ArrayList<>();

        Tournament tournament = new Tournament();
        for (int i = 0; i < schools.size(); i++) {
            School school = schools.get(i);
            Task task = tasks.get(i);
            CompletableFuture<School> futureSchool = tournament.startTask(school, task);
            futureSchools.add(futureSchool);
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futureSchools.toArray(new CompletableFuture[0]));
        allTasks.join();
        allTasks.thenRun(() -> {
            Map.Entry<String, Integer> winningSchool = getWinningSchool(schools);
            System.out.printf("Выиграла школа %s с общим количеством очков - %d\n",
                    winningSchool.getKey(), winningSchool.getValue());
        });
    }

    private static Map.Entry<String, Integer> getWinningSchool(List<School> schools) {
        return schools.stream()
                .collect(Collectors.toMap(School::name,
                        School::getTotalPoints))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalStateException("Школа не определена"));
    }
}
