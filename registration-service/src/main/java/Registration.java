public class Registration {
    private final AccountService accountService;

    public Registration(AccountService accountService) {
        this.accountService = accountService;
    }

    public void userRegistration(String login, String password, String email){
        UserProfile userProfile=new UserProfile(login, password, email);
        accountService.addUser(userProfile);
    }

    public boolean isRegistered(String login){
        return accountService.getUserByLogin(login)!=null;
    }
}
