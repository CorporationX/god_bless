package faang.school.godbless.OptimizeDataCenter2064;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}