import java.util.ArrayList;
import java.util.List;


public class CampoPetrolifero {
	private List<CelulaPetrolifera> celulasPetroliferas = new ArrayList<CelulaPetrolifera>();
	
	public CampoPetrolifero(List<CelulaPetrolifera> celulasPetroliferas){
		this.celulasPetroliferas = celulasPetroliferas;
	}

	public List<CelulaPetrolifera> getCelulasPetroliferas() {
		return celulasPetroliferas;
	}

}
