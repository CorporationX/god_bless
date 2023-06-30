package faang.school.godbless.ironThrone;


public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House houseForIn){
        house = houseForIn;
            if(house.getAvailableRoles()<=0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            this.role = house.getRoles().get((int)Math.ceil((Math.random()) * house.getAvailableRoles()));
            System.out.println(name + " присоединился к дому " + house.getName() + " в роли " + this.role);
            house.addRole();

    }

    public synchronized void leaveHouse(){
        if(house != null) {
                this.house.getRoles().add(role);
                this.house.removeRole(name);
                System.out.println(name + " покинул дом " + this.house.getName() + " и роль " + this.role);
                this.house = null;
                this.notify();
        }
    }
}
