package ohtu.authentication;

import static java.lang.Character.isLetter;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;
    private String error;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
        this.error = "";
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }
        
        if(invalid(username,password,passwordConfirmation)){
            System.out.println(this.error);
            status.addError(this.error);
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    
    private boolean invalid(String username, String password, String confirmation) {
        if (username.length()<3 ) {
            this.error = "username should have at least 3 characters";
            return true;
        }
        if (password.length()<9 ) {
            this.error = "password should have at least 8 characters";
            return true;
        }
        if (!password.equals(confirmation)) {
            this.error = "password and password confirmation do not match";
            return true;
        }
        if (hasOnlyLetters(password)) {
            this.error = "password should have at least one non-letter character";
            return true;
        }
        
        return false;
    }
    
    private boolean hasOnlyLetters(String password){
        boolean letter = true;
        for (int i = 0; i < password.length(); i++){
            if (!isLetter(password.charAt(i))){
                letter = false;
            }
        }
        return letter;
    }

}
