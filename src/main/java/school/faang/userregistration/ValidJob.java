package school.faang.userregistration;

import lombok.Getter;

@Getter
public enum ValidJob {
    GOOGLE("Google"),
    UBER("Uber"),
    AMAZON("Amazon");

    private final String name;

    ValidJob(String name) {
        this.name = name;
    }

    public static boolean isValid(String job) {
        for (ValidJob validJob : values()) {
            if (validJob.name.equalsIgnoreCase(job)) {
                return true;
            }
        }
        return false;
    }
}
