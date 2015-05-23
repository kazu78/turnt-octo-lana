package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Hexagone;

@SuppressWarnings("serial")
public class Plateau extends JPanel implements MouseListener{

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
		addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<grille.length;i++)
		{
			for(int j=0; j<grille[i].length;j++)
				if(grille[i][j].getHex().contains(e.getX(), e.getY()))
				{
					for(int p=0; p<grille.length;p++)
					{
						for(int q=0; q<grille[p].length;q++)
						{
							if(caseDeDuplication(grille[i][j], grille[p][q]))
							{
								grille[p][q].setCouleur(Color.RED);
							}
							else if(caseDeDeplacement(grille[i][j], grille[p][q]))
							{
								grille[p][q].setCouleur(Color.GREEN);
							}
							else
								{
									grille[p][q].setCouleur(Color.WHITE);
								}
						}
					}
				}
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
