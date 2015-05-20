package Vue;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Modele.Hexagone;

@SuppressWarnings("serial")
public class Plateau extends JFrame{
	
	Hexagone grille[][]=null;
	
	public Plateau(int largueur,int hauteur)
	{
		super("Hexagone");
		setSize(largueur, hauteur);
		setResizable(false);
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
				x2+=Hexagone.getCote();
				y2-=Hexagone.getCote()/2;
				getContentPane().add(grille[i][j]);
			}
			x+=Hexagone.getCote();
			y+=Hexagone.getCote()/2;
		}
		
		
		setVisible(true);
	}
	
}
