package school.faang.task45024;

import lombok.Getter;

@Getter
public class ResourceRequest {
    private final double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
