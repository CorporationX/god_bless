package school.faang.sprint_4.task_51820;

import java.util.List;

public class Data {

    public static School getHogwartsTeam() {
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );
        return new School("Hogwarts", hogwartsTeam);
    }

    public static School getBeauxbatonsTeam() {
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );

        return new School("Beauxbatons", beauxbatonsTeam);
    }

    public static School getDurmstrangTeam() {
        List<Student> durmstrangTeam = List.of(
                new Student("Viktor", 7, 0),
                new Student("Karkaroff", 7, 0)
        );
        return new School("Durmstrang", durmstrangTeam);
    }

    public static School getIlvermornyTeam() {
        List<Student> ilvermornyTeam = List.of(
                new Student("Isolt", 6, 0),
                new Student("James", 6, 0)
        );
        return new School("Ilvermorny", ilvermornyTeam);
    }

    public static List<Task> getTasks() {
        return List.of(
                new Task("Triwizard Tournament", Difficulty.MEDIUM, 100),
                new Task("Yule Ball Preparations", Difficulty.EASY, 50),
                new Task("Defeat the Dark Lord", Difficulty.HARD, 200),
                new Task("Find the Sorcerer's Stone", Difficulty.MEDIUM, 150)
        );
    }
}
