import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> loginToProfile;

    public AccountService () {
        this.loginToProfile = new HashMap<>();

    }
    public void addUser(UserProfile userProfile){
        if(loginToProfile.containsKey(userProfile.getLogin())){
            throw new IllegalArgumentException("Такой пользователь уже существует");
        }
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public void updateUser(UserProfile newUserProfile) {
        if (loginToProfile.containsKey(newUserProfile.getLogin())) {
            loginToProfile.put(newUserProfile.getLogin(), newUserProfile);
        } else {
            throw new IllegalArgumentException("Пользователь с таким логином не существует");
        }
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }
}
