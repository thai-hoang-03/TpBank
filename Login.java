package TpBank;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login {
   
    private User user;
    private Scanner scanner = new Scanner(System.in);

    public Login(User user) {
        this.user = user;
    }

    public void checkValidAccountNumber() {
        System.out.print("Account number: ");
        user.setAccountNumber(scanner.next());

        String regex = "\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getAccountNumber());

        if (matcher.matches()) {
            System.out.println(getLocalizedString("valid_account_number"));
        } else {
            System.out.println(getLocalizedString("invalid_account_number"));
            checkValidAccountNumber();
        }
    }

    public void checkValidPassword() {
        System.out.print("Password: ");
        user.setPassword(scanner.next());

        String regex = "^(?=.*[a-zA-Z])(?=.*\\d).{8,31}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getPassword());

        if (matcher.matches()) {
            System.out.println(getLocalizedString("valid_password"));
        } else {
            System.out.println(getLocalizedString("invalid_password"));
            checkValidPassword();
        }
    }

    public void checkValidCaptcha() {
        System.out.print("Captcha: ");
        user.setCaptcha(scanner.next());

        // Implementation for checking captcha validity

        System.out.println(getLocalizedString("valid_captcha"));
    }

    public String generateCaptcha() {
        // Implementation using Random or other logic
        return "ABCD1234"; // Dummy value for demonstration
    }

    private String getLocalizedString(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(user.getLanguage());
        return resourceBundle.getString(key);
    }
    
   
}

