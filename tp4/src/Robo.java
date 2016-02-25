

public class Robo {
	
	private Equipe equipe;
	private Posicao posicao;
	private int anguloDirecao;
	private Celula[][] tabuleiro;
	private boolean perfurando;
	Interface tela;
	Controlador controlador;
	
	public Robo(Equipe equipe, Interface interf, Posicao posicao, Tabuleiro tabuleiro){
		this.anguloDirecao = 90;
		this.perfurando = false;
		this.posicao = posicao;
		this.equipe = equipe;
		this.tela = interf;
		this.tabuleiro = tabuleiro.getTabuleiro();
		this.controlador = new Controlador(this,tabuleiro.getTamX(),tabuleiro.getTamY());
		
		(new Thread(this.controlador)).start();
		
	}
	
	public boolean isPerfurando() {
		return perfurando;
	}

	public Posicao getPosicao(){
		return posicao;
	}
	
	public Equipe getEquipe(){
		return equipe;
	}
	
	public void setPosicaoInicial(int x, int y){
		this.posicao.setX(x);
		this.posicao.setY(y);
		tela.setRobo(this);
	}
	
	public int getDirecao(){
		return anguloDirecao;
	}
	
	public void direita(){
		this.anguloDirecao -= 90;
		if (anguloDirecao == -90){
			anguloDirecao = 270;
		}
	}
	
	public void esquerda(){
		this.anguloDirecao += 90;
		if (anguloDirecao == 360){
			anguloDirecao = 0;
		}
	}
	
	public synchronized void anda(){
		if ((perfurando == false)&&(!tela.getEndGame())){
			double diferenca;
			int valor;
			if (anguloDirecao == 90){
				diferenca = tabuleiro[this.posicao.getX()][this.posicao.getY()+1].getProfundidade();
				diferenca = diferenca - tabuleiro[this.posicao.getX()][this.posicao.getY()].getProfundidade();
				diferenca = Math.abs(diferenca)*2000;
				valor = (int) diferenca;
				try{
			        Thread.sleep(valor);
			    } catch (Exception e){
			        e.printStackTrace();
			    }
				tela.retornarCelula(this.posicao.getX(), this.posicao.getY());
				this.posicao.setY(this.posicao.getY()+1);
				tela.setRobo(this);
				
			}
			else if (anguloDirecao == 270){
				diferenca = tabuleiro[this.posicao.getX()][this.posicao.getY()-1].getProfundidade();
				diferenca = diferenca - tabuleiro[this.posicao.getX()][this.posicao.getY()].getProfundidade();
				diferenca = Math.abs(diferenca)*2000;
				valor = (int) diferenca;
				try{
			        Thread.sleep(valor);
			    } catch (Exception e){
			        e.printStackTrace();
			    }
				tela.retornarCelula(this.posicao.getX(), this.posicao.getY());
				this.posicao.setY(this.posicao.getY()-1);
				tela.setRobo(this);
			}
			else if (anguloDirecao == 0){
				diferenca = tabuleiro[this.posicao.getX()+1][this.posicao.getY()].getProfundidade();
				diferenca = diferenca - tabuleiro[this.posicao.getX()][this.posicao.getY()].getProfundidade();
				diferenca = Math.abs(diferenca)*2000;
				valor = (int) diferenca;
				try{
			        Thread.sleep(valor);
			    } catch (Exception e){
			        e.printStackTrace();
			    }
				tela.retornarCelula(this.posicao.getX(), this.posicao.getY());
				this.posicao.setX(this.posicao.getX()+1);
				tela.setRobo(this);
			}
			else if (anguloDirecao == 180){
				diferenca = tabuleiro[this.posicao.getX()-1][this.posicao.getY()].getProfundidade();
				diferenca = diferenca - tabuleiro[this.posicao.getX()][this.posicao.getY()].getProfundidade();
				diferenca = Math.abs(diferenca)*2000;
				valor = (int) diferenca;
				try{
			        Thread.sleep(valor);
			    } catch (Exception e){
			        e.printStackTrace();
			    }
				tela.retornarCelula(this.posicao.getX(), this.posicao.getY());
				this.posicao.setX(this.posicao.getX()-1);
				tela.setRobo(this);
			}
		}
	}
	
	public void sonda(){
		int valor;
		if(((this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()] instanceof CelulaPetrolifera)
		&& (this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].getPressao() != 0))
		&& (!tela.getEndGame())){
			if (!this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].getPerfurando()){
				this.perfurando = true;
				this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].changePerfurando();
				valor = (int) this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].getPressao()*2000;
				try{
			        Thread.sleep(valor);
			    } catch (Exception e){
			        e.printStackTrace();
			    }
				this.getEquipe().setPlacar((int) (this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].getPressao()*100));
				System.out.println("Equipe: "+ this.getEquipe().getNome()+" - "+ this.getEquipe().getPlacar());
				this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].drenarPressao();
			}
		}
		this.perfurando = false;
		this.tabuleiro[this.getPosicao().getX()][this.getPosicao().getY()].changePerfurando();
	}
}
