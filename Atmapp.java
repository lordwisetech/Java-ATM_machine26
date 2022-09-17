import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.*;

public class Atmapp extends JFrame{
    private JPanel whitdrawpanel;
    private JPanel depositpanel;
    private JPanel checkballpanel;
    private JPanel transferpanel;
    private JTextField depositfield,whitdrawfield;
    private JLabel result;
    JLabel label3;
    JButton depbtn;
    JLabel transfersucess , hint;
    Font myfont = new Font("ink free",Font.BOLD,20);
    
    double ballance = 0 ,whitdrawal,deposit,transfer;
    
    
    public Atmapp(){

        //deposit panel
        JPanel depositpanel = new JPanel();
        depositpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        depositpanel.setBackground(Color.green);

        JTextField depositfield = new JTextField();
        depositfield.setColumns(20);
        JButton depbtn = new JButton("deposit");
        JLabel label0 = new JLabel("Enter the Amount :");
        JLabel result = new JLabel();

        depositpanel.add(label0);
        depositpanel.add(depositfield);
        depositpanel.add(depbtn);
        depositpanel.add(result);
        
       depbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   String getdept = depositfield.getText();
                    double parsdept = Double.parseDouble(getdept);
                    deposit = parsdept;
                    ballance = parsdept + ballance;
                    depositfield.setText(null);
                    Date date = new Date();
                    result.setText("you have sucesfully deposit :$"+ parsdept + " on " + date);
                    result.setFont(myfont);
    
                   //System.out.println("deposit " + parsdept + "my ballance "  + ballance);
                }
            }); 

        // whitdraw panel
        JPanel whitdrawpanel = new JPanel();
        whitdrawpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        whitdrawpanel.setBackground(Color.green);
        JTextField whitdrawfield = new JTextField();
        whitdrawfield.setColumns(20);
        JButton whitbtn = new JButton("Whitdraw");
        JLabel message = new JLabel("Enter the Amount :");
        JLabel Message = new JLabel("");

        whitdrawpanel.add(message);
        whitdrawpanel.add(whitdrawfield);
        whitdrawpanel.add(whitbtn);
        whitdrawpanel.add(Message);
        whitbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String getwhitdrawamount = whitdrawfield.getText();
                double parsewhitdrawaamount = Double.parseDouble(getwhitdrawamount);
                if (ballance >= parsewhitdrawaamount){
                    whitdrawal = parsewhitdrawaamount;
                    ballance = whitdrawal - ballance;
                    whitdrawfield.setText(null);
                    Date date = new Date();
                    Message.setText("you have sucesfully whitdraw :$"+ whitdrawal + " from your account on "+ date);
                    Message.setFont(myfont);
                }else{
                    Message.setText("hoops you dont have such amount, your ballance is :$"+ ballance);
                    Message.setFont(myfont);
                }
                
            }
        });
        
        // transfer panel
        JPanel transferpanel = new JPanel();
        transferpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        transferpanel.setBackground(Color.gray);
        
        JLabel label2 = new JLabel("Enter amount :");
        JLabel acc = new JLabel("account no :");
        
        JTextField transferfield = new JTextField();
        transferfield.setColumns(10);
        transfersucess= new JLabel();
        JTextField bankfield = new JTextField();
        bankfield.setColumns(20);
        hint = new JLabel();
        JButton pay = new JButton("Transfer");
        transferpanel.add(label2);
        transferpanel.add(transferfield);
        transferpanel.add(acc);
        transferpanel.add(bankfield);
        transferpanel.add(pay);
        transferpanel.add(transfersucess);
        transferpanel.add(hint);
        pay.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                String getamount = transferfield.getText();
                double parseamount = Double.parseDouble(getamount);
                
                String bank = bankfield.getText();
                transfer = parseamount;
                if (ballance >= transfer){
                    ballance = transfer - ballance;
                    whitdrawfield.setText(null);
                    Date date = new Date();
                 transfersucess.setText("you have sucesfully transfer :$"+ transfer + " from your account on "+ date +" to "+ bank);
                   hint.setText(null);
                    Message.setFont(myfont);
                }else{
                    transfersucess.setText("hoops transaction not successful");
                    hint.setText("Hint : Your Ballance is less than your transfer amount, : Account No field is empty");
                   transfersucess.setFont(myfont);
                    
                   
                }
                
                
                
            }
        });

        
        
        //check balance panel
        JPanel checkballpanel = new JPanel();
        checkballpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkballpanel.setBackground(Color.pink);
        JLabel label3 = new JLabel("0");
        JButton check = new JButton("check");

        checkballpanel.add(check);
        checkballpanel.add(label3);
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
              label3.setText("your ballance is :$" + ballance);
              label3.setFont(myfont);
              
            }
        });

        // tabe main view

        JTabbedPane table = new JTabbedPane();
        table.add("Deposit",depositpanel);
        table.add("Whitdraw", whitdrawpanel);
        table.add("Check Ballance", checkballpanel);
        table.add("Make Transfer",transferpanel);

        // jframe
        setSize(700,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ATM Machine");
        add(table);

    
    }
    
     
    
    public static void main (String[] args){
        new  Atmapp();
        
    }

}