package data.centre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceRequest {

    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}

