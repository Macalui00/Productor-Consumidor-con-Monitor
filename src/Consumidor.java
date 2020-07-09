

public class Consumidor {
	
	public Consumidor() {
	}
	
	public static void activado() {
		while (true) {
			int item = Monitor.Remover();
			consumirItem(item);
		}
	}

	private static void consumirItem(int item) {
		System.out.printf("El item removido del buffer es: ", item);
	}
}
