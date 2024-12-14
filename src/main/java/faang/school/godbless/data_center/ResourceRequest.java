package faang.school.godbless.data_center;

import lombok.Data;

@Data
public class ResourceRequest {
    private int id;
    private double load;

    public ResourceRequest(int id, double load) {
        this.id = id;
        if (load < 0) {
            throw new RuntimeException("Cannot require negative load");
        }
        this.load = load;
    }
}
