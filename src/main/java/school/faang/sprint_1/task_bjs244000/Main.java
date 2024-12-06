package school.faang.sprint_1.task_bjs244000;

import java.util.List;
import java.util.Set;

public class Main {
    private static final String DELIMITER_FOR_STRINGS = "\\n";
    private static final String DELIMITER_FOR_VALUES = ",";

    public static void main(String[] args) {
        String testUserData = """
                id,name,age,hobbies
                1,Jack,18,poker,java,sql
                2,John,24,cars,spring,weapons
                3,Vika,43,swimming,bike,hiking
                4,Ashley,23,TV,C,java
                5,Bob,75,disco,fortran,music,horses,boats
                6,Daniel,14,horses
                7,Jane,14
                """;

        String testHobbiesData = """
                string of hobbies
                cars,dance,reading
                java,bike,music
                horses
                """;

        List<User> testUsersFromData = ParseTestData
                .getUsersFromData(testUserData, DELIMITER_FOR_STRINGS, DELIMITER_FOR_VALUES);
        List<Set<String>> testHobbiesFromData = ParseTestData
                .getHobbiesFromData(testHobbiesData, DELIMITER_FOR_STRINGS, DELIMITER_FOR_VALUES);

        System.out.println(testUsersFromData);
        System.out.println("--------------------------------");
        System.out.println(testHobbiesFromData);
        System.out.println("--------------------------------");
        for (Set<String> hobbies : testHobbiesFromData) {
            System.out.println(User.findHobbyLovers(testUsersFromData, hobbies));
        }
    }
}
