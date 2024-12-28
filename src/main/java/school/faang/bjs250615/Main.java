package school.faang.bjs250615;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("main started");
        RavenService ravenService = new RavenService();

        Kingdom test1 = new Kingdom("test1");
        Kingdom test2 = new Kingdom("test2");

        ravenService.sendRaven(test1, test2)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Something went wrong: " + exception.getMessage());
                    } else {
                        System.out.println(result);
                    }
                    return null;
                }).join();

        long end = System.currentTimeMillis();
        System.out.println("main ended");
        System.out.println("time elapsed: " + (end - start));
    }

}
