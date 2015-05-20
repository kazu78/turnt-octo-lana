import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Hexagone;
import Vue.Plateau;


public class Main {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Hexagone");
		fenetre.setSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		fenetre.setResizable(false);
		fenetre.getContentPane().add(new Plateau((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		}

	}
