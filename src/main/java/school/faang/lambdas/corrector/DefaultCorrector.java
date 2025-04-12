package school.faang.lambdas.corrector;

public class DefaultCorrector extends Corrector {

    public DefaultCorrector() {
        super(notification -> notification);
    }
}