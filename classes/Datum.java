public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Parameter-loze constructor
	 */
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}

	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar) {
		if (this.bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}


	public boolean bestaatDatum(int dag, int maand, int jaar){
		if (dag <1 || >31|| (maand <1 || >12) ||(jaar <1900 || >2100)){
			return false;
		}
		elseif ((maand != 1 && maand != 3 && maand != 5 && maand != 7 && maand != 8 && maand != 10 && maand != 12)  &&  (dag > 30 ) && (!jaar % 4 == 0))
		{return false;}
		else
		{
			return true;
		}
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
		}

		// Getters en setters voor instantievariabelen

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
}
