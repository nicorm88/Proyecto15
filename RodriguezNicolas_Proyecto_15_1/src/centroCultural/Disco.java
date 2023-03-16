/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 15_1
*/
package centroCultural;

public class Disco extends Materiales{
	private String discografica;
	
	public Disco(String titulo,String autor,String discografica) {
		super(titulo,autor);
		this.discografica=discografica;
	}
	public String toString() {
		return "(Disco):\nCodigo Identificativo: "+codigoId+"\nTitulo: "+titulo+"\nAutor: "+autor+"\nDiscografica: "+discografica;
	}
	public String getDiscografica() {
		return discografica;
	}
	public String getTipo() {
		return "(Disco)";
	}
}
