package test;

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
		jautajumiMasivs.add(new Jautajumi("vopros5", "v51", "v52", "v53", "v54"));
		String[] pareizasAtbildes = {"Jā", "Aiz else", "Nosacījumā", "Nav kļūdas", "v51"};
		JFrame f = new JFrame("Kraine_sazKon");
		JButton b = new JButton("Uzsakt testu");
		b.setBounds(1,1,120,35);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int p=0;
				f.setVisible(false);
				String atb = null;
				ImageIcon img3 = new ImageIcon(atrasanasVieta+"\\Kraine.png");
				ImageIcon img4 = new ImageIcon(atrasanasVieta+"\\Kraine_png4.png");
				for(int i=0; i<jautajumiMasivs.size(); i++) {
					switch(i) {
						case 0: case 1: atb=izvele(i, jautajumiMasivs, null); break;
						case 2: atb=izvele(i, jautajumiMasivs, img3); break;
						case 3: atb=izvele(i, jautajumiMasivs, img4); break;
						case 4: atb=izvele(i, jautajumiMasivs, null); break;
						case 5: atb=izvele(i, jautajumiMasivs, null); break;
					}
					if(atb.equalsIgnoreCase(pareizasAtbildes[i])) {
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
		f.add(b);
		f.setSize(400,200);
		f.setLayout(null);
		f.setVisible(true);
	}  
}  