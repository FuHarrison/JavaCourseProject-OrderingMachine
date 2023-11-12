
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StartOrdering extends javax.swing.JFrame {

    private Payable p = new Payable();
    private Date d = new Date();


    
    public StartOrdering(Payable p) {
        this.p = p;
        initComponents();
        AddMeal();
    }
    private void initComponents() {

        toSingleButton = new javax.swing.JButton();
        toSetButton = new javax.swing.JButton();
        toSelfButton = new javax.swing.JButton();
        CheckoutButton = new javax.swing.JButton();
        MealScrollPane = new javax.swing.JScrollPane();
        MealTable = new javax.swing.JTable();
        ResetButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PaymentLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("速食點餐機");

        toSingleButton.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        toSingleButton.setText("單點");
        toSingleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSingleButtonActionPerformed(evt);
            }
        });

        toSetButton.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        toSetButton.setText("指定套餐");
        toSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSetButtonActionPerformed(evt);
            }
        });

        toSelfButton.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        toSelfButton.setText("自選套餐");
        toSelfButton.setToolTipText("");
        toSelfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSelfButtonActionPerformed(evt);
            }
        });

        CheckoutButton.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        CheckoutButton.setText("結帳");
        CheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutButtonActionPerformed(evt);
            }
        });

        MealTable.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        MealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "方案", "編號", "名稱", "數量", "價格"
            }
        ));
        MealScrollPane.setViewportView(MealTable);

        ResetButton.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        ResetButton.setText("全部清空");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        RemoveButton.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        RemoveButton.setText("刪除餐點");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("     總價:");

        PaymentLabel.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        PaymentLabel.setForeground(new java.awt.Color(255, 0, 0));
        PaymentLabel.setText(String.valueOf(p.TotalPay()));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        jLabel2.setText("#早餐供應時間為每天早上6:00~10:30現在時間為:");

        TimeLabel.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        TimeLabel.setText(printTime());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(toSetButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(toSingleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toSelfButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CheckoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(310, Short.MAX_VALUE)
                    .addComponent(MealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(308, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toSingleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toSelfButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addComponent(MealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(140, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(423, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toSingleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSingleButtonActionPerformed
        close();
        SingleOrdering s = new SingleOrdering(p);
        s.setVisible(true);
    }//GEN-LAST:event_toSingleButtonActionPerformed

    private void toSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSetButtonActionPerformed
        close();
        SetOrdering s = new SetOrdering(p);
        s.setVisible(true);
    }//GEN-LAST:event_toSetButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        int rowCount = MealTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel)MealTable.getModel()).removeRow(i);
        }
        p.resetAll();
        PaymentLabel.setText(String.valueOf(p.TotalPay()));
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        int getSelectedRowForDeletion = MealTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)MealTable.getModel();
        
        if(getSelectedRowForDeletion >= 0){
            if((MealTable.getModel().getValueAt(MealTable.getSelectedRow(),0)).equals("單點") ){
                p.getFood(((int) MealTable.getModel().getValueAt(MealTable.getSelectedRow(),1))-1).setQuantity(0);
            }
            if((MealTable.getModel().getValueAt(MealTable.getSelectedRow(),0)).equals("指定套餐") ){
                String t = (String) MealTable.getModel().getValueAt(MealTable.getSelectedRow(),1);
                int k = 0;
                if(t.equals("A")){k = 0;}
                if(t.equals("B")){k = 1;}
                if(t.equals("C")){k = 2;}
                if(t.equals("D")){k = 3;}
                if(t.equals("E")){k = 4;}
                p.getSet(k).setQuantity(0);
            }
            if((MealTable.getModel().getValueAt(MealTable.getSelectedRow(),0)).equals("自選套餐") ){
                String temp = (String) MealTable.getModel().getValueAt(MealTable.getSelectedRow(),1);
                int t = Integer.parseInt(temp.substring(temp.length()-1));
                p.setSelf(t-1,null);
            }
            model.removeRow(getSelectedRowForDeletion);
            PaymentLabel.setText(String.valueOf(p.TotalPay()));
        }
        else{
            JOptionPane.showMessageDialog(null,"請選擇要刪除的餐點");
        }
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void toSelfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSelfButtonActionPerformed
        close();
        SelfSetOrdering s = new SelfSetOrdering(p);
        s.setVisible(true);
    }//GEN-LAST:event_toSelfButtonActionPerformed

    private void CheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutButtonActionPerformed
        close();
        Payment s = new Payment(p);
        s.setVisible(true);
    }//GEN-LAST:event_CheckoutButtonActionPerformed

    public static void AddRowToJTable(Object[] dataRow){
        DefaultTableModel model = (DefaultTableModel)MealTable.getModel();
        model.addRow(dataRow);
    }
    
    public void AddMeal(){
        for(int i = 0;i < 10;i++){
            if(p.getFood(i).getQuantity() != 0){
                AddRowToJTable(new Object[]{
                    "單點",
                    (i+1),
                    p.getFood(i).getName(),
                    p.getFood(i).getQuantity(),
                    p.getFood(i).getQuantity() * p.getFood(i).getPrice()
                });
            }
        }
        for(int i = 0;i < 5;i++){
            if(p.getSet(i).getQuantity() != 0){
                AddRowToJTable(new Object[]{
                    "指定套餐",
                    p.getSet(i).getMealId(),
                    p.getSet(i).getMealName(),
                    p.getSet(i).getQuantity(),
                    p.getSet(i).getQuantity() * p.getSet(i).getMealPrice()
                });
            }
        }
        for(int i = 0;i < 100;i++){
            if(p.getSelf(i) != null){
                AddRowToJTable(new Object[]{
                    "自選套餐",
                    p.getSelf(i).getId(),
                    p.getSelf(i).getName(),
                    1,
                    p.getSelf(i).getPrice()
                });
            }
        }
    }

    public String printTime(){
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(d);
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
