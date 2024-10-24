package school.faang.crow;

public class Main {
    public static void main(String[] args) {

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        winterfell.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Ошибка " + exception.getMessage());
                    } else {
                        System.out.println(result);
                    }
                    return null;
                }).join();
    }
}
