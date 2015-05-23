package modele;

import java.awt.Color;
import java.awt.Polygon;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Hexagone extends JComponent{

	private int xCenter;
	private int yCenter;
	private static int cote;//=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()/z;
	Polygon Hex= new Polygon();
	private Color etat = new Color(255, 255, 255);
	
	public Hexagone(int x, int y)
	{
		xCenter=x;
		yCenter=y;
		Hex.addPoint(xCenter-(cote/2), yCenter);
		Hex.addPoint(xCenter-(cote/4), yCenter-(cote/2));
		Hex.addPoint(xCenter+(cote/4), yCenter-(cote/2));
		Hex.addPoint(xCenter+(cote/2), yCenter);
		Hex.addPoint(xCenter+(cote/4), yCenter+(cote/2));
		Hex.addPoint(xCenter-(cote/4), yCenter+(cote/2));
		
	}
	
	public static void setCote(int cote)
	{
		Hexagone.cote=cote;
	}
	
	public Polygon getHex()
	{
		return Hex;
	}
	
/*	public void paint(Graphics g){
		Hexagone.setCote(200);
		Hexagone hex = new Hexagone(500, 500);
		g.drawPolygon(hex.getHex());
	}
*/	
	public static int getCote()
	{
		return cote;
	}
	
	public int getxCenter()
	{
		return xCenter;
	}
	
	public int getyCenter()
	{
		return yCenter;
	}
	public Color getCouleur()
	{
		return etat;
	}
	public void setCouleur(Color couleur)
	{
		etat=couleur;
	}
}
