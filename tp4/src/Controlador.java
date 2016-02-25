import java.util.Random;


public class Controlador implements Runnable {

	private int tamX;
	private int tamY;
	private Robo robo;
	
	public Controlador(Robo robo, int tamX, int tamY) {
		this.tamX = tamX;
		this.tamY = tamY;
		this.robo = robo;
	}

	@Override
	public void run() {
		boolean comparacao;
		int direcao;
		Random random = new Random();
		while (true){
			for (int i=0;i<random.nextInt(5);i++){
				direcao = robo.getDirecao();
				if (direcao == 90){
					comparacao = robo.getPosicao().getY()<tamY-1;
				}
				else if (direcao == 0){
					comparacao = robo.getPosicao().getX()<tamX-1;
				}
				else if (direcao == 180){
					comparacao = robo.getPosicao().getX()>0;
				}
				else{
					comparacao = robo.getPosicao().getY()>0;
				}
				
				if(comparacao){
					robo.anda();
					robo.sonda();
				}
				else{
					robo.esquerda();
					robo.esquerda();
				}
			}
			robo.esquerda();
			for (int i=0;i<random.nextInt(5);i++){
				direcao = robo.getDirecao();
				if (direcao == 90){
					comparacao = robo.getPosicao().getY()<tamY-1;
				}
				else if (direcao == 0){
					comparacao = robo.getPosicao().getX()<tamX-1;
				}
				else if (direcao == 180){
					comparacao = robo.getPosicao().getX()>0;
				}
				else{
					comparacao = robo.getPosicao().getY()>0;
				}
				
				if(comparacao){
					robo.anda();
					robo.sonda();
				}
				else{
					robo.esquerda();
					robo.esquerda();
				}
			}
			robo.esquerda();
		}
		
	}
}
