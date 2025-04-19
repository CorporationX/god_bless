package school.faang.bjs268455;

public class Main {
    public static void main(String[] args) {
        try {
            User googleDeveloper = User.builder()
                    .name("Max Hall")
                    .age(32)
                    .job("Google")
                    .address("London")
                    .build();
            System.out.println(googleDeveloper);
        } catch (IllegalArgumentException e) {
            System.out.println("An error creating googleDeveloper: " + e.getMessage());
        }

        try {
            User amazonCloudEngineer = User.builder()
                    .name("Mila Yoko")
                    .age(27)
                    .job("Amazon")
                    .address("New York")
                    .build();
            System.out.println(amazonCloudEngineer);
        } catch (IllegalArgumentException e) {
            System.out.println("An error creating amazonCloudEngineer: " + e.getMessage());
        }

        try {
            User uberDriver = User.builder()
                    .name("Brian Johns")
                    .age(17)
                    .job("Uber")
                    .address("Warsaw")
                    .build();
            System.out.println(uberDriver);
        } catch (IllegalArgumentException e) {
            System.out.println("An error creating uberDriver: " + e.getMessage());
        }

        try {
            User amazonProjectManager = User.builder().
                    name("Kevin Liner")
                    .age(23).job("Amazon")
                    .address("Bali")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("An error creating amazonProjectManager: " + e.getMessage());
        }
    }
}