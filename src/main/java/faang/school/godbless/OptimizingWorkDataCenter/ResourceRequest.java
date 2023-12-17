package faang.school.godbless.OptimizingWorkDataCenter;

public class ResourceRequest {
    private double load; //будет использоваться, когда к нашему дата-центру приходит запрос на выделение ресурса

    public double getLoad() {
        return load;
    }

    public ResourceRequest(double load) {
        this.load = load;
    }
}
