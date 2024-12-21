package derschrank.sprint01.task12.bjstwo_45017;

public class ResourceRequest {
    private final double load;

    public ResourceRequest(double load) {
        this.load = load;
    }

    public double getLoad() {
        return load;
    }


    @Override
    public String toString() {
        return "ResourceRequest: " + load;
    }
}
