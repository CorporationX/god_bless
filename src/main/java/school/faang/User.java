package school.faang;

public class User {
    private String name;//поля для хранения имени пользователя,
    private House house;//дома, к которому он присоединился,
    private String chosenRole;//и выбранной роли.


//    Позволяет пользователю присоединиться к дому и выбрать роль.
//    Проверяет, есть ли доступные роли. Если роли заняты, поток
//    пользователя блокируется до тех пор, пока слот не освободится.
    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                System.out.println(name + " ждет, пока освободится роль в доме.");
                house.wait(); // Ожидаем освобождения роли
            }
//            String role = house.addRole();
//            chooseRole(role);
//            System.out.println(name + " выбрал роль: " + role);
        }
    }

    private void chooseRole(String role) {
    }


    public synchronized void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " покидает дом и освобождает роль: " + chosenRole);
//            house.removeRole(chosenRole);
//            house.notifyAll(); // Оповещаем всех ожидающих пользователей
        }
    }

}
