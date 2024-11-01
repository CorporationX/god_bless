package ravens_letter;

public class Main {
    public static void main(String[] args) {
        RavenServis ravenServis = new RavenServis();
        Kingdom north = new Kingdom("North");
        Kingdom winterfell = new Kingdom("Winterfell");
        ravenServis.sendRaven(winterfell, north)
                .handle((result, exception) -> {
                    if (exception != null) {
                        return "Exception " + exception.getMessage();
                    } else {
                        return "Succes: " + result;
                    }
                })
                .thenAccept(System.out::println)
                .join();
    }
}
