import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Method{
    private Container cp;
    public void addLabel(Container cp,JLabel label,int x,int y,int width,int height,int size){
        label.setBounds(x,y,width,height);
        label.setFont(new Font("微軟正黑體",Font.PLAIN,size));
        label.setBorder(BorderFactory.createEtchedBorder());
        cp.add(label);
    }
    public void addTitle(Container cp,String a,int x,int y,int width,int height,int size){
        JLabel label=new JLabel(a,SwingConstants.CENTER);
        label.setBounds(x,y,width,height);
        label.setFont(new Font("微軟正黑體",Font.PLAIN,size));
        label.setBorder(BorderFactory.createEtchedBorder());
        cp.add(label);
    }
    public void addImg(Container cp,JLabel label,ImageIcon image,int x,int y,int width,int height){
        label.setIcon(image);
        label.setBounds(x,y,width,height);
        cp.add(label);
    }
    public void addImgButton(ImageIcon image,Container cp,JButton button,int x,int y,int width,int height){
        button.setBounds(x,y,width,height);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setIcon(image);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        cp.add(button);
    }
    public void lessImgButton(ImageIcon image,Container cp,JButton button,int x,int y,int width,int height){
        button.setBounds(x,y,width,height);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setIcon(image);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        cp.add(button);
        button.setEnabled(false);
    }
}