package faang.school.godbless.BJS2_24696;

import lombok.Getter;

@Getter
public enum Status {
    NEW("new"),
    IN_PROGRESS("in_progress"),
    DONE("done");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}