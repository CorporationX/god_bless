package ravens_letter;

public class Main {
    public static void main(String[] args) {
        RavenServis ravenServis = new RavenServis();
        Kingdom north = new Kingdom("North");
        Kingdom winterfell = new Kingdom("Winterfell");
        ravenServis.sendRaven(winterfell,north)
        .handle((result,exception)->{
            if(exception!=null){
                System.out.println("Exception "+ exception.getMessage());
            } else {
                System.out.println(result);
            }
            return null;
        })
                .join();
    }
}
