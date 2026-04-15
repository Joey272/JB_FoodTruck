import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodTruck {

    public FoodTruck(){
        supply.put("burger", 10);
        supply.put("fries", 10);
        supply.put("pepsi", 10);
        supply.put("ice cream", 10);
        item.put("burger", 1);
        item.put("fries", 2);
        item.put("pepsi", 3);
        item.put("ice cream", 1);
    }
    public FoodTruck(int StockAll){
        supply.put("burger", StockAll);
        supply.put("fries", StockAll);
        supply.put("pepsi", StockAll);
        supply.put("ice cream", StockAll);
        item.put("burger", 1);
        item.put("fries", 2);
        item.put("pepsi", 3);
        item.put("ice cream", 1);
    }
    public FoodTruck(int StockF,int StockB,int StockIC,int StockP){
        supply.put("burger", StockB);
        supply.put("fries", StockF);
        supply.put("pepsi", StockP);
        supply.put("ice cream", StockIC);
        item.put("burger", 1);
        item.put("fries", 2);
        item.put("pepsi", 3);
        item.put("ice cream", 1);
    }
    private String temS;
    private int tempI;
    private ArrayList<String> tab = new ArrayList();
    static HashMap<String, Double> menu = new HashMap<>();
    static HashMap<String, Integer> item = new HashMap<>();
    Map<String,Integer> supply = new HashMap<>();
    private double profit;


    public static HashMap<String, Double> MenuL(){
        // HashMap<String, Double> menu = new HashMap<>();
        menu.put("burger", 2.5);
        menu.put("fries", 1.5);
        menu.put("pepsi", 3.0);
        menu.put("ice cream", 1.25);
        return menu;
    }
    public Map<String, Integer> updateStock(String item){
        int x= supply.get(item);
        System.out.println(x);
        supply.remove(item);
        supply.put(item, x-1);
        System.out.println(item+" , "+x);
        return supply;
    }
    //bug here; doesn't update supply vals --Fixed
    // public static void itemNum(){
    //     // HashMap<String, Double> menu = new HashMap<>();
    //     item.put("burger", 1);
    //     item.put("fries", 2);
    //     item.put("pepsi", 3);
    //     item.put("ice cream", 1);
    // }
    public void order(){
        MenuL();
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
                updateStock(item);
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
                updateStock(shouldContinue);
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
                calcProfit(elem);
            }
            System.out.println(total);
            tab.clear();
            System.out.println(supply);
            System.out.println(profit);
        }

    }
    public void aiOrder(){
        int chance = (int)(Math.random()*item.size());
        int orderSize = (int)(Math.random()*5);
        if(chance==0){
            chance++;
        }
        if(orderSize==0){
            orderSize++;
        }
        String order= "";
        System.out.println(chance);
        //int fromMenu = item.get
        for (int i = 0; i < orderSize; i++) {
            for (Map.Entry<String,Integer> ent:item.entrySet()) {
                if(ent.getValue()==chance){
                    order = ent.getKey();

                }
        }
        }
        System.out.println(order);
        System.out.println(orderSize);
        //System.out.println(item.size());
    }
    public void calcProfit(String itemSold){
        double profitFormula =menu.get(itemSold)*0.25;
        profit+=profitFormula;
    }
    public static void main(String[] args) {
        
    }
}
