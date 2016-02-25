import java.awt.Color;
import java.util.ArrayList;




public class Main{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		int TEMPO_JOGO = 30;
		
		ArrayList<CampoPetrolifero> campos = new ArrayList<CampoPetrolifero>();
		ArrayList<CelulaPetrolifera> campo = new ArrayList<CelulaPetrolifera>();
		
		CelulaPetrolifera celula = new CelulaPetrolifera(3,4);
		campo.add(celula);
		celula = new CelulaPetrolifera(3,5);
		campo.add(celula);
		celula = new CelulaPetrolifera(3,6);
		campo.add(celula);
		celula = new CelulaPetrolifera(3,7);
		campo.add(celula);
		celula = new CelulaPetrolifera(4,4);
		campo.add(celula);
		
		campos.add(new CampoPetrolifero(campo));
		
		celula = new CelulaPetrolifera(6,7);
		campo.add(celula);
		celula = new CelulaPetrolifera(6,8);
		campo.add(celula);
		celula = new CelulaPetrolifera(6,9);
		campo.add(celula);
		celula = new CelulaPetrolifera(7,7);
		campo.add(celula);
		celula = new CelulaPetrolifera(7,8);
		campo.add(celula);
		
		campos.add(new CampoPetrolifero(campo));
		Tabuleiro tabuleiro = new Tabuleiro(campos,10,10);
		

		ArrayList<Equipe> equipes = new ArrayList<Equipe>();
		Equipe equipe1 = new Equipe("Robolandia", Color.white);
		equipes.add(equipe1);
		Equipe equipe2 = new Equipe("Perfurantes", Color.green);
		equipes.add(equipe2);
		
		Interface interf = new Interface(tabuleiro, equipes);
		
		interf.setVisible(true);
		
		Posicao posicao = new Posicao(3,2);
		new Robo(equipe1, interf, posicao, tabuleiro);
		posicao = new Posicao(7,2);
		new Robo(equipe1, interf, posicao, tabuleiro);
		posicao = new Posicao(8,4);
		new Robo(equipe2, interf, posicao, tabuleiro);
		posicao = new Posicao(9,0);
		new Robo(equipe2, interf, posicao, tabuleiro);
		
		try{
	        Thread.sleep(TEMPO_JOGO*1000);
	    } catch (Exception e){
	        e.printStackTrace();
	    }
		
		interf.endGame();
		
		
	
	}

}
