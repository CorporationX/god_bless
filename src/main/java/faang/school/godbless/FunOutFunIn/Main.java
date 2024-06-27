package faang.school.godbless.FunOutFunIn;

public class Main {
    public static void main(String[] args) {
        CountManager countManager = new CountManager();
        countManager.launch();
        CountManager.shutdownManager();
    }
}
