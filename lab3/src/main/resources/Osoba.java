public class Osoba {

	private String nazwisko = "Kowalksi";
	private String imie;
	private int wiek;
	private final static Osoba ourInstance = new Osoba();

	public static Osoba getInstance() {
		return ourInstance;
	}

	private Osoba() {
	}

	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

}
