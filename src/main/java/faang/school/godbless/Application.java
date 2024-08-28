package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        try {
            MasterCardService.doAll();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}