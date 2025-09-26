package school.faang.future_completable_future.bjs2_2906;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static school.faang.future_completable_future.bjs2_2906.Tournament.stopTasksProcessingAndAwaitTermination;
import static school.utils.Utils.pickRandom;
import static school.utils.Utils.waitForAllAsyncTasksAndGet;

@Slf4j
public class MagicalTournament {
    private static final Tournament tournament = new Tournament();

    public static void main(String[] args) {

        List<Task> tasks = SampleData.tasks();
        List<School> schools = SampleData.schools();
        boolean isSchools = true;

        while (isSchools) {
            List<School> competingSchools = startTournament(schools, tasks);

            List<School> schoolsCompetingForOnePlace = competingSchools.stream()
                    .filter(school -> school.getTotalPoints() == competingSchools.get(0).getTotalPoints())
                    .toList();

            isSchools = isSchoolsCompetingForOnePlace(schoolsCompetingForOnePlace);
            if (isSchools) {
                schools = schoolsCompetingForOnePlace;
                log.info("На первое место претендуют школы набравшие {} очков:",
                        competingSchools.get(0).getTotalPoints());

                String listOfSchools = String.join(", ",
                        schoolsCompetingForOnePlace.stream()
                                .map(School::getName)
                                .toList());

                log.info("{}", listOfSchools);
                log.info("Дадим им дополнительные задачи");

            } else {
                log.info("Победила команда школы {}, набравшая больше всего очков {}",
                        competingSchools.get(0).getName(),
                        competingSchools.get(0).getTotalPoints());
            }

            log.info("ОСТАЛЬНЫЕ ВЫБЫВАЮЩИЕ УЧАСТНИКИ");
            competingSchools.subList(schoolsCompetingForOnePlace.size(), competingSchools.size())
                    .forEach(school -> log.info("Школа - {}, количество набранных очков {}",
                            school.getName(), school.getTotalPoints()));
        }

        stopTasksProcessingAndAwaitTermination();
    }

    private static List<School> startTournament(@NonNull List<School> schools, @NonNull List<Task> tasks) {
        List<CompletableFuture<School>> tasksFuture = schools.stream()
                .map(school -> tournament.startTask(school, pickRandom(tasks)))
                .toList();

        return waitForAllAsyncTasksAndGet(tasksFuture)
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(Comparator.comparing(School::getTotalPoints).reversed())
                .toList();
    }

    private static boolean isSchoolsCompetingForOnePlace(@NonNull List<School> competingSchools) {

        if (competingSchools.isEmpty()) {
            throw new RuntimeException("Список не должен быть пустым");
        }
        return competingSchools.size() != 1;
    }
}