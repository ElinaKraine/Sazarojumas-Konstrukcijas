package test;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class GalvenaDala {
	
	static File darbvirsma = FileSystemView.getFileSystemView().getHomeDirectory();
	static String atrasanasVieta = darbvirsma.getAbsolutePath();
	
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
	public static void main(String[] args) {
		ArrayList<Jautajumi> jautajumiMasivs = new ArrayList<Jautajumi>();
		jautajumiMasivs.add(new Jautajumi("Vai var izmantot if bez else?", "Jā", "Nē", "Nezinu", "Visas atbildes ir pareizas"));
		jautajumiMasivs.add(new Jautajumi("Kur ir komandas, kam vajadzētu notikt,\nja nosacījums ir nepatiess sazarojumā konstrukcijā IF...else?", "Nekur", "Aiz if", "Aiz else", "Aiz switch"));
		jautajumiMasivs.add(new Jautajumi("Kur ir kļūda?", "Operācijā", "Nosacījumā", "Komandā", "Nav kļūdas"));
		jautajumiMasivs.add(new Jautajumi("Kur ir kļūda?", "Operācijā", "Nosacījumā", "Komandā", "Nav kļūdas"));
		jautajumiMasivs.add(new Jautajumi("Kāds ir paziņojuma if mērķis?", "Mainīgā deklarēšana", "Lai veikt ciklu", "Veikt darbību, pamatojoties uz nosacījumu", "Lai definētu klasi"));
		jautajumiMasivs.add(new Jautajumi("Kā pareizi jāraksta if...else konstrukciju?", "if(<nosacījums>) <komanda>; else <komanda>;", "if(<nosacījums>) <komanda> else <komanda>", "if(<nosacījums>) <komanda>;", "if(<nosacījums>) <komanda> than else <komanda>;"));
		jautajumiMasivs.add(new Jautajumi("Kurš no šiem izteikumiem ir derīgs nosacījumam teikumā if?", "true && false", "\"Hello\"", "1+2", "10>5 || 7<3"));
		jautajumiMasivs.add(new Jautajumi("Kādu komandu izmanto, lai izlēktu no switch paziņojuma?", "exit", "break", "return", "skip"));
		jautajumiMasivs.add(new Jautajumi("Kādu komandu izmanto, ja selektora vērtība nesakrīt ne ar vienu no iezīmēm?", "break", "defualt", "defaults", "default"));
		jautajumiMasivs.add(new Jautajumi("Cik daudz nosacījumu var novērtēt vienā \"if...else if...else\" paziņojumā?", "Tikai viens nosacījums", "Neierobežots nosacījumu skaits", "Ne vairāk kā trīs nosacījumi", "Ne vairāk kā divi nosacījumi"));
		String[] pareizasAtbildes = {"Jā", "Aiz else", "Nosacījumā", "Nav kļūdas", "Veikt darbību, pamatojoties uz nosacījumu", "if(<nosacījums>) <komanda>; else <komanda>;", "10>5 || 7<3", "break", "default", "Ne vairāk kā trīs nosacījumi"};
		JFrame f = new JFrame("Kraine_sazKon");
		f.setLayout(new FlowLayout()); 
		JTextArea text = new JTextArea("Sveiki!\nŠeit Jūs varat pārbaudīt savas zināšanas par\nsazarojumas konstrukcijas programmēšanas valodā Java.\nVEIKSMI!", 3, 1);
		JButton b = new JButton("Uzsakt testu");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int p=0;
				f.setVisible(false);
				String atb = null;
				ImageIcon img3 = new ImageIcon(atrasanasVieta+"\\Kraine.png");
				ImageIcon img4 = new ImageIcon(atrasanasVieta+"\\Kraine_png4.png");
				for(int i=0; i<jautajumiMasivs.size(); i++) {
					switch(i) {
						case 0: case 1: case 4: case 5: case 6: case 7: case 8: case 9: atb=izvele(i, jautajumiMasivs, null); break;
						case 2: atb=izvele(i, jautajumiMasivs, img3); break;
						case 3: atb=izvele(i, jautajumiMasivs, img4); break;
					}
					if(atb==pareizasAtbildes[i]) {
						JOptionPane.showMessageDialog(null, "Pareizi");
						p++;
					}else {
						JOptionPane.showMessageDialog(null, "Nepareizi");
						i--;
					}
				}
				JOptionPane.showMessageDialog(null, "punkti: "+p);
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