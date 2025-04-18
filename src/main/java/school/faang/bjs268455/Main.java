package school.faang.bjs268455;

public class Main {
    public static void main(String[] args) {
        Employee googleDeveloper = Employee.builder()
                .name("Max Hall")
                .age(32)
                .job("Google")
                .address("London")
                .build();

        Employee amazonCloudEngineer = Employee.builder()
                .name("Brian Johns")
                .age(27)
                .job("Amazon")
                .address("New York")
                .build();

        Employee uberDriver = Employee.builder()
                .name("Alex Marks")
                .age(17)
                .job("Uber")
                .address("Warsaw")
                .build();
    }
}