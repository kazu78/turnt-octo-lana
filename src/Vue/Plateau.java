package Vue;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Hexagone;

@SuppressWarnings("serial")
public class Plateau extends JPanel{
	
	Hexagone grille[][]=null;
	
	public Plateau(int largueur,int hauteur)
	{
		setSize(largueur, hauteur);
		Hexagone.setCote(hauteur/5);
		grille=new Hexagone[5][5];
		int x=Hexagone.getCote()/2;
		int y=hauteur/2;
		for(int i=0;i<5;i++)
		{
			int x2=x,y2=y;
			for(int j=0;j<5;j++)
			{
				grille[i][j]=new Hexagone(x2, y2);
				x2+=Hexagone.getCote()-((grille[i][j].getxCenter()+(Hexagone.getCote()/2))-(grille[i][j].getxCenter()+(Hexagone.getCote()/4)));
				y2-=Hexagone.getCote()/2;
			}
			x+=Hexagone.getCote()-((grille[i][0].getxCenter()+(Hexagone.getCote()/2))-(grille[i][0].getxCenter()+(Hexagone.getCote()/4)));
			y+=Hexagone.getCote()/2;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				g.drawPolygon(grille[i][j].getHex());
			}
		}
	}
	
}
