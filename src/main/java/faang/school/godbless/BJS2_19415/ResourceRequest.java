package faang.school.godbless.BJS2_19415;

import lombok.Getter;


@Getter
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        checkLoad(load);
        this.load = load;
    }

    private void checkLoad(double load) {
        if (load < 0.0) {
            throw new IllegalArgumentException("The value of the requested load cannot be negative");
        }
    }
}
