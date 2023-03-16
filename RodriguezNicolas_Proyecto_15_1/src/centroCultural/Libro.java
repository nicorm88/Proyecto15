/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 15_1
*/
package centroCultural;

public class Libro extends Materiales{
	private int numPaginas;
	private String editorial;
	
	public Libro(String titulo,String autor,int numPaginas,String editorial) {
		super(titulo,autor);
		this.numPaginas=numPaginas;
		this.editorial=editorial;
	}
	public String toString() {
		return "(Libro):\nCodigo Identificativo: "+codigoId+"\nTitulo: "+titulo+"\nAutor: "+autor+"\nNumero de paginas: "+numPaginas+"\nEditorial: "+editorial;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public String getEditorial() {
		return editorial;
	}
	public String getTipo() {
		return "(Libro)";
	}
}
