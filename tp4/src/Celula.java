import java.util.Random;


public class Celula {
	private Posicao posicao;
	private double profundidade;
	
	public Celula(int xPosicao, int yPosicao){
		Posicao  p = new Posicao(xPosicao,yPosicao);
		this.posicao = p;
		this.posicao.setX(xPosicao);
		this.posicao.setY(yPosicao);
		
		Random randomGenerator = new Random();
		this.profundidade = randomGenerator.nextDouble();
		
	}
	
	
	
	public double getProfundidade(){
		return profundidade;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	public boolean getPerfurando(){
		return false;
	}
	
	public void changePerfurando(){}
	
	public double getPressao(){
		return 0;
	}
	
	public void drenarPressao(){}

}
