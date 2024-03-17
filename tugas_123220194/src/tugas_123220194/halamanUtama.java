/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_123220194;

import bangunDatar.persegi;
import bangunRuang.balok;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class halamanUtama extends JFrame implements ActionListener {

    JLabel welcome = new JLabel();

    JLabel kata = new JLabel("Tentukan panjang, lebar, dan tinggi untuk menghitung Balok");

    JTextField inputPanjang = new JTextField();

    JLabel labelInputPanjang = new JLabel("Panjang");

    JTextField inputLebar = new JTextField();

    JLabel labelInputLebar = new JLabel("Lebar");

    JLabel labelInputTinggi = new JLabel("Tinggi");

    JTextField inputTinggi = new JTextField();

    JButton tombolHitung = new JButton("Hitung");

    JButton tombolReset = new JButton("Reset");

    JLabel hasil = new JLabel("Hasil");

    JLabel luasPersegi = new JLabel("Luas Persegi");
    JLabel hasilluasPersegi = new JLabel("[Hasil berupa angka]");

    JLabel kelilingPersegi = new JLabel("Keliling Persegi");
    JLabel hasilkelilingPersegi = new JLabel("[Hasil berupa angka]");

    JLabel volumeBalok = new JLabel("Volume Balok");
    JLabel hasilvolumeBalok = new JLabel("[Hasil berupa angka]");

    JLabel luaspBalok = new JLabel("Luas Permukaan Balok");
    JLabel hasilluaspBalok = new JLabel("[Hasil berupa angka]");

    halamanUtama(String username, String jenisKelamin) {
        String panggilan = (jenisKelamin == "l") ? "Mr. " : "Mrs.";

        setVisible(true);
        setSize(710, 500);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        add(welcome);
        welcome.setText("Welcome, " + panggilan + username);
        welcome.setBounds(20, 10, 350, 40);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));

        add(kata);
        kata.setBounds(20, 30, 500, 40);

        add(labelInputPanjang);
        labelInputPanjang.setBounds(20, 80, 80, 24);

        add(inputPanjang);
        inputPanjang.setBounds(150, 80, 520, 24);

        add(labelInputLebar);
        labelInputLebar.setBounds(20, 120, 80, 24);

        add(inputLebar);
        inputLebar.setBounds(150, 120, 520, 24);

        add(labelInputTinggi);
        labelInputTinggi.setBounds(20, 160, 80, 24);

        add(inputTinggi);
        inputTinggi.setBounds(150, 160, 520, 24);

        add(tombolHitung);
        tombolHitung.setBounds(20, 200, 650, 24);

        add(tombolReset);
        tombolReset.setBounds(20, 235, 650, 24);

        add(hasil);
        hasil.setHorizontalAlignment(SwingConstants.CENTER);
        hasil.setBounds(330, 270, 50, 24);

        add(luasPersegi);
        luasPersegi.setBounds(20, 300, 100, 24);

        add(hasilluasPersegi);
        hasilluasPersegi.setBounds(270, 300, 130, 24);

        add(kelilingPersegi);
        kelilingPersegi.setBounds(20, 330, 100, 24);

        add(hasilkelilingPersegi);
        hasilkelilingPersegi.setBounds(270, 330, 130, 24);

        add(volumeBalok);
        volumeBalok.setBounds(20, 360, 100, 24);

        add(hasilvolumeBalok);
        hasilvolumeBalok.setBounds(270, 360, 130, 24);

        add(luaspBalok);
        luaspBalok.setBounds(20, 390, 150, 24);

        add(hasilluaspBalok);
        hasilluaspBalok.setBounds(270, 390, 130, 24);

        tombolHitung.addActionListener(this);
        tombolReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == tombolHitung) {
                String strpanjang = inputPanjang.getText();
                String strlebar = inputLebar.getText();
                String strtinggi = inputTinggi.getText();

                if (strpanjang.isEmpty() || strlebar.isEmpty() || strtinggi.isEmpty()) {
                    throw new Exception("Tidak boleh kosong!");
                }

                double panjang = Double.parseDouble(inputPanjang.getText());
                double lebar = Double.parseDouble(inputLebar.getText());
                double tinggi = Double.parseDouble(inputTinggi.getText());

                persegi bangun1 = new persegi(panjang, lebar);
                balok bangun2 = new balok(panjang, lebar, tinggi);

                String hasilluas = String.valueOf(bangun1.Luas());
                String hasilkeliling = String.valueOf(bangun1.Keliling());

                String hasilvolume = String.valueOf(bangun2.Volume());
                String hasilluasp = String.valueOf(bangun2.LuasPermukaan());

                hasilluasPersegi.setText(hasilluas);
                hasilkelilingPersegi.setText(hasilkeliling);
                hasilvolumeBalok.setText(hasilvolume);
                hasilluaspBalok.setText(hasilluasp);

            } else if (e.getSource() == tombolReset) {
                inputPanjang.setText("");
                inputLebar.setText("");
                inputTinggi.setText("");

                hasilluasPersegi.setText("[Hasil berupa angka]");
                hasilkelilingPersegi.setText("[Hasil berupa angka]");
                hasilvolumeBalok.setText("[Hasil berupa angka]");
                hasilluaspBalok.setText("[Hasil berupa angka]");

                add(hasilluasPersegi);
                add(hasilkelilingPersegi);
                add(hasilvolumeBalok);
                add(hasilluaspBalok);

                revalidate();
                repaint();
            }
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Masukkan Angka yang Benar!");

            hasilluasPersegi.setText("[Hasil berupa angka]");
            hasilkelilingPersegi.setText("[Hasil berupa angka]");
            hasilvolumeBalok.setText("[Hasil berupa angka]");
            hasilluaspBalok.setText("[Hasil berupa angka]");

            add(hasilluasPersegi);
            add(hasilkelilingPersegi);
            add(hasilvolumeBalok);
            add(hasilluaspBalok);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

    }

    private static class SwingConstants {

        private static int CENTER;

        public SwingConstants() {
        }
    }
}
