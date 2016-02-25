import java.util.ArrayList;

public class Tabuleiro {
	
	private Celula[][] tabuleiro;
	private int tamX;
	private int tamY;
	

	public Tabuleiro(ArrayList<CampoPetrolifero> camposPetroliferos, int tamX, int tamY){
		this.tabuleiro = new Celula [tamX][tamY];
		this.tamX = tamX;
		this.tamY = tamY;
		
		
		
		for (CampoPetrolifero campo: camposPetroliferos){
			for (CelulaPetrolifera celula: campo.getCelulasPetroliferas()){
				this.tabuleiro[celula.getPosicao().getX()][celula.getPosicao().getY()] = celula;
			}
		}
		
		for (int i=0; i<tamX; i++){
			for (int j=0; j<tamY; j++){
				if (tabuleiro[i][j] == null){
					tabuleiro[i][j] = new Celula(i,j);
					
				}
			}
		}
	}
	
	public Celula[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public int getTamX() {
		return tamX;
	}

	public int getTamY() {
		return tamY;
	}
		
	
}

