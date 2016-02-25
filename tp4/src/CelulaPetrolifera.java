import java.util.Random;


public class CelulaPetrolifera extends Celula {
	double pressao;
	boolean perfurando;

	public CelulaPetrolifera(int xPosicao, int yPosicao) {
		super(xPosicao, yPosicao);
		Random randomGenerator = new Random();
		this.pressao = randomGenerator.nextDouble();
		this.perfurando = false;
	}
	
	public double getPressao(){
		return pressao;
	}
	
	public void drenarPressao(){
		this.pressao = 0;
	}
	
	public void changePerfurando(){
		this.perfurando = !this.perfurando;
	}
	
	public boolean getPerfurando(){
		return perfurando;
	}

}
