
public class Productor {
	
	private int numero;

	public Productor() {
	}
	
	public void activado() {
		
	    while (true) {
	        int item = producirItem();
	        Monitor.A�adir(item);
	    }
	}
	
	private int producirItem() {
		numero = (int) (Math.random() * 10);
		return numero;
	}
}
