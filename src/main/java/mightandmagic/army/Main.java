package mightandmagic.army;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fleet fleet = new Fleet();
        fleet.addShip(new Frigate(1000));
        fleet.addShip(new Cruiser(2000));
        fleet.addShip(new Recon(2500));
        fleet.addShip(new Maradeur(20000));

        int totalPower = fleet.calculateTotalPower();
        System.out.println("Общая мощь космического флота: " + totalPower);

    }
}
