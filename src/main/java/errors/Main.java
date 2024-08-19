package errors;

public class Main {
    public static void main(String[] args) {
        Action<String> action = new Action();

        action.doAction((name) -> System.out.println(name + " совершил какое-то действие"),
                        (exception) -> new IllegalArgumentException("Exception"));

    }

}
