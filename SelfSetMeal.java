
public class SelfSetMeal {
            
    private Food MainMeal;
    private Food SubMeal;
    private Food Drink;
    private String Id;
    private String Name;
    private int Price;
    
    public SelfSetMeal(Food m,Food s,Food d,String id){
        setMainMeal(m);
        setSubMeal(s);
        setDrink(d);
        setId(id);
        setPrice();
        setName();
    }
    
    public void setMainMeal(Food m){
        MainMeal = m;
    }
    public void setSubMeal(Food s){
        SubMeal = s;
    }
    public void setDrink(Food d){
        Drink = d;
    }
    public void setId(String id){
        Id = id;
    }
    public void setName(){
        Name = MainMeal.getName()+"+"+SubMeal.getName()+"+"+Drink.getName();
    }
    public void setPrice(){
        Price = (int) ((MainMeal.getPrice()+SubMeal.getPrice()+Drink.getPrice())*0.85);
    }
    public String getId(){
        return Id;
    }
    public String getName(){
        return Name;
    }
    public int getPrice(){
        return Price;
    }
    public Food getMainMeal(){
        return MainMeal;
    }
    public Food getSubMeal(){
        return SubMeal;
    }
    public Food getDrink(){
        return Drink;
    }
}
