public class SetMeal{
    private String MealId;
    private String MealName;
    private int MealPrice;
    private int quantity;

    public SetMeal(String i,String m,int p){
        setMealId(i);
        setMealName(m);
        setMealPrice(p);
        setQuantity(0);
    }
    public void setQuantity(int quantity){this.quantity=quantity;}
    public int getQuantity(){return quantity;}
	public void setMealId(String id){MealId = id;}
	public String getMealId(){return MealId;}
	public void setMealName(String name){MealName = name;}
	public String getMealName(){return MealName;}
	public void setMealPrice(int price){MealPrice = price;}
	public int getMealPrice(){return MealPrice;}

    public void incrementQuant(){
		quantity++;
	}
	public void decrementQuant(){
		quantity--;
	}
    public void resetQuantity(int a){
		this.quantity=a;
	}
    public String toString(){
        return getMealId()+"  "+getMealName()+" "+String.format("%3d",getMealPrice())+"  ®MÀ\  µL";
    }
}
