public class Payable {
    private Food foodList[] = {
        new Food("Á¦±ø(¤p)",33,"°ÆÀ\","picture/1.png",1),
        new Food("³Á­»Âû",44,"¥DÀ\","picture/2.png",2),
        new Food("¥i¼Ö(¤p)",28,"¶¼®Æ","picture/3.png",3),
        new Food("³·ºÑ(¤p)",28,"¶¼®Æ","picture/4.png",4),
        new Food("Á¦±ø(¤¤)",44,"°ÆÀ\","picture/5.png",5),
        new Food("Á¦»æ",30,"°ÆÀ\","picture/6.png",6),
        new Food("º¡ºÖ³ù",48,"¥DÀ\","picture/7.png",7),
        new Food("Á¦±ø(¤j)",55,"°ÆÀ\","picture/8.png",8),
        new Food("¤j³Á§J",72,"¥DÀ\","picture/9.png",9),
        new Food("¥É¦Ì¿@´ö",40,"¶¼®Æ","picture/10.png",10),
    };
    private SetMeal setList[]={
        new SetMeal("A","´¶³q®MÀ\",60),
        new SetMeal("B","Á¦»æ®MÀ\",70),
        new SetMeal("C","¦Y¹¡®MÀ\",70),
        new SetMeal("D","Âù¤H®MÀ\",110),
        new SetMeal("E","®a®x®MÀ\",250),
    };
    
    private SelfSetMeal selfList[] = new SelfSetMeal[100];
    
    public void setSelf(int i,SelfSetMeal selfmeal){
        selfList[i] = selfmeal;
    }
    public Food getFood(int i){
        return foodList[i];
    }
    public SetMeal getSet(int i){
        return setList[i];
    }
    public SelfSetMeal getSelf(int i){
        return selfList[i];
    }
    
    public void resetAll(){
        for(int i = 0;i < 10;i++){
            foodList[i].setQuantity(0);
        }
        for(int i = 0;i < 5;i++){
            setList[i].setQuantity(0);
        }
        for(int i = 0;i < 100;i++){
            selfList[i] = null;
        }
    }
    
    public int TotalPay(){
        int total = 0,singleTotal =0,setTotal = 0,selfTotal = 0;
        for(int i = 0;i < 10;i++){
            singleTotal += foodList[i].getQuantity()*foodList[i].getPrice();
        }
        for(int i = 0;i < 5;i++){
            setTotal += setList[i].getQuantity()*setList[i].getMealPrice();
        }
        for(int i = 0;i < 100;i++){
            if(selfList[i] != null){
                selfTotal += selfList[i].getPrice();
            }        
        }
        total = singleTotal + setTotal +selfTotal;
        return total;
    }
    

}
