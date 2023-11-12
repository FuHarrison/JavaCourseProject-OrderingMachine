public class MainClass {
    public static void main(String[]args){
        Payable payable = new Payable();
        StartOrdering s = new StartOrdering(payable);
        s.setVisible(true);
    }
}

