package faang.school.godbless.BJS29796.processor;

public interface Processor<T> {

    void handle(T request);

    Processor setNext(Processor next);
}
