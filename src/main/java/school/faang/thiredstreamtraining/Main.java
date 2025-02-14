package school.faang.thiredstreamtraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Operations operations = new Operations();
        Map<String, List<String>> friends = Map.of("Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie"));
        List<Employee> employees =
                List.of(new Employee("Tolik", 100000, DepartmentType.LEARNING_AND_DEVELOPMENT),
                        new Employee("Timur", 120000, DepartmentType.LEARNING_AND_DEVELOPMENT),
                        new Employee("Kolyan", 150000, DepartmentType.LEARNING_AND_DEVELOPMENT),
                        new Employee("Igorek", 200000, DepartmentType.DEVELOPMENT),
                        new Employee("Semka", 220000, DepartmentType.DEVELOPMENT),
                        new Employee("Tema", 250000, DepartmentType.DEVELOPMENT));

        logger.info(operations.checkThereIsNoDirectFriendship(friends).toString());
        logger.info(operations.countAverageSalary(employees).toString());
        logger.info(operations.findNumberPalindroms(100, 200).toString());
        logger.info(operations.findSubstringPalindroms("abac").toString());
        logger.info(operations.findPerfectNumbers(1, 1000).toString());
    }
}
