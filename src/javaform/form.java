import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form extends JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    int lasts_id;
    ResultSet rs = null;

    public form() {
        initComponents();
    }
    
    private void initComponents() {
        fnamelabel = new JLabel("First Name");
        txtfname = new JTextField();
        lnamelabel = new JLabel("Last Name");
        txtlname = new JTextField();
        doblabel = new JLabel("DOB");
        dob = new JTextField();
        genderlabel = new JLabel("Gender");
        cmbgender = new JComboBox<>();
        addresslabel = new JLabel("Address");
        txtaddress = new JTextField();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        search = new JButton("Search");
        register = new JButton("Register");
        reset = new JButton("Reset");

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        cmbgender.setModel(new DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subject", "Marks", "MM"
            }
        ));
        jScrollPane1.setViewportView(table);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reset)
                        .addGap(54, 54, 54)
                        .addComponent(register))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(doblabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(94, 94, 94)
                                                    .addComponent(lnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(search)
                                                .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnamelabel)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doblabel)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderlabel)
                    .addComponent(cmbgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addresslabel)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register)
                    .addComponent(reset))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }

    private void registerActionPerformed(ActionEvent evt) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/javaform","root","");
            String query = "INSERT INTO `form`(`s_id`,`fname`, `lname`, `DOB`, `gender`, `Address`) VALUES (?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            String query1 = "select max(s_id) from form";
            rs=pst.executeQuery(query1);
            if(rs.next()){
                lasts_id = rs.getInt(1);
                lasts_id++;
            }
            pst.setInt(1, lasts_id);
            pst.setString(2, txtfname.getText());
            pst.setString(3, txtlname.getText());
            pst.setString(4,dob.getText());
            pst.setString(5, cmbgender.getSelectedItem().toString());
            pst.setString(6, txtaddress.getText());
            pst.executeUpdate();
            
            String query2 = "INSERT INTO `subject`(`s_id`, `subject`, `marks`, `mm`, `percentage`) VALUES (?,?,?,?,?)";
            pst=con.prepareStatement(query2);
            int i=0;
            while(i<table.getRowCount()){
                try{
                    pst.setInt(1, lasts_id);
                    pst.setString(2, table.getValueAt(i, 0).toString());

                    int marks = Integer.parseInt(table.getValueAt(i, 1).toString());
                    pst.setInt(3, marks);

                    int mm = Integer.parseInt(table.getValueAt(i, 2).toString());
                    pst.setInt(4, mm);

                    float percentage= ((float)marks/mm)*100;
                    pst.setFloat(5, percentage);
                    pst.executeUpdate();
                    i++;
                }catch(NullPointerException e){
                    break;
                }
            }
            resetActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Register succesfully");
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        
        
        }
    }

    private void resetActionPerformed(ActionEvent evt) {
        txtfname.setText("");
        txtlname.setText("");
        dob.setText("");
        cmbgender.setSelectedIndex(0);
        txtaddress.setText("");
        for(int i=0;i<table.getRowCount();i++){
            table.setValueAt("", i, 0);
            table.setValueAt(null, i, 1);
            table.setValueAt(null, i, 2);
        }
    }

    private void searchActionPerformed(ActionEvent evt) {
        String fn = txtfname.getText();
        try{
            String query3 = "SELECT * from form f left join subject s ON s.s_id = f.s_id where f.fname=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/javaform","root","");
            pst = con.prepareStatement(query3);
            pst.setString(1, fn);
            rs = pst.executeQuery();
            int i = 0;
            while(rs.next()){
            txtfname.setText(rs.getString("fname"));
            txtlname.setText(rs.getString("lname"));
            dob.setText(rs.getString("DOB"));
            cmbgender.setSelectedItem(rs.getString("gender"));
            txtaddress.setText(rs.getString("Address"));
            table.setValueAt(rs.getString("subject"), i, 0);
            table.setValueAt(rs.getInt("marks"), i, 1);
            table.setValueAt(rs.getInt("mm"), i, 2);
            i++;
            }
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
          }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

 
    private JLabel addresslabel;
    private JComboBox<String> cmbgender;
    private JTextField dob;
    private JLabel doblabel;
    private JLabel fnamelabel;
    private JLabel genderlabel;
    private JScrollPane jScrollPane1;
    private JLabel lnamelabel;
    public JButton register;
    public JButton reset;
    public JButton search;
    private JTable table;
    private JTextField txtaddress;
    private JTextField txtfname;
    private JTextField txtlname;
}

