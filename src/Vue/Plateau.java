package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.ControleurPlateauSouris;

import modele.Hexagone;


@SuppressWarnings("serial")
public class Plateau extends JPanel{

	private Hexagone grille[][]=null;
	private ControleurPlateauSouris controleurSouris=null;
	
	public Plateau(int largueur,int hauteur,ControleurPlateauSouris controleur)
	{
		setSize(largueur, hauteur);
		controleurSouris=controleur;
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
		addMouseListener(controleurSouris);
	}
	
	public Hexagone[][] getCasePlateau()
	{
		return grille;
	}

	public void paintComponent(Graphics g)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				g.setColor(grille[i][j].getCouleur());
				g.fillPolygon(grille[i][j].getHex());
				g.setColor(Color.BLACK);
				g.drawPolygon(grille[i][j].getHex());

			}
		}
	}

	public boolean caseDeDuplication(Hexagone pion, Hexagone destination)
	{
	//	System.out.println((int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2)));
	//	System.out.println(Hexagone.getCote());
	//	System.out.println((int)Math.sqrt(Math.pow(Hexagone.getCote()-((pion.getxCenter()+(Hexagone.getCote()/2))-(pion.getxCenter()+(Hexagone.getCote()/4))), 2)+Math.pow(Hexagone.getCote()/2, 2)));
	//	System.out.println("========");
		
		if((int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==Hexagone.getCote()
			|| (int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==(int)Math.sqrt(Math.pow(Hexagone.getCote()-((pion.getxCenter()+(Hexagone.getCote()/2))-(pion.getxCenter()+(Hexagone.getCote()/4))), 2)+Math.pow(Hexagone.getCote()/2, 2))
				)
			return true;
		return false;
	}
	
	public boolean caseDeDeplacement(Hexagone pion, Hexagone destination)
	{
	//	System.out.println((int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2)));
	//	System.out.println(Hexagone.getCote()*2);
	//	System.out.println((Hexagone.getCote()-((pion.getxCenter()+(Hexagone.getCote()/2))-(pion.getxCenter()+(Hexagone.getCote()/4))))*2);
	//	System.out.println((int)Math.sqrt(Math.pow(Hexagone.getCote(), 2)+Math.pow(Hexagone.getCote()*1.5, 2)));
	//	System.out.println((int)Math.sqrt(Math.pow(Hexagone.getCote(), 2)+Math.pow(Hexagone.getCote()*2, 2)));
	//	System.out.println("========");
		if((int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==Hexagone.getCote()*2
			||(int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==(Hexagone.getCote()-((pion.getxCenter()+(Hexagone.getCote()/2))-(pion.getxCenter()+(Hexagone.getCote()/4))))*2
			||(int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==(int)Math.sqrt(Math.pow(Hexagone.getCote(), 2)+Math.pow(Hexagone.getCote()*1.5, 2))
			||(int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==(int)Math.sqrt(Math.pow(Hexagone.getCote(), 2)+Math.pow(Hexagone.getCote()*2, 2))
			||(int)Math.sqrt(Math.pow(pion.getxCenter()-destination.getxCenter(),2)+Math.pow(pion.getyCenter()-destination.getyCenter(), 2))==(int)Math.sqrt(Math.pow(Hexagone.getCote()-((pion.getxCenter()+(Hexagone.getCote()/2))-(pion.getxCenter()+(Hexagone.getCote()/4))), 2)+Math.pow(Hexagone.getCote()*1.5, 2))
			)
			return true;
		return false;
	}
}
