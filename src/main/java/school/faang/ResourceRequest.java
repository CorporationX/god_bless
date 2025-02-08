package school.faang;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ResourceRequest {
    private final double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
