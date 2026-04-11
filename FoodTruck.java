import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodTruck {

    public FoodTruck(){
    }
    private ArrayList<String> tab = new ArrayList();
    static HashMap<String, Double> menu = new HashMap<>();
    static HashMap<String,Integer> supply = new HashMap<>();
    public static HashMap<String, Double> MenuL(){
        // HashMap<String, Double> menu = new HashMap<>();
        menu.put("burger", 2.5);
        menu.put("fries", 1.5);
        menu.put("pepsi", 3.0);
        menu.put("ice cream", 1.25);
        return menu;
    }
    public static HashMap<String, Integer> stock(){
        supply.put("burger", 10);
        supply.put("fries", 10);
        supply.put("pepsi", 10);
        supply.put("ice cream", 10);
        return supply;
    }
    public static HashMap<String, Integer> updateStock(String item, int newQuantity){
        supply.put(item, newQuantity);
        return supply;
    }
    //bug here; doesn't update supply vals
    public void order(){
        MenuL();
        stock();
        Scanner scan = new Scanner(System.in);
        // ArrayList<String> tab = new ArrayList<>();
        double total = 0;
        
        if (tab.size()==0){
            System.out.println("hello our menu is: ");
            for (Map.Entry<String, Double> entry : menu.entrySet()) {
                String key = entry.getKey();
                double val = entry.getValue();
                System.out.println(key+": $"+val);
                
            }
            System.out.println("what would you like to order?");
            String item = scan.nextLine();
            if (menu.containsKey(item)){
                tab.add(item);
                updateStock(item, 9);
                order();
            }
            else{
                System.out.println("your requested item is not on the menu");
                order();
            }
        }
        
        System.out.println("anything else?");
        String shouldContinue = scan.nextLine();
        if ((shouldContinue.length())>0&&!shouldContinue.contains("no")){
            if (menu.containsKey(shouldContinue)){
                tab.add(shouldContinue);
                updateStock(shouldContinue, supply.get(shouldContinue)-1);
                order();
            }
            else{
                System.out.println("your requested item is not on the menu");
                order();
            }
            // tab.add(shouldContinue);
            // order();
        }
        else{
            System.out.println("your order: "+tab);
            System.out.println("Amount due: ");
            for (String elem : tab) {
                total += menu.get(elem);
            }
            System.out.println(total);
            tab.clear();
        }
        System.out.println(supply);

    }
    public static void main(String[] args) {
        
    }
}
