package sprint3task7;
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
    //применяется фильтр или нет)
}
