import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationTest {
    @Mock
    AccountService accountService;

  Registration registration;

    @Before
    public void setUp() throws Exception {
        registration=new Registration(accountService);
    }

    @Test
    public void newUserRegistrationTest() {
        String login="login1";
        String password="password1";
        String email="email1";
        UserProfile user=new UserProfile(login, password, email);

        registration.userRegistration(login, password, email);
        verify(accountService).addUser(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void DuplicateUserRegistrationTest() {
        String login="login1";
        String password="password1";
        String email="email1";
        UserProfile user=new UserProfile(login, password, email);
        doThrow(new IllegalArgumentException()).when(accountService).addUser(user);
        registration.userRegistration(login, password, email);

    }

    @Test
    public void isregisteredTest() {
        String login="login1";
        String password="password1";
        String email="email1";
        UserProfile user=new UserProfile(login, password, email);
        when(accountService.getUserByLogin(login)).thenReturn(user);
        assertEquals(registration.isRegistered(login), true);
    }
}

