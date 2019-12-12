import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Jugador implements java.io.Serializable{
	public static int tam=5;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2128200458112401415L;
	public String nombre;
	public int  puntaje;
	public boolean ocupado;
	
	
	
	public Jugador(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.ocupado=true;
	}
	public Jugador(int puntaje) {
		this.nombre = Wcore.leer();
		this.puntaje = puntaje;
		this.ocupado=true;
	}
	
	public Jugador(){
		this.nombre="Nombre "+Wcore.convierteInt(Wcore.rng(100));
		this.puntaje=Wcore.rng(100);
		this.ocupado=true;
		
	}
	
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", puntaje=" + puntaje + ", ocupado=" + ocupado + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {	
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public static boolean cmp(Jugador listas) {
		if (listas.isOcupado())
			return listas.isOcupado();
		else 
		  return false;
	}
	
	 public static void Grabar(Jugador[] listas){
		 
		   try {
				ObjectOutputStream salida=new 
				ObjectOutputStream(new FileOutputStream("Lista.obj"));
				 salida.writeObject(listas);
			      salida.close();
			   System.out.println(" se guardo correctamente archivo");
			} catch (IOException e) {
			   System.out.println("No se guardo correctamente archivo");
				e.printStackTrace();
			} 
	 }
	
	 
	 
	 
	 public static Jugador[] Leer() throws ClassNotFoundException{
		 Jugador[] listas = new Jugador[tam];
		 try {
				ObjectInputStream entrada=new 
				 ObjectInputStream(new FileInputStream("Lista.obj"));
				Jugador[] listas1=(Jugador[])entrada.readObject();		
				listas=listas1;
			    entrada.close();
			 System.out.println(" se encontro archivo");
			} catch (IOException e) {
								e.printStackTrace();
			 System.out.println("No se encontro archivo");
			}
		return listas;
	 }
    
	 public static void Mostrar(Jugador[] listas) throws IOException {

		 try {
			 for(int x=0;x<25;x++)
			 {
				 System.out.println(listas[x].toString());
			 }
		 } catch (Exception e) {
			 System.out.println("no hay valores en la lista");
		 }


	 }
	 public static Jugador[] GLR() {// generar lista random
		 Jugador[] listas = new Jugador[tam];
		 for(int x=0;x<tam;x++)
			{
				listas[x]=new Jugador();	
			}
		 System.out.println("Nueva lista gnerada");
		return listas;
		 
	 }
	 
	 public static void main(String[] args) throws ClassNotFoundException, IOException {
    Jugador[] listas = new Jugador[tam];
		String eleccion;
    	int x=0;
    do{
		System.out.println("1) Generar nueva lista de valores");
		System.out.println("2) Guardar Lista");
		System.out.println("3) Leer Lista ");
		System.out.println("4) Mostrar Lista");
		System.out.println("5) Salir");
		System.out.print("Eleccion ");
		eleccion =Wcore.leer();
		x=Wcore.conviertecadenaI(eleccion);

		if (x==1){
			listas=GLR();
			x=0;
		}
		if (x==2){
			Grabar(listas);
			x=0;
		}
		if (x==3){
			listas=Leer();
			x=0;
		}
		if (x==4){
			Mostrar(listas);
			x=0;
		}
	}while(x<5);
 //  listas=GLR();
   // Grabar(listas);
   // listas=Leer();





}
}
