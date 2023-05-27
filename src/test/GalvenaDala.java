package test;

import java.awt.event.*;
import javax.swing.*;

public class GalvenaDala {
	
	public static void main(String[] args) {  
		JFrame f = new JFrame("Kraine_sazKon");
		//final JTextField tf = new JTextField();
		//tf.setBounds(50,50, 150,20);
		JButton b = new JButton("Uzsakt testu");
		b.setBounds(1,1,120,35);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
				JOptionPane.showMessageDialog(null, "ss");
				f.setVisible(true);
				//tf.setText("Welcome to Javatpoint.");
			}
		});
		f.add(b);
		//f.add(tf);
		f.setSize(400,200);
		f.setLayout(null);
		f.setVisible(true);
	}  
}  