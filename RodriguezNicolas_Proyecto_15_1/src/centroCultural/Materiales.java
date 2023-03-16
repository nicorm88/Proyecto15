/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 15_1
*/
package centroCultural;

public abstract class Materiales {
	/*
	 * Contendrá el codigo identificativo del disco o libro que se generará aleatoriamente
	 */
	protected int codigoId;
	protected String titulo;
	protected String autor;
	
	public Materiales(String titulo,String autor) {
		this.codigoId=(int)(Math.random()*9999);
		this.titulo=titulo;
		this.autor=autor;
	}
	public int getCodigoId() {
		return codigoId;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public abstract String getTipo();
}
