package faang.school.godbless.BJS2_19800.model;

import lombok.Data;

@Data
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
