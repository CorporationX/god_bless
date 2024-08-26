package faang.school.godbless.schoolTournament;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts");
        hogwarts.addStudentToSchoolTeam(new Student("Eleanor Finch", 5));
        hogwarts.addStudentToSchoolTeam(new Student("Lucas Montgomery", 3));
        hogwarts.addStudentToSchoolTeam(new Student(" Alistair Black", 6));
        hogwarts.addStudentToSchoolTeam(new Student("Emilia Blackwood", 7));
        hogwarts.addStudentToSchoolTeam(new Student("Evelyn Stone", 7));

        School beauxbatons = new School("Beauxbatons Academy of Magic");
        beauxbatons.addStudentToSchoolTeam(new Student("Pierre Delacroix", 7));
        beauxbatons.addStudentToSchoolTeam(new Student("Thibault Laurent", 2));
        beauxbatons.addStudentToSchoolTeam(new Student("Louise Dubois", 1));
        beauxbatons.addStudentToSchoolTeam(new Student("Sophie Laroque", 5));
        beauxbatons.addStudentToSchoolTeam(new Student("Victor Lemaire", 2));

        Task task1 = new Task("The Enchanted Forest Challenge", 4, 4);
        Task task2 = new Task("The Potion-Making Contest", 5, 2);
        Task task3 = new Task("The Spell-Casting Competition", 4, 1);
        Task task4 = new Task("The Dueling Chamber", 2, 3);

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task3);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task4);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask1, beauxbatonsTask1, hogwartsTask2, beauxbatonsTask2);

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
