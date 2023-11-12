public class Payable {
    private Food foodList[] = {
        new Food("����(�p)",33,"���\","picture/1.png",1),
        new Food("������",44,"�D�\","picture/2.png",2),
        new Food("�i��(�p)",28,"����","picture/3.png",3),
        new Food("����(�p)",28,"����","picture/4.png",4),
        new Food("����(��)",44,"���\","picture/5.png",5),
        new Food("����",30,"���\","picture/6.png",6),
        new Food("���ֳ�",48,"�D�\","picture/7.png",7),
        new Food("����(�j)",55,"���\","picture/8.png",8),
        new Food("�j���J",72,"�D�\","picture/9.png",9),
        new Food("�ɦ̿@��",40,"����","picture/10.png",10),
    };
    private SetMeal setList[]={
        new SetMeal("A","���q�M�\",60),
        new SetMeal("B","����M�\",70),
        new SetMeal("C","�Y���M�\",70),
        new SetMeal("D","���H�M�\",110),
        new SetMeal("E","�a�x�M�\",250),
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
