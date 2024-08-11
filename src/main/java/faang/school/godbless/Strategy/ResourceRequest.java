package faang.school.godbless.Strategy;

import lombok.Getter;

@Getter
public class ResourceRequest {
    public ResourceRequest(double load) {
        this.load = load;
    }

    private double load;

}
