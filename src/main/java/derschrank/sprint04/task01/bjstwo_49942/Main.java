package derschrank.sprint04.task01.bjstwo_49942;

public class Main {
    public static void main(String[] args) {
        CardServiceInterface service = new MasterCardService();

        try {
            service.doAll();
        } catch (Exception e) {
            System.out.println("Was interrupted");
        }
    }
}
