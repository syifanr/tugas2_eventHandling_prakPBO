/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_123220194;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class loginPage extends JFrame implements ActionListener{

    JLabel salam = new JLabel("Selamat Datang️!");
    
    JLabel kalimatBuka = new JLabel ("Silakan masuk untuk melanjutkan.");
    
    JTextField inputUsername = new JTextField();
    
    JLabel labelInputUsername = new JLabel("Username");
    
    JTextField inputPassword = new JTextField();
    
    JLabel labelInputPassword = new JLabel ("Password");
    
    JLabel labelInputJK = new JLabel ("Jenis Kelamin");
    
    JRadioButton pilihlaki = new JRadioButton ("Laki-laki");
    JRadioButton pilihperempuan = new JRadioButton ("Perempuan");
    
    JButton tombolLogin = new JButton("Login");
    
    loginPage(){
        setVisible(true);
        setSize(710, 500);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        add(salam);
        salam.setBounds(20, 10, 250, 24);
        salam.setFont(new Font("Arial", Font.BOLD, 20));
        
        add(kalimatBuka);
        kalimatBuka.setBounds(20, 25, 250, 30);
                
        add (labelInputUsername);
        labelInputUsername.setBounds(20, 60, 100, 24);
        
        add(inputUsername);
        inputUsername.setBounds(20, 90, 650, 24);
        
        
        ButtonGroup pilihJenisKelamin = new ButtonGroup();
        pilihJenisKelamin.add(pilihlaki);
        pilihJenisKelamin.add(pilihperempuan);
        
        add (labelInputPassword);
        labelInputPassword.setBounds(20, 120, 100, 24);
        
        add (inputPassword);
        inputPassword.setBounds(20, 140, 650, 24);
        
        
        add (labelInputJK);
        labelInputJK.setBounds(20, 170, 100, 24);
        
        add (pilihlaki);
        pilihlaki.setBounds (20, 190, 100, 32);
        
        add (pilihperempuan);
        pilihperempuan.setBounds (300, 190, 100, 32);
        
        add(tombolLogin);
        tombolLogin.setBounds(20, 240, 650, 24);
        tombolLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            String jenisKelamin = "";
            
            if (pilihlaki.isSelected()){
                jenisKelamin = "l";
            }else if(pilihperempuan.isSelected()) {
                jenisKelamin = "p";
            }
            
            if (username.isEmpty()|| password.isEmpty () || jenisKelamin.isEmpty ()){
                throw new Exception("Tidak boleh kosong!");
            }
            
            new halamanUtama(username, jenisKelamin);
            this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
  }
}
        
//        if (pilihlaki.isSelected()){
//            jenisKelamin = "l";
//        }else{
//            jenisKelamin = "p";
//        }
        
  