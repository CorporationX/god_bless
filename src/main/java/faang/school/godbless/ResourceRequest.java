package faang.school.godbless;

import lombok.Getter;

@Getter
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
