package school.faang.task_48303;

@RequiredArgsConstructor
public class Officiant implements Runnable {
    private final House house;

    @Override
    public void run() {
        house.collectFood();
    }
}