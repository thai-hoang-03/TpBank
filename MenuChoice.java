package TpBank;
import java.util.Scanner;

public class MenuChoice {
    private Scanner scanner = new Scanner(System.in);
    private User user = new User();

    public void displayMenu() {
        System.out.println("---------Login Program---------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choose one option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                user.setLanguage("Vi");
                break;
            case 2:
                user.setLanguage("En");
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                displayMenu();
                break;
        }

        login();
    }

    private void login() {
        Login login = new Login(user);
        login.checkValidAccountNumber();
        login.checkValidPassword();
        String captcha = login.generateCaptcha();
        System.out.println("Captcha: " + captcha);
        login.checkValidCaptcha();
    }
     public static void main(String[] args) {
        MenuChoice menuChoice = new MenuChoice();
        menuChoice.displayMenu();
    }
    
}
