package school.faang.droids;

public class Main {
    public static void main(String[] args) {
        Droid rtwo = new Droid("R2");
        Droid reight = new Droid("R8");

        System.out.println("R2 says: " + rtwo.sendMessage("Hello R8", 3, reight));
        System.out.println("R2 says: " + rtwo.sendMessage("Hello R2", 7, rtwo));

    }

}
