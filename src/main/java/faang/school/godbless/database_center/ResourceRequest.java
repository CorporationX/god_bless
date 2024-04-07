package faang.school.godbless.database_center;

public class ResourceRequest {
    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "ResourceRequest{" +
                "load=" + load +
                '}';
    }
}
