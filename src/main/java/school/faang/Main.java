package school.faang;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();
        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Error: " + exception);
                    } else {
                        System.out.println(result);
                    }
                    return null;
                }).join();
    }
}
