package school.faang.multithreading.sinchronized.bjs2_90309;

@FunctionalInterface
public interface HouseAction {
    void execute(User user, House house, Role role) throws InterruptedException;
}
