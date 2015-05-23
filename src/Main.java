

import javax.swing.JFrame;

import controleur.ControleurPlateauSouris;

import vue.Plateau;



public class Main {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Hexagone");
		fenetre.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		fenetre.setResizable(false);
		ControleurPlateauSouris controleurSouris = new ControleurPlateauSouris();
		Plateau plateau = new Plateau((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight(),controleurSouris);
		controleurSouris.setPlateau(plateau);
		fenetre.getContentPane().add(plateau);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		}

	}
