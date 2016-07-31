package himmelskoerper;

/**
 * Ein Himmelskörper, bewohnbar, wenn fest
 * Umkreist einen Planeten
 * 
 * @author Thomas
 * @version 1.0
 */
public class Mond extends InOrbit
{

	public Mond(Planet bezugsKoerper, double distanz, double masse) {
		super(bezugsKoerper, distanz, masse, "fest");
		// TODO Auto-generated constructor stub
	}

}
