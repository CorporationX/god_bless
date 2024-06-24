package faang.school.godbless.fan;

public class Main {
    public static void main(String[] args) {
        ResultConsumer result = new ResultConsumer(123);
        System.out.println(result.fanOutFanIn());
        result.shutdownExecutor();
    }
}
