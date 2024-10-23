package school.faang.sendaravane;

public class GameOfThronesMessenger {
    public static void main(String[] args) {
        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        Kingdom dorne = new Kingdom("Dorne");

        RavenService ravenService = new RavenService();

        CompletableFuture<String> future1 = ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Failed to send message: " + ex.getMessage();
                    } else {
                        return result;
                    }
                });
        
        CompletableFuture<String> future2 = ravenService.sendRaven(winterfell, dorne)
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Failed to send message: " + ex.getMessage();
                    } else {
                        return result;
                    }
                });
    }
}
