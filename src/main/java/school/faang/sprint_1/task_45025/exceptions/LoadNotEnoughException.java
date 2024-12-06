package school.faang.sprint_1.task_45025.exceptions;

public class LoadNotEnoughException extends Exception{
    public LoadNotEnoughException(double amountOfMissingLoad) {
        super("Load not enough in count " + amountOfMissingLoad);
    }
}
