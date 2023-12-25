package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.service;

import faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model.UserProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class UserService {
    List<UserProfile> users = new ArrayList<>();
    public UserProfile findById(int id) {
        return users.get(id);
    }
}
