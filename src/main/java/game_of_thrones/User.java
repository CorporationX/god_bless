package game_of_thrones;

class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String desiredRole) {
        house.getLock().lock();
        try {
            while (!house.getAvailableRoles().contains(desiredRole)) {
                System.out.println(name + " ждет пока освободится " + desiredRole);
                house.getRoleAvailableCondition().await();
            }

            house.removeRole(desiredRole);
            this.house = house;
            this.role = desiredRole;
            Thread.sleep(1000);
            System.out.println(name + " присоединился к " + house + " в роли " + role);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            house.getLock().unlock();
        }
    }

    public void leaveHouse(House house) {
        house.getLock().lock();
        try {
            if (house != null) {
                house.addRole(role);
                Thread.sleep(1000);
                System.out.println(name + " покинул " + house + ". Роль '" + role + "' стала доступной.");
                this.house = null;
                this.role = null;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            house.getLock().unlock();
        }
    }

    public House getHouse() {
        return house;
    }
}


