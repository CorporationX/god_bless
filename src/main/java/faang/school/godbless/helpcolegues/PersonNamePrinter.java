import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println(name);
    }
}
