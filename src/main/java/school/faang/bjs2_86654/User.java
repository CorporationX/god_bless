package school.faang.bjs2_86654;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;


    String[] validJobs = {"Google", "Uber", "Amazon"};
    String[] validAddresses = {"London", "New York", "Amsterdam"};

    public User(String name, int age, String job, String address) {
        boolean jobIsValid = false;
        boolean addressIsValid = false;

        try {
            for (String validJob : validJobs) {
                if (job.equals(validJob)) {
                    jobIsValid = true;
                    break;
                }
            }
            if (!jobIsValid) {
                throw new IllegalArgumentException("it's not job in criteria");
            }
            for (String validAddress : validAddresses) {
                if (address.equals(validAddress)) {
                    addressIsValid = true;
                    break;
                }
            }
            if (!addressIsValid) {
                throw new IllegalArgumentException("it's not address in criteria");
            }
            if (age < 18) {
                throw new IllegalArgumentException("it's not age in criteria");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("it's not name");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
