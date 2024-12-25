package school.faang;

import lombok.Getter;

import javax.management.relation.Role;
import java.util.List;

@Getter
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = roles;
        this.availableRoleCount = roles.size(); // Изначально все роли доступны
    }

//
//
//    public synchronized void removeRole(Role role) throws InterruptedException {
//      //  с помощью notifyAll(), к
//  //      synchronized (house) {
////            while (house.getAvailableRoleCount() == 0) {
////                System.out.println(name + " ждет, пока освободится роль в доме.");
////                house.wait(); // Ожидаем освобождения роли
////            }
////            String role = house.addRole();
////            chooseRole(role);
////            System.out.println(name + " выбрал роль: " + role);
// //       }
//    }
//
//    public synchronized String addRole() throws InterruptedException {
////        с помощью notifyAll(), к
// //       synchronized (house) {
////            while (house.getAvailableRoleCount() == 0) {
////                System.out.println(name + " ждет, пока освободится роль в доме.");
////                house.wait(); // Ожидаем освобождения роли
////            }
////            String role = house.addRole();
////            chooseRole(role);
////            System.out.println(name + " выбрал роль: " + role);
// //       }
//    }
//
//
//
////    addRole() уменьшается количество доступных ролей, когда пользователь выбирает роль.
////
////    removeRole() увеличивает количество доступных ролей, когда роль освобождается.
////
////    В методе addRole() или removeRole() можно оповещать другие потоки с помощью notifyAll(),
////    когда роль освобождается, чтобы другие пользователи могли "проснуться" и выбрать свою роль.

}
