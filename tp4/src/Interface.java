import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tabuleiro tabuleiro;
	private JButton[][] grid;
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	private boolean endGame;
	
	public Interface(Tabuleiro tabuleiro, ArrayList<Equipe> equipes){
		this.tabuleiro = tabuleiro;
		this.equipes = equipes;
		this.endGame = false;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,600);
		this.construirTela();
	}
	
	private void construirTela(){
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(construirTabuleiro(), BorderLayout.CENTER);
		this.getContentPane().add(listaEquipes(), BorderLayout.EAST);
	}
	
	private JPanel listaEquipes(){
		JPanel listaequipes = new JPanel();
		listaequipes.setLayout(new GridLayout(this.equipes.size()+1,1));
		listaequipes.add(new JLabel("Equipes:", SwingConstants.RIGHT));
		JLabel label = new JLabel();
		for (Equipe equipe: equipes ){
			label = new JLabel("0", SwingConstants.RIGHT);
			listaequipes.add(label);
			label.setText(equipe.getNome());
			label.setVisible(true);
		}
		listaequipes.setVisible(true);
		return listaequipes;
	}
	
	private JPanel construirTabuleiro(){
		JPanel campo = new JPanel();
		campo.setLayout(new GridLayout(this.tabuleiro.getTamX(),this.tabuleiro.getTamY()));
		campo.setVisible(true);
		
		Celula[][] matriz = this.tabuleiro.getTabuleiro();
		grid = new JButton[tabuleiro.getTamX()][tabuleiro.getTamY()];
		
		int i,j;
		for (i=0; i<tabuleiro.getTamX();i++){
			for (j=0; j<tabuleiro.getTamY();j++){
				if (matriz[i][j] instanceof CelulaPetrolifera){
					campo.add(construirCelulaPetrolifera(matriz[i][j]));
			
				}
				else{
					campo.add(construirCelula(matriz[i][j]));
				}
			}
			
		}
		return campo;
	}
	
	private JButton construirCelulaPetrolifera(Celula celula) {
		JButton c = new JButton();
		c.setBackground(Color.BLACK);
		c.setVisible(true);
		grid[celula.getPosicao().getX()][celula.getPosicao().getY()] = c;
		return grid[celula.getPosicao().getX()][celula.getPosicao().getY()];
	}
	
	public void setRobo(Robo i) {
		grid[i.getPosicao().getX()][i.getPosicao().getY()].setBackground(i.getEquipe().getCor());
		
		grid[i.getPosicao().getX()][i.getPosicao().getY()].setVisible(true);
	}
	
	public void retornarCelula(int x, int y){
		if(tabuleiro.getTabuleiro()[x][y] instanceof CelulaPetrolifera){
			grid[x][y].setBackground(Color.black);
		}
		else{
			grid[x][y].setBackground(Color.blue);
		}
	}
	
	private JButton construirCelula(Celula celula){
		JButton c = new JButton();
		c.setBackground(Color.BLUE);
		c.setVisible(true);
		
		grid[celula.getPosicao().getX()][celula.getPosicao().getY()] = c;
		
		return grid[celula.getPosicao().getX()][celula.getPosicao().getY()];
	}
	
	public JOptionPane endGame(){
		this.endGame = true;
		JOptionPane alerta = new JOptionPane();
		Equipe vencedora = new Equipe("",Color.black);
		for(Equipe e: this.equipes){
			for(Equipe i: this.equipes){
				if (e.compare(e,i)>0){
					vencedora = e;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Equipe vencedora: "+vencedora.getNome()+" - Pontuação: "+vencedora.getPlacar(), "Fim de Jogo", JOptionPane.PLAIN_MESSAGE);
		alerta.setVisible(true);
		return alerta;
	}
	
	public boolean getEndGame(){
		return this.endGame;
	}
}
