package test;

import java.awt.FlowLayout;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GalvenaDala {
	
	
	static String izvele(int sk, ArrayList<Jautajumi> jM, ImageIcon a){
		String[] atb = new String[4];
		atb[0]=jM.get(sk).getAtb1();
		atb[1]=jM.get(sk).getAtb2();
		atb[2]=jM.get(sk).getAtb3();
		atb[3]=jM.get(sk).getAtb4();
		String izveletais;
		if(a!=null) {
			izveletais = (String)JOptionPane.showInputDialog(null, jM.get(sk).getJautajums(), (sk+1)+".jautājums", JOptionPane.QUESTION_MESSAGE, a, atb, atb[0]);
		}else {
			izveletais = (String)JOptionPane.showInputDialog(null, jM.get(sk).getJautajums(), (sk+1)+".jautājums", JOptionPane.QUESTION_MESSAGE, null, atb, atb[0]);
		}
		return izveletais;
	}
	
	
	static void test(String[] pareizasAtbildes, ArrayList<Jautajumi> jM) {
		String atbilde = null;
		ImageIcon img3 = new ImageIcon("src/Kraine.png");
		ImageIcon img4 = new ImageIcon("src/Kraine_png4.png");
		ImageIcon imgNO = new ImageIcon("src/no.png");
		ImageIcon imgYES = new ImageIcon("src/yes.png");
		int noPirmaReizi = 0;
		for(int i=0; i<jM.size(); i++) {
			int meginajumi = 0;
			boolean vaiIrpareizi = false;
			while(vaiIrpareizi == false) {
				switch(i) {
				case 0: case 1: case 4: case 5: case 6: case 7: case 8: case 9: atbilde=izvele(i, jM, null); break;
				case 2: atbilde=izvele(i, jM, img3); break;
				case 3: atbilde=izvele(i, jM, img4); break;
				}
				if(atbilde==pareizasAtbildes[i]) {
					if(meginajumi==0) {
						noPirmaReizi++;
					}
					JOptionPane.showMessageDialog(null, imgYES);
					vaiIrpareizi=true;
				}else {
					JOptionPane.showMessageDialog(null, imgNO);
					meginajumi++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Jūsu pareizās atbildes pirmajā mēginājumā: "+noPirmaReizi);
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Jautajumi> jautajumiMasivs = new ArrayList<Jautajumi>();
		jautajumiMasivs.add(new Jautajumi("Vai var izmantot if bez else?", "Jā", "Nē", "Nezinu", "Visas atbildes ir pareizas"));
		jautajumiMasivs.add(new Jautajumi("Kur ir komandas, kam vajadzētu notikt,\nja nosacījums ir nepatiess sazarojumā konstrukcijā IF...else?", "Nekur", "Aiz if", "Aiz else", "Aiz switch"));
		jautajumiMasivs.add(new Jautajumi("Kur ir kļūda?", "Trūkst iekavās", "Nosacījumā", "Komandā", "Nav kļūdas"));
		jautajumiMasivs.add(new Jautajumi("Kur ir kļūda?", "Trūkst iekavās", "Nosacījumā", "Komandā", "Nav kļūdas"));
		jautajumiMasivs.add(new Jautajumi("Kāds ir paziņojuma if mērķis?", "Mainīgā deklarēšana", "Lai veikt ciklu", "Veikt darbību, pamatojoties uz nosacījumu", "Lai definētu klasi"));
		jautajumiMasivs.add(new Jautajumi("Kā pareizi jāraksta if...else konstrukciju?", "if(<nosacījums>) <komanda>; else <komanda>;", "if(<nosacījums>) <komanda> else <komanda>", "if(<nosacījums>) <komanda>;", "if(<nosacījums>) <komanda> than else <komanda>;"));
		jautajumiMasivs.add(new Jautajumi("Kurus no šiem nosacījumiem var ierakstīt if konstrukcijā?", "true && false", "\"Hello\"", "1+2", "10>5 || 7<3"));
		jautajumiMasivs.add(new Jautajumi("Kādu komandu izmanto, lai izlēktu no switch paziņojuma?", "exit", "break", "return", "skip"));
		jautajumiMasivs.add(new Jautajumi("Kādu komandu izmanto, ja selektora vērtība nesakrīt ne ar vienu no iezīmēm?", "break", "defualt", "defaults", "default"));
		jautajumiMasivs.add(new Jautajumi("Kur operators ir pareizi pierakstīts?", "if(a*b)", "if(a==1)", "if(b&&f)", "if(\"Hello\")"));
		String[] pareizasAtbildes = {"Jā", "Aiz else", "Nosacījumā", "Nav kļūdas", "Veikt darbību, pamatojoties uz nosacījumu", "if(<nosacījums>) <komanda>; else <komanda>;", "10>5 || 7<3", "break", "default", "if(a==1)"};
		
		JFrame f = new JFrame("Kraine_sazKon");
		f.setLayout(new FlowLayout()); 
		JTextArea text = new JTextArea("Sveiki!\nŠeit Jūs varat pārbaudīt savas zināšanas par\nsazarojumas konstrukcijas programmēšanas valodā Java.\nVEIKSMI!", 3, 1);
		JButton b = new JButton("Uzsakt testu");
		text.setEditable(false);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
				test(pareizasAtbildes, jautajumiMasivs);
				f.setVisible(true);
			}
		});
		f.add(text);
		f.add(b);
		f.setSize(500,125);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}  
}  