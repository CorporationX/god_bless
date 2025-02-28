package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class House {
    private static final Logger logger = Logger.getLogger(House.class.getName());
    private final List<String> roles;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        logger.info("Попытка назначить роль. Текущие роли: " + roles);

        while (roles.isEmpty()) {
            logger.warning("Нет доступных ролей. Ожидание...");
            try {
                wait();
            } catch (InterruptedException e) {
                logger.severe("Ошибка при ожидании роли: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRoel(String role) {
        roles.add(role);
        notifyAll();
    }
}



