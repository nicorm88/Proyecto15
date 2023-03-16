/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 15_1
*/
package centroCultural;

import java.time.LocalDate;

public class Socio {
	/*
	 * Contendra la fecha en la que se renovo o se hizo socio para saber cuando tiene que devolver los materiales
	 */
	private LocalDate renovacionMensual;
	private String nombre;
	private String apellido1;
	private String apellido2;
	/*
	 * Contiene los 10 materiales que va a poder pedir prestado el socio
	 */
	private Materiales[] materiales;
	
	public Socio(String nombre,String apellido1,String apellido2) {
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		materiales= new Materiales [10];
		renovacionMensual=LocalDate.now();
	}
	/*
	 * Metodo para añadir un disco al array que contiene los materiales prestados al socio, 
	 * devulve 1 si se ha añadido correctamente ,un 0 si ya tiene 10 materiales prestados y un -1 si necesita renovar el pase
	 */
	public int anadirDisco(Disco nuevoDisco) {
		//Verifico que tiene renovado el pase se socio
		if(caducado()==false) {
			int i=0;
			do {
				//Busco una posicion libre en el array, si la encuetra modifica la variable de control para salir del bucle
				if(materiales[i]==null) {
					materiales[i]=new Disco(nuevoDisco.getTitulo(),nuevoDisco.getAutor(),nuevoDisco.getDiscografica());
					i=-2;
				}else {
					//Si no encuentra posicion libre es porque está lleno y modifica la variabled e control para salirse
					if(i==materiales.length-1) {
						i=-1;
					}else {
						i++;
					}
				}
			}while(i>=0);
			if(i==-1) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return -1;
		}
	}
	/*
	 * Metodo para añadir un libro al array que contiene los materiales prestados al socio, 
	 * devulve 1 si se ha añadido correctamente ,un 0 si ya tiene 10 materiales prestados y un -1 si necesita renovar el pase
	 */
	public int anadirLibro(Libro nuevoLibro) {
		//Verifico que tiene renovado el pase se socio
		if(caducado()==false) {
			int i=0;
			do {
				//Busco una posicion libre en el array, si la encuetra modifica la variable de control para salir del bucle
				if(materiales[i]==null) {
					materiales[i]=new Libro(nuevoLibro.getTitulo(),nuevoLibro.getAutor(),nuevoLibro.getNumPaginas(),nuevoLibro.getEditorial());
					i=-2;
				}else {
					//Si no encuentra posicion libre es porque está lleno y modifica la variabled e control para salirse
					if(i==materiales.length-1) {
						i=-1;
					}else {
						i++;
					}
				}
			}while(i>=0);
			if(i==-1) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return -1;
		}
	}
	/*
	 * Metodo para renovar al socio, indicando que ya pago el siguiente mes
	 */
	public void renovar() {
		renovacionMensual=LocalDate.now();
	}
	/*
	 * Metodo que calcula si el socio tiene el pase caducado o no segun la ultima fecha de pago
	 */
	public boolean caducado() {
		LocalDate ahora=LocalDate.now();
		//Primero compruebo si estamos en el mismo año o tiene renovado hasta el año que viene
		if(ahora.getYear()-renovacionMensual.getYear()<=0) {
			//Compruebo si estamos en el mismo mes
			if(ahora.getMonthValue()-renovacionMensual.getMonthValue()==0) {
				//Por ultimo comprobar que el dia que tiene renovado es posterior a hoy
				if(ahora.getDayOfMonth()-renovacionMensual.getDayOfMonth()<0) {
					return true;
				}else {
					return false;
				}
			}else {
				//Si no estamos en el mismo mes saber si está renovado hasta un mes en adelante o no
				if(ahora.getMonthValue()-renovacionMensual.getMonthValue()<0) {
					return false;
				}else {
					return true;
				}
			}
		}else {
			return true;
		}
	}
	public String infoMateriales() {
		String info="";
		for(int i=0;i<materiales.length;i++) {
			if(materiales[i]!=null) {
				info+=(i+1)+"-"+materiales[i].toString()+"\n\n";
			}
		}
		return info;
	}
	public String infoSimplificadaMateriales() {
		String infoSimp="";
		for(int i=0;i<materiales.length;i++) {
			if(materiales[i]!=null) {
				infoSimp+=(i+1)+"-"+materiales[i].getTipo()+" "+materiales[i].getTitulo()+"\n";
			}
		}
		return infoSimp;
	}
	public void borrar(int pos) {
		//Controlo que no me vayan a poner un numero que no existe en el array
		if(pos-1>materiales.length-1) {
			
		}else {
			materiales[pos-1]=null;
			//Corro todas las mascotas una posicion menos en el array
			for(int i=pos-1;i<materiales.length-1;i++) {
				materiales[i]=materiales[i+1];
			}
			//Como en el for no puedo correr la ultima posicion pues lo hago manualmente, posicion que siempre será nula si borramos un objeto del array
			materiales[materiales.length-1]=null;
		}
	}
	public String infoSocio() {
		String info="";
		info="Nombre: "+nombre+"\nApellido1: "+apellido1+"\nApellido2: "+apellido2+"\nUltima vez renovado: "+renovacionMensual.getDayOfMonth()+"-"+renovacionMensual.getMonthValue()+"-"+renovacionMensual.getYear();
		return info;
	}
	public int getCantidadMateriales() {
		int cantidad=0;
		for(int i=0;i<materiales.length;i++) {
			if(materiales[i]!=null) {
				cantidad++;
			}
		}
		return cantidad;
	}
}
