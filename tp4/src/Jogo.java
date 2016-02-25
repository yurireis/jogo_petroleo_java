import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;


public class Jogo {

	public static void main(String[] args) {
		
		Color[] img = new Color[3];
		img[0] = Color.YELLOW;
		img[1] = Color.RED;
		img[2] = Color.PINK;
		
		
		Equipe[] equipes = new Equipe[3];
		
		equipes[0] = new Equipe("time1", img[0]);
		equipes[1] = new Equipe("time2", img[1]);
		equipes[2] = new Equipe("time3", img[2]);
			
		
		CelulaPetrolifera c1 = new CelulaPetrolifera(1, 2);
		CelulaPetrolifera c2 = new CelulaPetrolifera(3, 4);
		CelulaPetrolifera c3 = new CelulaPetrolifera(9, 9);
			
		List<CelulaPetrolifera> celulasPetroliferas = new ArrayList<CelulaPetrolifera>();
		celulasPetroliferas.add(c1);
		celulasPetroliferas.add(c2);
		celulasPetroliferas.add(c3);
		
		
		CampoPetrolifero campo1 = new CampoPetrolifero(celulasPetroliferas);
		
		ArrayList<CampoPetrolifero> campos =  new ArrayList<CampoPetrolifero>();
		campos.add(campo1);
		
		
		Tabuleiro tabuleiro = new Tabuleiro(campos, 10, 10);
		
		ArrayList<Robo> robos =  new ArrayList<Robo>();
		
		int i;
		int x,y;
		x=1;
		y=1;
		for(i=0;i<=2;i++){
			Posicao pos1 = new Posicao(1,2);
			Robo r1 = new Robo(equipes[i],tabuleiro, pos1);
			r1.setPosicaoInicial(x, y);
			robos.add(r1);
			x+= 1;
			y+= 1;
		}
		
		
		Interface tela = new Interface(tabuleiro,robos);
		tela.setVisible(true);
		
	}

}
