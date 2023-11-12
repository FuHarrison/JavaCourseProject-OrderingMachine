import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Payment extends javax.swing.JFrame {

    private Payable p = new Payable();
    private Payable newP = new Payable();
    private javax.swing.JScrollPane MealScrollPane;
    private static javax.swing.JTable MealTable;
    private javax.swing.JLabel PaymentLabel;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel jLabel1;

    public Payment(Payable p) {
        this.p = p;
        initComponents();
        AddMeal();
    }
    

    private void initComponents() {

        MealScrollPane = new javax.swing.JScrollPane();
        MealTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        PaymentLabel = new javax.swing.JLabel();
        continueButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("消費明細");

        MealTable.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        MealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "方案", "編號", "名稱", "數量", "價格"
            }
        ));
        MealScrollPane.setViewportView(MealTable);

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("     總價:");

        PaymentLabel.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        PaymentLabel.setForeground(new java.awt.Color(255, 0, 0));
        PaymentLabel.setText(String.valueOf(p.TotalPay()));

        continueButton.setFont(new java.awt.Font("微軟正黑體", 0, 36)); // NOI18N
        continueButton.setText("繼續");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(continueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(MealScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        int nextG = 0;
        nextG = JOptionPane.showConfirmDialog(null,"換下一位點餐?");
        switch(nextG){
            case 0:
                close();
                StartOrdering s = new StartOrdering(newP);
                s.setVisible(true);
                break;
            case 1:
                close();
                break;
        }
    }//GEN-LAST:event_continueButtonActionPerformed
    
    public void close(){
	WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
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
    
    public void AddRowToJTable(Object[] dataRow){
        DefaultTableModel model = (DefaultTableModel)MealTable.getModel();
        model.addRow(dataRow);
    }
}
