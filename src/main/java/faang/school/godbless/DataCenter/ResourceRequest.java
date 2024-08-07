package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceRequest {

    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }

    public boolean isRequestAllocated() {
        return load == 0;
    }
}
