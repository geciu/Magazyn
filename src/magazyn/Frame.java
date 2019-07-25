package magazyn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Frame extends JFrame implements ActionListener {

    private JPanel panel;
    JLabel tekst;
    JTextArea nazwa, ilosc, polozenie;
    JButton bZapis, bWyjscie;
    PrintWriter zapis;
    String sNazwa, sIlosc, sPolozenie;
    JMenuBar menuBar;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOpcja2, mOProgramie;

    int width = getWidth()/2;
    int height = getHeight()/2;
    int index = 1;

    File plik;

    public Frame() throws FileNotFoundException {
        super("Magazyn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(width,height,800,270);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        tekst = new JLabel("Witamy w Twoim magazynie");
        tekst.setBounds(10, 10, 400, 25);
        tekst.setFont(new Font("Courier New", (Font.BOLD | Font.ITALIC), 15));
        tekst.setForeground(Color.GRAY.darker());
        panel.add(tekst);

        nazwa = new JTextArea();
        nazwa.setBounds(10,45,150,20);
        panel.add(nazwa);

        ilosc = new JTextArea();
        ilosc.setBounds(10,75,150,20);
        panel.add(ilosc);

        polozenie = new JTextArea();
        polozenie.setBounds(10,105,150,20);
        panel.add(polozenie);

        bZapis = new JButton("Zapisz przedmiot");
        bZapis.setBounds(10,135,150,25);
        panel.add(bZapis);
        bZapis.addActionListener(this);

        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(10,170,150,25);
        panel.add(bWyjscie);
        bWyjscie.addActionListener(this);

        menuBar = new JMenuBar();

        menuPlik = new JMenu("Plik");
        mOtworz = new JMenuItem("Otwórz");
        menuPlik.add(mOtworz);
        mZapisz = new JMenuItem("Zapisz");
        mZapisz.addActionListener(this);
        menuPlik.add(mZapisz);
        mWyjscie = new JMenuItem("Wyjście");
        mWyjscie.addActionListener(this);
        menuPlik.add(mWyjscie);

        menuNarzedzia = new JMenu("Narzedzia");
        mNarz1 = new JMenuItem("Narzędzia 1");
        menuNarzedzia.add(mNarz1);
        mNarz2 = new JMenuItem("Narzedzia 2");
        menuNarzedzia.add(mNarz2);
            menuOpcje = new JMenu("Opcje");
            mOpcja1 = new JMenuItem("Opcja 1");
            menuOpcje.add(mOpcja1);
            mOpcja2 = new JMenuItem("Opcja 2");
            menuOpcje.add(mOpcja2);
        menuNarzedzia.add(menuOpcje);

        menuPomoc = new JMenu("Pomoc");
        mOProgramie = new JMenuItem("O programie");
        mOProgramie.addActionListener(this);
        menuPomoc.add(mOProgramie);

        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == bZapis || source == mZapisz) {
            zapis.close();
            System.out.println(sNazwa);
        }
        if(source == bWyjscie || source ==  mWyjscie){
            dispose();
            System.out.println("Zamkniecie okna");
        }
        if(source == mOProgramie){
            JOptionPane.showMessageDialog(this, "To okno wyświetla pomoc dla klientów");
        }
    }
}
