import java.util.Scanner;

public class FoodTruck {
    public FoodTruck(){
        Scanner scan = new Scanner(System.in);
        System.out.println("what do you want to order");
        String order = scan.nextLine();
        System.out.println("here is your food "+"("+order+")");
        scan.close();
    }
    public static void main(String[] args) {
        
    }
}
