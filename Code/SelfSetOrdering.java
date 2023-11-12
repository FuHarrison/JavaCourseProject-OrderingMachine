
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SelfSetOrdering extends javax.swing.JFrame {

    private Payable p = new Payable();
    private Date d = new Date();
    private javax.swing.JLabel DrinkLabel;
    private javax.swing.JPanel DrinkPanel;
    private javax.swing.JScrollPane DrinkScrollPane;
    private javax.swing.JTable DrinkTable;
    private javax.swing.JLabel LeadingLabel;
    private javax.swing.JLabel MainMealLabel;
    private javax.swing.JPanel MainMealPanel;
    private javax.swing.JScrollPane MainMealScrollPane;
    private javax.swing.JTable MainMealTable;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JLabel SubMealLabel;
    private javax.swing.JPanel SubMealPanel;
    private javax.swing.JScrollPane SubMealScrollPane;
    private javax.swing.JTable SubMealTable;
    private javax.swing.JButton nextButton;
    private Food MainMealList[] = {
        new Food("麥香雞",44,"主餐","picture/2.png",2),
        new Food("滿福堡",48,"主餐","picture/7.png",7),
        new Food("大麥克",72,"主餐","picture/9.png",9),
    };
    private Food SubMealList[]= {  
        new Food("薯條(小)",33,"副餐","picture/1.png",1),
        new Food("薯條(中)",44,"副餐","picture/5.png",5),
        new Food("薯餅",30,"副餐","picture/6.png",6),
        new Food("薯條(大)",55,"副餐","picture/8.png",8),
    };
    private Food DrinkList[] = {
        new Food("可樂(小)",28,"飲料","picture/3.png",3),
        new Food("雪碧(小)",28,"飲料","picture/4.png",4),
        new Food("玉米濃湯",40,"飲料","picture/10.png",10),
    };
    

    public SelfSetOrdering(Payable p) {
        initComponents();
        this.p = p;
        AddMeal();
    }

    private void initComponents() {

        MainMealPanel = new javax.swing.JPanel();
        MainMealScrollPane = new javax.swing.JScrollPane();
        MainMealTable = new javax.swing.JTable();
        MainMealLabel = new javax.swing.JLabel();
        SubMealPanel = new javax.swing.JPanel();
        SubMealScrollPane = new javax.swing.JScrollPane();
        SubMealTable = new javax.swing.JTable();
        SubMealLabel = new javax.swing.JLabel();
        DrinkPanel = new javax.swing.JPanel();
        DrinkScrollPane = new javax.swing.JScrollPane();
        DrinkTable = new javax.swing.JTable();
        DrinkLabel = new javax.swing.JLabel();
        LeadingLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        NoteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("自選套餐");

        MainMealPanel.setBackground(new java.awt.Color(255, 51, 51));

        MainMealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "編號", "餐點", "單價"
            }
        ));
        MainMealScrollPane.setViewportView(MainMealTable);

        MainMealLabel.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        MainMealLabel.setForeground(new java.awt.Color(255, 255, 0));
        MainMealLabel.setText("       主餐");

        javax.swing.GroupLayout MainMealPanelLayout = new javax.swing.GroupLayout(MainMealPanel);
        MainMealPanel.setLayout(MainMealPanelLayout);
        MainMealPanelLayout.setHorizontalGroup(
            MainMealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMealPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainMealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMealPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainMealLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        MainMealPanelLayout.setVerticalGroup(
            MainMealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainMealPanelLayout.createSequentialGroup()
                .addComponent(MainMealLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainMealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SubMealPanel.setBackground(new java.awt.Color(255, 255, 102));

        SubMealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "編號", "餐點", "單價"
            }
        ));
        SubMealScrollPane.setViewportView(SubMealTable);

        SubMealLabel.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        SubMealLabel.setForeground(new java.awt.Color(255, 0, 0));
        SubMealLabel.setText("       副餐");

        javax.swing.GroupLayout SubMealPanelLayout = new javax.swing.GroupLayout(SubMealPanel);
        SubMealPanel.setLayout(SubMealPanelLayout);
        SubMealPanelLayout.setHorizontalGroup(
            SubMealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubMealPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SubMealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SubMealPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(SubMealLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SubMealPanelLayout.setVerticalGroup(
            SubMealPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubMealPanelLayout.createSequentialGroup()
                .addComponent(SubMealLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubMealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DrinkPanel.setBackground(new java.awt.Color(255, 51, 51));

        DrinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "編號", "餐點", "單價"
            }
        ));
        DrinkScrollPane.setViewportView(DrinkTable);

        DrinkLabel.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        DrinkLabel.setForeground(new java.awt.Color(255, 255, 0));
        DrinkLabel.setText("       飲料");

        javax.swing.GroupLayout DrinkPanelLayout = new javax.swing.GroupLayout(DrinkPanel);
        DrinkPanel.setLayout(DrinkPanelLayout);
        DrinkPanelLayout.setHorizontalGroup(
            DrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DrinkPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DrinkScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(DrinkPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(DrinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DrinkPanelLayout.setVerticalGroup(
            DrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DrinkPanelLayout.createSequentialGroup()
                .addComponent(DrinkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DrinkScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LeadingLabel.setFont(new java.awt.Font("微軟正黑體", 0, 48)); // NOI18N
        LeadingLabel.setText("            請選擇您的餐點");

        nextButton.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        nextButton.setText("下一步");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        NoteLabel.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        NoteLabel.setText("#自選套餐的價格是原價打85折");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(LeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MainMealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubMealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DrinkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(LeadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DrinkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubMealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainMealPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if((MainMealTable.getSelectedRow() >= 0)&&(SubMealTable.getSelectedRow() >= 0)&&(DrinkTable.getSelectedRow() >= 0)){
            for(int i = 0;i < 100;i++){
                if(p.getSelf(i) == null){
                    SelfSetMeal temp = new SelfSetMeal(MainMealList[MainMealTable.getSelectedRow()],SubMealList[SubMealTable.getSelectedRow()],DrinkList[DrinkTable.getSelectedRow()],"S"+(i+1));
                    p.setSelf(i,temp);
                    break;
                }
                
            }
            close();
            StartOrdering s = new StartOrdering(p);
            s.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"請選擇你的餐點(主餐、副餐、飲料各選擇一樣)");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    public void AddMeal(){
        for(int i = 0;i < 3;i++){
            if(i == 1){
                if(checkTime() == true){
                    AddRowToJTable(new Object[]{
                        MainMealList[i].getId(),
                        MainMealList[i].getName(),
                        MainMealList[i].getPrice()
                    },MainMealTable);
                }
            }
            else{AddRowToJTable(new Object[]{
                    MainMealList[i].getId(),
                    MainMealList[i].getName(),
                    MainMealList[i].getPrice()
                },MainMealTable);
            }
        }
        for(int i = 0;i < 4;i++){
            AddRowToJTable(new Object[]{
                    SubMealList[i].getId(),
                    SubMealList[i].getName(),
                    SubMealList[i].getPrice()
            },SubMealTable);
        }
        for(int i = 0;i < 3;i++){
            AddRowToJTable(new Object[]{
                    DrinkList[i].getId(),
                    DrinkList[i].getName(),
                    DrinkList[i].getPrice()
            },DrinkTable);
        }
    }
    
    public static void AddRowToJTable(Object[] dataRow,JTable jTable){
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        model.addRow(dataRow);
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

    public void close(){
	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
