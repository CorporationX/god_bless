package school.faang.sprint_4.task_43579;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println(exception.getMessage());
                    } else {
                        System.out.println(result);
                    }
                    return null;
                }).join();
    }
}