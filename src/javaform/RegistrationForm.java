import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Myframe extends JFrame  {
    JLabel name, branch, dob, gender, submit;
    JTextField nm, br;
    JComboBox day, month, year;
    JRadioButton male, female;
    JButton sbmt;
    JTable table;
    JScrollPane jcp;

    Connection con = null;
    PreparedStatement st = null;




    Myframe(){
        setTitle("Registration from");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(null);

        name = new JLabel("Name");
        name.setBounds(20,50,100,20);
        c.add(name);
        
        nm = new JTextField();
        nm.setBounds(130,50,100,20);
        c.add(nm);
        
        branch = new JLabel("Branch");
        branch.setBounds(300,50,100,20);
        c.add(branch);
        
        br = new JTextField();
        br.setBounds(410,50,100,20);
        c.add(br);
        
        dob = new JLabel("DOB");
        dob.setBounds(20,100,100,20);
        c.add(dob);

        String days[] = {"1","2","3","4"};
        day = new JComboBox<>(days);
        day.setBounds(130,100,40,20);
        c.add(day);

        String months[] = {"jan","feb","mar","apr"};
        month = new JComboBox<>(months);
        month.setBounds(180,100,70,20);
        c.add(month);

        String years[] = {"1995","1996","1997","1998","1999","2000","2001"};
        year = new JComboBox<>(years);
        year.setBounds(260,100,70,20);
        c.add(year);

        gender = new JLabel("Gender");
        gender.setBounds(20,150,100,20);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(130,150,70,20);
        c.add(male);

        female = new JRadioButton("Female");
        female.setBounds(240,150,70,20);
        c.add(female);

        
        

        table = new JTable();
        table.setModel(new DefaultTableModel(new String[][] {{"","",""},{"","",""},{"","",""}},new String[]  {"Subject", "MM","Marks"}));
        jcp = new JScrollPane();
        jcp.setViewportView(table);
        jcp.setBounds(20, 200, 500, 200);
        c.add(jcp);

        sbmt = new JButton("Register");
        sbmt.setBounds(20,410,100,20);
        c.add(sbmt);

        sbmt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                registerActionPerformed(evt);
            }
        });

        setVisible(true);
    }


    private void registerActionPerformed(ActionEvent evt){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/newjava","root","");
            String query = "INSERT INTO student VALUES (?,?,?,?)";
            st = con.prepareStatement(query);
            st.setInt(1,0);
            st.setString(2,nm.getText());
            st.setString(3,br.getText());
            st.setString(4,day.getSelectedItem().toString() +month.getSelectedItem().toString()+year.getSelectedItem().toString());
            st.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}

class RegistrationForm{
    public static void main(String args[]){
        Myframe frame =  new Myframe();
    }
}
