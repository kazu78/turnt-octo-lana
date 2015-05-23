

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import controleur.ControleurPlateauSouris;

import vue.Plateau;



public class Main {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Hexagone");
		fenetre.setSize((int)GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth(),(int)GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
		fenetre.setResizable(false);
		ControleurPlateauSouris controleurSouris = new ControleurPlateauSouris();
		Plateau plateau = new Plateau((int)GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth(),(int)GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight(),controleurSouris);
		controleurSouris.setPlateau(plateau);
		fenetre.getContentPane().add(plateau);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		}

	}
