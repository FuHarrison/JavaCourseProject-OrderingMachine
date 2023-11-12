import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SingleOrdering extends JFrame{
    
    private Payable p = new Payable();
    private Date d = new Date();
    private Container cp;
    private JLabel labelListImg[] = new JLabel[10];
    private JLabel labelListQuantity[] = new JLabel[10];
    private JButton buttonListLess[]=new JButton[10];
    private JButton buttonListAdd[] = new JButton[10];
    private JButton nextButton = new JButton();
    private ImageIcon imageList[]=new ImageIcon[4];
    private ImageIcon imgList[] = new ImageIcon[10];
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
    private Method m=new Method();
    
    public SingleOrdering(Payable p){
        this.p = p;
        for(int i = 0 ; i < 10; i++){
            this.labelListImg[i] = new JLabel();
            this.labelListQuantity[i]=new JLabel("0",SwingConstants.CENTER);
            this.buttonListAdd[i] = new JButton();
            this.buttonListLess[i]=new JButton();
            this.imgList[i] = new ImageIcon(SingleOrdering.class.getResource(foodList[i].getImgPath()));
        }
        imageList[0]=new ImageIcon(SingleOrdering.class.getResource("picture/check.png"));
        imageList[1]=new ImageIcon(SingleOrdering.class.getResource("picture/set.png"));
        imageList[2]=new ImageIcon(SingleOrdering.class.getResource("picture/add.png"));
        imageList[3]=new ImageIcon(SingleOrdering.class.getResource("picture/minus.png"));
        setFrame();
    }
    private void setFrame(){
        this.setSize(916,730);
        this.setLocation(0,0);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("���I");
        cp = this.getContentPane();
        cp.setLayout(null);
        

        m.addTitle(cp,"����",0,0,120,30,15);
        m.addTitle(cp,"�Ϥ�",120,0,60,30,15);
        m.addTitle(cp,"����",180,0,120,30,15);
        m.addTitle(cp,"����",300,0,120,30,15);
        m.addTitle(cp,"���O",420,0,120,30,15);
        m.addTitle(cp,"�\�I�Ӽ�",540,0,120,30,15);
        m.addTitle(cp,"�I�\",660,0,240,30,15);
        for(int i = 0 ; i < 10 ; i++){
            m.addTitle(cp,(i+1)+"."+foodList[i].getName(),0,30+(60*i),120,60,15);
            m.addImg(cp,labelListImg[i],imgList[i],120,30+(60*i),60,60);
            m.addTitle(cp,""+foodList[i].getPrice(),180,30+(60*i),120,60,15);
            m.addTitle(cp,foodList[i].getType(),300,30+(60*i),120,60,15);
            m.addTitle(cp,i==6?"���\":"�D���\",420,30+(60*i),120,60,15);
            m.addLabel(cp,labelListQuantity[i],540,30+(60*i),120,60,15);
            if(i == 6){
                if(checkTime() == true){
                    m.addImgButton(imageList[2],cp,buttonListAdd[i],660,30+(60*i),120,60);
                    m.lessImgButton(imageList[3],cp,buttonListLess[i],780,30+(60*i),120,60);
                    addQuantity(i);
                    lessQuantity(i);
                }
                else{m.addTitle(cp,"�{�b�D���\�ɶ�",660,390,240,60,15);}
            }
            else{
                m.addImgButton(imageList[2],cp,buttonListAdd[i],660,30+(60*i),120,60);
                m.lessImgButton(imageList[3],cp,buttonListLess[i],780,30+(60*i),120,60);
                addQuantity(i);
                lessQuantity(i);
            }
        }
        
        nextButton.setFont(new java.awt.Font("�L�n������", 0, 36));
        nextButton.setText("�U�@�B");
        nextButton.setBounds(0,630,914,61);
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
        for(int i = 0;i < 10;i++){
            int temp = 0;
            temp = p.getFood(i).getQuantity() + this.foodList[i].getQuantity();
            p.getFood(i).setQuantity(temp);
        }
        close();
        StartOrdering s = new StartOrdering(p);
        s.setVisible(true);
    }    
    public void addQuantity(int i){
        buttonListAdd[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                foodList[i].incrementQuant();
                if(foodList[i].getQuantity()>0){
                    buttonListLess[i].setEnabled(true);
                }
                labelListQuantity[i].setText(Integer.toString(foodList[i].getQuantity()));
            }
        });
    }
  
    public void lessQuantity(int i){
        buttonListLess[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                if(foodList[i].getQuantity()>0){
                    foodList[i].decrementQuant();
                }
                if(foodList[i].getQuantity()==0){
                    buttonListLess[i].setEnabled(false);
                }
                labelListQuantity[i].setText(Integer.toString(foodList[i].getQuantity()));
            }
        });
    }
    
    public void close(){
	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    public boolean checkTime(){
        boolean breakfastTime = true;
        DateFormat dfh = new SimpleDateFormat("HH");
        DateFormat dfm = new SimpleDateFormat("mm");
        int h = Integer.parseInt(dfh.format(d));
        int m = Integer.parseInt(dfm.format(d));
        if(6 <= h && h <= 10){
            if(h == 10){
                if(m <= 30){
                    breakfastTime = true;
                }
                else{breakfastTime = false;}
            }
            else{breakfastTime = true;}
        }
        else{
            breakfastTime = false;
        }
        return breakfastTime;
    }
}