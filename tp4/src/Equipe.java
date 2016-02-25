import java.awt.Color;
import java.util.Comparator;


public class Equipe implements Comparator<Equipe>{

	private String nome;
	private int placar;
	private Color cor;

	public Equipe(String nome, Color cor){
		this.nome = nome;
		this.cor = cor;
		this.placar = 0;
	}
	
	
	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = this.placar+placar;
	}

	public String getNome() {
		return nome;
	}

	public Color getCor() {
		return cor;
	}
	
	@Override
    public int compare(Equipe  equipe1, Equipe  equipe2)
    {
		Integer i = new Integer(equipe1.getPlacar());
		return i.compareTo(equipe2.getPlacar());
    }
	
}