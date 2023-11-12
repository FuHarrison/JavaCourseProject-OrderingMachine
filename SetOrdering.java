import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class SetOrdering extends JFrame implements Source {
    private Payable p = new Payable();
    private Method m=new Method();
    private String titleList[]={"品名","主餐","副餐","飲料","價錢","數量",};
    private String mainList[]={"無","無","無","麥香雞,大麥克","大麥克*2"};
    private String secondList[]={"薯條(中)","薯條(小),薯餅","薯條(大)","薯餅","薯條(大)*2"};
    private String drinkList[]={"雪碧","可樂","雪碧","雪碧,可樂","雪碧*2\n可樂*2"};
    private JButton nextButton=new JButton();
    private JButton buttonListLess[]=new JButton[5];
    private JButton buttonListAdd[]=new JButton[5];
    private ImageIcon imageList[]=new ImageIcon[5];
    private JLabel labelListQuantity[]=new JLabel[5];
    private SetMeal setList[]={
        new SetMeal("A","普通套餐",60),
        new SetMeal("B","薯餅套餐",70),
        new SetMeal("C","吃飽套餐",70),
        new SetMeal("D","雙人套餐",110),
        new SetMeal("E","家庭套餐",250),
    };
    private Container cp;
    
    public SetOrdering(Payable p){
        this.p = p;
        menu(setList);
    }

    public void menu(SetMeal [] setList){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        imageList[0]=new ImageIcon(SetOrdering.class.getResource("picture/add.png"));
        imageList[1]=new ImageIcon(SetOrdering.class.getResource("picture/minus.png"));
        this.setList=setList;
        this.setSize(1020,650);
        this.setLocation(0,0);
        this.setTitle("指定套餐");
        this.setVisible(true);
        cp=this.getContentPane();
        cp.setLayout(null);
        for(int i =0 ; i < 5 ; i++){
            this.labelListQuantity[i]=new JLabel("0",SwingConstants.CENTER);
            this.buttonListAdd[i] = new JButton("");
            this.buttonListLess[i]=new JButton("");
            m.addTitle(cp,""+setList[i].getMealId(),0,180+(60*i),60,60,15);
            m.addTitle(cp,setList[i].getMealName(),60,180+(60*i),120,60,15);
            m.addTitle(cp,mainList[i],180,180+(60*i),120,60,15);
            m.addTitle(cp,secondList[i],300,180+(60*i),120,60,15);
            m.addTitle(cp,drinkList[i],420,180+(60*i),120,60,15);
            m.addTitle(cp,""+setList[i].getMealPrice(),540,180+(60*i),120,60,15);
            m.addLabel(cp,labelListQuantity[i],660,180+(60*i),120,60,15);
            m.addImgButton(imageList[0],cp,buttonListAdd[i],780,180+(60*i),120,60);
            m.lessImgButton(imageList[1],cp,buttonListLess[i],900,180+(60*i),120,60);
            addQuantity(i);
            lessQuantity(i);
        }
        for(int i = 0 ; i < 6 ; i++){
            m.addTitle(cp,titleList[i],60+(120*i),100,120,80,25);
        }
        m.addTitle(cp,"指定套餐",0,0,1020,100,40);
        m.addTitle(cp,"ID",0,100,60,80,25);
        m.addTitle(cp,"點餐/取消",780,100,240,80,25);
        //addWindowButton(1,nextButton,200,520,620,80,35);
        nextButton.setFont(new java.awt.Font("微軟正黑體", 0, 36));
        nextButton.setText("下一步");
        nextButton.setBounds(200,520,620,80);
        nextButton.setBorder(BorderFactory.createEtchedBorder());
        nextButton.setHorizontalTextPosition(JButton.LEADING);
        nextButton.setVerticalTextPosition(JButton.CENTER);
        nextButton.setForeground(Color.blue);
        cp.add(nextButton);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i = 0;i < 5;i++){
            int temp = 0;
            temp = p.getSet(i).getQuantity() + this.setList[i].getQuantity();
            p.getSet(i).setQuantity(temp);
        }
        close();
        StartOrdering s = new StartOrdering(p);
        s.setVisible(true);
    }  
    
    public void addQuantity(int i){
            buttonListAdd[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
            setList[i].incrementQuant();
            if(setList[i].getQuantity()>0){
                buttonListLess[i].setEnabled(true);
            }
            labelListQuantity[i].setText(Integer.toString(setList[i].getQuantity()));
        }
        });
    }
    
    public void lessQuantity(int i){
            buttonListLess[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
            if(setList[i].getQuantity()>0){
                setList[i].decrementQuant();
            }
            if(setList[i].getQuantity()==0){
                buttonListLess[i].setEnabled(false);
            }
            labelListQuantity[i].setText(Integer.toString(setList[i].getQuantity()));
        }
        });
    }
    
    public void close(){
	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
}