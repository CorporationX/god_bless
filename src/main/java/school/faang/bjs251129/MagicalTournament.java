package school.faang.bjs251129;

import java.util.List;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5),
                new Student("Hermione", 5),
                new Student("Ron", 5),
                new Student("Neville", 5)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6),
                new Student("Gabrielle", 6),
                new Student("Apolline", 6),
                new Student("Olympe", 6)
        );
        List<School> schools = List.of(
                new School("Hogwarts", hogwartsTeam),
                new School("Beauxbatons", beauxbatonsTeam)
        );

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10),
                new Task("Yule Ball Preparations", 5)
        );

        tournament.allTasks(schools, tasks);
        tournament.totalPoints(schools);

    }
}
