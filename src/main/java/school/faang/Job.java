package school.faang;

import lombok.Getter;

@Getter
public enum Job {
    Google("Google"),
    Uber("Uber"),
    Amazon("Amazon");

    private final String jobName;

    Job(String jobName) {
        this.jobName = jobName;
    }

}
