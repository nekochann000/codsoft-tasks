import java.util.Scanner;

public class currency {
    
    public currency() {
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base, target;
        
        System.out.println("Choose your base currency:");
        System.out.println("1. Afghanistan Currency (Afghan Afghani) \n2. Andorra Currency (Euro)");
        System.out.println("3. Australia Currency (Australian Dollar) \n4. Bangladesh Currency (Bangladeshi Taka)");
        System.out.println("5. Indian Currency (Indian Rupee)");
        
        base = scanner.nextInt();
        
        switch(base) {
            case 1:
                System.out.println("Afghan Currency selected.");
                break;
            case 2:
                System.out.println("Euro selected.");
                break;
            case 3:
                System.out.println("Australian Dollar selected.");
                break;
            case 4:
                System.out.println("Bangladeshi Taka selected.");
                break;
            case 5:
                System.out.println("Indian Rupees selected.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                return; // Exit the program if the choice is invalid
        }
        
        System.out.println("Choose your target currency:");
        System.out.println("1. Afghanistan Currency (Afghan Afghani)");
        System.out.println("2. Andorra Currency (Euro)");
        System.out.println("3. Australia Currency (Australian Dollar)");
        System.out.println("4. Bangladesh Currency (Bangladeshi Taka)");
        System.out.println("5. Indian Currency (Indian Rupee)");
        
        target = scanner.nextInt();
        
        switch(target) {
            case 1:
                System.out.println("Afghan Currency selected as target.");
                break;
            case 2:
                System.out.println("Euro selected as target.");
                break;
            case 3:
                System.out.println("Australian Dollar selected as target.");
                break;
            case 4:
                System.out.println("Bangladeshi Taka selected as target.");
                break;
            case 5:
                System.out.println("Indian Rupees selected as target.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                return; // Exit the program if the choice is invalid
        }
        
        scanner.close();
    }
}
