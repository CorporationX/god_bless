package faang.school.godbless.optimizing_datacenter;

public interface OptimizationStrategy {
//    I wonder why cant abstract method cannot be static
//    like in case of OptimizationStrategy optimize only needs passed to parameters data, so it can be static, but that breaks abstract
    abstract void optimize(DataCenter dataCenter);
}
