package controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.Plateau;

public class ControleurPlateauSouris implements MouseListener {

	private Plateau plateau=null;

	public void setPlateau(Plateau plt)
	{
		plateau=plt;
	}

	public void mouseClicked(MouseEvent e) {
		boolean notInGrille=true;
		for(int i=0; i<plateau.getCasePlateau().length;i++)
		{
			for(int j=0; j<plateau.getCasePlateau()[i].length;j++)
			{
				if(plateau.getCasePlateau()[i][j].getHex().contains(e.getX(), e.getY()))
				{
					notInGrille=false;
					for(int p=0; p<plateau.getCasePlateau().length;p++)
					{
						for(int q=0; q<plateau.getCasePlateau()[p].length;q++)
						{
							plateau.getCasePlateau()[p][q].setCouleur(Color.WHITE);
							if(plateau.caseDeDuplication(plateau.getCasePlateau()[i][j], plateau.getCasePlateau()[p][q]))
							{
								plateau.getCasePlateau()[p][q].setCouleur(Color.RED);
							}
							else if(plateau.caseDeDeplacement(plateau.getCasePlateau()[i][j], plateau.getCasePlateau()[p][q]))
							{
								plateau.getCasePlateau()[p][q].setCouleur(Color.GREEN);
							}
						}
					}
				}
				else if(notInGrille)
					plateau.getCasePlateau()[i][j].setCouleur(Color.WHITE);
			}
		}
		plateau.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
