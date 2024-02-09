package faang.school.godbless.r_edzie.dataCenter;

import lombok.Data;

@Data
public class ResourceRequest {
    private double load;

    ResourceRequest(double load) {
        this.load = load;
    }
}
