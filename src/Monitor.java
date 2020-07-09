
public class Monitor {
	int contadorItems;
	static final int tamañoBuffer = 5;
	int[] buffer = new int[tamañoBuffer];
	int condicionLleno;
	int condicionVacio;
	
	public Monitor() {
		this.contadorItems = 0;
		this.condicionLleno = 0;
		this.condicionVacio = 1;
	}
	
	public void Añadir(int item){
        System.out.println("Se añade el item producido por el productor al buffer.\n");
        if (contadorItems == tamañoBuffer) {
            esperarLleno();
        } else {

        	ponerItemDentroDelBuffer(item);

        	if (contadorItems == 1) {
        		notificarVacio();
        	}
        }
	}
	
	private void esperarLleno(){
		condicionLleno = 1;
		System.out.println("El buffer esta lleno, condicionLleno =" + condicionLleno + "\n");
	}
	
	private void notificarVacio() {
		condicionVacio = 0;
		System.out.println("El buffer ya no esta vacio, se cambia el valor de condicionVacio a 0 \n");
	}
	
	private void ponerItemDentroDelBuffer(int item) {
		System.out.println("Se inserta el item: " + item + " en el buffer en la posicion: "+ contadorItems + "\n");
		buffer[contadorItems] = item;
		contadorItems ++;
	}
	
    public int Remover() {
    	int item =-1;
    	System.out.println("Se va a remover un item del buffer.\n");
        if (contadorItems == 0) {
        	System.out.println("ContadorItems = 0. \n");
            esperarVacio();
        } else {

        	item = removerItemDelBuffer();
        	
        	if (contadorItems == tamañoBuffer - 1) {
        		notificarLleno();
        	}
        }

        return item;
    }
    
    private int removerItemDelBuffer() {
        int i = 0;
        i = buffer[0];
    	int[] bufferaux = new int[tamañoBuffer];
        
        for (int a = 0; a<tamañoBuffer-1; a++){
            bufferaux[a] = buffer[a+1];
        }
        
        buffer = bufferaux;
        
        contadorItems = contadorItems - 1;
        System.out.println("El contadorItems se decremento, valor actual: " + contadorItems + ".\n");
    	return i;
    }
    
    private void esperarVacio() {
    	condicionVacio = 1;
    	System.out.println("El buffer esta vacio, condicionVacio =" + condicionVacio + "\n");
    	System.out.println("No se pueden remover items.\n");
    }
    
	private void notificarLleno() {
		condicionLleno = 0;
		System.out.println("Se cambio el valor de condicionLleno a cero, ya que no esta lleno\n");
	}
	
}
