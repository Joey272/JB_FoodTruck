import java.util.ArrayList;
import java.util.Scanner;

public class FoodTruck {
    public FoodTruck(){
    }
    private ArrayList<String> tab = new ArrayList();
    public void order(){
        Scanner scan = new Scanner(System.in);
        System.out.println("what would you like to order?");
        String item = scan.nextLine();
        
        tab.add(item);
        System.out.println("anything else? Yes or no");
        String shouldContinue = scan.nextLine();
        if (shouldContinue.equalsIgnoreCase("yes")){
            order();
        }
        else{
            System.out.println("your order: "+tab);
        }

    }
    public void stock(){

    }
    public static void main(String[] args) {
        
    }
}
