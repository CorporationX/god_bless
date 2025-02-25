package school.faang;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();
        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        System.out.println(ravenService.sendRaven(winterfell, kingsLanding).join());
    }
}
