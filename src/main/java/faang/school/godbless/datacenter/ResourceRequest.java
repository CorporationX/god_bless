package faang.school.godbless.datacenter;

import lombok.Getter;

@Getter
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
