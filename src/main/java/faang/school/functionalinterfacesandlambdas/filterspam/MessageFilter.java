package faang.school.functionalinterfacesandlambdas.filterspam;

@FunctionalInterface
public interface MessageFilter {

    boolean filter(String message);
}
