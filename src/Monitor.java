
public class Monitor {
	int contadorItems;
	static final int tama�oBuffer = 5;
	int[] buffer = new int[tama�oBuffer];
	int condicionLleno;
	int condicionVacio;
	
	public Monitor() {
		this.contadorItems = 0;
		this.condicionLleno = 0;
		this.condicionVacio = 1;
	}
	
	public void A�adir(int item){
        while (contadorItems == tama�oBuffer) {
            esperarLleno();
        }

        ponerItemDentroDelBuffer(item);

        if (contadorItems == 1) {
            notificarVacio();
        }
	}
	
	private void esperarLleno(){
		condicionLleno = 1;
		Consumidor.acivado();
	}
	
	private void notificarVacio() {
		condicionVacio = 0;
	}
	
	private void ponerItemDentroDelBuffer(int item) {
		buffer[contadorItems] = item;
		contadorItems ++;
	}
	
    public int Remover() {
        while (contadorItems == 0) {
            esperarVacio();
        }

        int item = removerItemDelBuffer();

        if (contadorItems == tama�oBuffer - 1) {
            notificarLleno();
        }

        return item;
    }
    
    private int removerItemDelBuffer() {
        int i = 0;
        i = buffer[0];

        for (int a = 0; a<buffer.length; a++){
            buffer[a] = buffer[a+1];
        }

        contadorItems = contadorItems - 1;
    	return i;
    }
    
    private void esperarVacio() {
    	condicionVacio = 1;
    	Productor.activado();
    }
	private void notificarLleno() {
		condicionLleno = 0;
	}
}
