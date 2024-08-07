package faang.school.godbless.BJS2_19415;

import lombok.AllArgsConstructor;
import lombok.Getter;



public class ResourceRequest {
    @Getter
    private double load;

    public ResourceRequest(double load) {
        checkLoad(load);
        this.load = load;
    }

    private void checkLoad(double load) {
        if (load < 0.0) {
            throw new IllegalArgumentException("Значение запрашиваемой нагрузки не может быть отрицательным");
        }
    }
}
