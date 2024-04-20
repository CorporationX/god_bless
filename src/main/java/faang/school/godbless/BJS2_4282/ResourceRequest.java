package faang.school.godbless.BJS2_4282;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceRequest {

    private static final Integer MIN_DOUBLE_LOAD = 0;
    private static final Integer MAX_DOUBLE_LOAD = 100;

    private double doubleLoad;

    public ResourceRequest(double doubleLoad) {
        validateDoubleLoad(doubleLoad);
        this.doubleLoad = doubleLoad;
    }

    private void validateDoubleLoad(double doubleLoad) {
        if (doubleLoad <= MIN_DOUBLE_LOAD || doubleLoad >= MAX_DOUBLE_LOAD) {
            throw new IllegalArgumentException("Not valid data");
        }
    }
}
