package school.faang.sprint_4.bjs2_39193_triwizardTournament;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tournament triwizardTournament = new Tournament();

        List<Task> tasks = List.of(
                new Task("Yule Ball Preparations", 5, 50),
                new Task("Quidditch Match", 8, 80),
                new Task("Potions Exam", 12, 120),
                new Task("Hogwarts Feast", 6, 60),
                new Task("Gryffindor vs Slytherin Duel", 9, 90),
                new Task("Care of Magical Creatures", 11, 110),
                new Task("Wizard's Chess Tournament", 7, 70),
                new Task("Divination Exam", 13, 130),
                new Task("Hogwarts Scavenger Hunt", 4, 40)
        );

        List<Student> durmstrangTeam = List.of(
                new Student("Viktor", 7, 80),
                new Student("Krum", 7, 90),
                new Student("Igor", 7, 70));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Roger", 6, 60),
                new Student("Colette", 6, 65),
                new Student("Gabrielle", 6, 70),
                new Student("Aurélie", 6, 55),
                new Student("Léon", 6, 68));
        List<Student> hogwartsTeam = List.of(
                new Student("Ron", 5, 50),
                new Student("Ginny", 5, 58));

        List<School> schools = List.of(
                new School("Durmstang", durmstrangTeam),
                new School("Beauxbatons", beauxbatonsTeam),
                new School("Hogwarts", hogwartsTeam)
        );

        triwizardTournament.startTournament(schools, tasks);
    }
}