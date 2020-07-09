
public class Productor {
	
	private int numero;

	public Productor() {
	}
	
	public int producirItem() {
		numero = (int) (Math.random() * 10);
        System.out.println("El item producido es: "+ numero +".\n");
		return numero;
	}
}
