import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AccountServiceTest {
    AccountService accountService;

    @Before
    public void setUp() throws Exception {
        accountService=new AccountService();
    }

    @Test
    public void addUser() {
        UserProfile user=new UserProfile("login1", "password1", "email1");
        accountService.addUser(user);
        UserProfile storedUser=accountService.getUserByLogin("login1");
        assertEquals(user, storedUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateUser() {
        UserProfile user=new UserProfile("login1", "password1", "email1");
        accountService.addUser(user);
        UserProfile storedUser=accountService.getUserByLogin("login1");
        assertEquals(user, storedUser);
    }

    @Test
    public void updateUserTest() {
        UserProfile user =new UserProfile("login1", "password1", "email1");
        accountService.addUser(user);

        UserProfile updatedUser =new UserProfile("login2", "password2", "email1");
        accountService.updateUser(updatedUser);

        UserProfile storedUser = accountService.getUserByLogin("user1");

        assertEquals(updatedUser, storedUser);
    }

}
