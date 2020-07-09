
public class Ejecucion {

	public static void main(String[] args) {
		Consumidor consumidor = new Consumidor();
		Productor productor = new Productor();
		Monitor monitor = new Monitor();
		while (true) {
			if(monitor.condicionLleno == 1){
				System.out.println("Consumidor activado o despierto.\n");
				while(monitor.contadorItems !=0) {
					int item = monitor.Remover();
					if(item != -1) {
						consumidor.consumirItem(item);
					} else {
						System.out.println("Buffer vacio.");
					}
				}
				System.out.println("consumidor desactivado o dormido.\n");
			} else if(monitor.condicionVacio == 1) {
		        System.out.println("Productor activado o despierto.\n");
				while(monitor.condicionLleno!=1) {
					int item = productor.producirItem();
					monitor.Añadir(item);
				}
				System.out.println("Productor desactivado o dormido.\n");
			}
		}
	}

}
