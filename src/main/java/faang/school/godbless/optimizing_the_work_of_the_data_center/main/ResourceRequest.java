package faang.school.godbless.optimizing_the_work_of_the_data_center.main;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        if (load < 0) {
            throw new IllegalArgumentException("Load cannot be negative");
        }
        this.load = load;
    }
}
