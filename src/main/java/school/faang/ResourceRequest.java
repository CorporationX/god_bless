package school.faang;

import lombok.Getter;

@Getter
public class ResourceRequest {
    private final double load;

    public ResourceRequest(double load) {
        this.load = validateResourceRequest(load);
    }

    private double validateResourceRequest(double load) {
        if (load < 0) {
            throw new IllegalArgumentException("Variable 'load' cannot be less than 0!");
        }
        return load;
    }
}
