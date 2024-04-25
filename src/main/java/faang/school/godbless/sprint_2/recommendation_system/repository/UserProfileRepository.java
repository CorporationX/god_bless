package faang.school.godbless.sprint_2.recommendation_system.repository;

import faang.school.godbless.sprint_2.recommendation_system.model.UserProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfileRepository {

    private final Map<Integer, UserProfile> USER_PROFILES;

    public UserProfileRepository() {
        this.USER_PROFILES = new HashMap<>();
    }

    public void addUserProfile(UserProfile userProfile) {
        USER_PROFILES.put(userProfile.getId(), userProfile);
    }

    public UserProfile findUserProfileById(int id) {
        return USER_PROFILES.get(id);
    }

    public void deleteUserProfileById(int id) {
        USER_PROFILES.remove(id);
    }

    public List<UserProfile> findAllUserProfiles() {
        return USER_PROFILES.values().stream().toList();
    }
}