package faang.school.godbless.database_center;

import lombok.Data;

@Data
public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
