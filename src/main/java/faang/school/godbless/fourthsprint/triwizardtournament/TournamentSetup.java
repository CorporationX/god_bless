package faang.school.godbless.fourthsprint.triwizardtournament;

import java.util.Arrays;
import java.util.List;

public class TournamentSetup {

    public static List<Student> createHogwartsTeam() {
        return Arrays.asList(
                new Student("Harry Potter", 5),
                new Student("Ron Weasley", 5),
                new Student("Hermione Granger", 5)
        );
    }

    public static List<Student> createBeauxbatonsTeam() {
        return Arrays.asList(
                new Student("Fleur Delacour", 5),
                new Student("Gabrielle Delacour", 4),
                new Student("Apolline Delacour", 5)
        );
    }

    public static List<Student> createDurmstrangTeam() {
        return Arrays.asList(
                new Student("Viktor Krum", 6),
                new Student("Igor Karkaroff", 7),
                new Student("Gregorovitch", 6)
        );
    }

    public static School createSchool(String name, List<Student> team) {
        return new School(name, team);
    }
}
