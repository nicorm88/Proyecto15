/*
*Nombre: Nicolas Rodriguez Martin
*Clase: 1ºDAM
*Practica 15_1
*/
package centroCultural;

import java.util.Scanner;

public class CentroCultural {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner info=new Scanner(System.in);
		String nombre,apellido1,apellido2;
		
		System.out.println("BIENVENIDOS AL CENTRO CULTURAL:\nPara continuar debe usted ser socio\nIntroduzca su nombre:");
		nombre=info.nextLine();
		System.out.println("Su primer apellido:");
		apellido1=info.nextLine();
		System.out.println("Y su segundo apellido:");
		apellido2=info.nextLine();
		Socio socio1=new Socio(nombre,apellido1,apellido2);
		
		int menu;
		int numPaginas,materialBorrado;
		String titulo,autor,discografica,editorial;
		do {
			System.out.println("ELIJA OPERACION(0 PARA SALIR):\n1-Añadir disco\n2-Añadir libro\n3-Mostrar inventario\n4-Borrar libro/disco\n5-Info del socio");
			menu=info.nextInt();
			switch(menu) {
			case 0:{
				break;
			}
			case 1:{
				if(socio1.getCantidadMateriales()==10) {
					System.out.println("\nYa posee 10 materiales");
				}else {
					System.out.println("Dime el titulo del disco:");
					info.nextLine();
					titulo=info.nextLine();
					System.out.println("Dime el autor del disco:");
					autor=info.nextLine();
					System.out.println("Dime la discografica del disco:");
					discografica=info.nextLine();
					Disco disco1=new Disco(titulo,autor,discografica);
					
					socio1.anadirDisco(disco1);
				}
				break;
			}case 2:{
				if(socio1.getCantidadMateriales()==10) {
					System.out.println("\nYa posee 10 materiales");
				}else {
					System.out.println("Dime el titulo del libro:");
					info.nextLine();
					titulo=info.nextLine();
					System.out.println("Dime el autor del libro:");
					autor=info.nextLine();
					System.out.println("Dime la editorial del libro:");
					editorial=info.nextLine();
					System.out.println("Dime el numero de paginas que tiene el libro:");
					numPaginas=info.nextInt();
					Libro libro1=new Libro(titulo,autor,numPaginas,editorial);
					socio1.anadirLibro(libro1);
				}
				break;
			}case 3:{
				System.out.println("\n"+socio1.infoMateriales()+"\n");
				break;
			}case 4:{
				System.out.println("Dime que material quieres devolver(indicando su posicion):");
				System.out.println("\n"+socio1.infoSimplificadaMateriales()+"\n");
				materialBorrado=info.nextInt();
				if(materialBorrado<1) {
					System.err.println("\n\nNUMERO MAL INTRODUCIDO\n\n");
				}else {
					socio1.borrar(materialBorrado);
				}
				break;
			}case 5:{
				System.out.println("\n"+socio1.infoSocio()+"\n");
				break;
			}default:{
				System.err.println("\n\nNUMERO MAL INTRODUCIDO\n\n");
				break;
			}
			}
		}while(menu!=0);
	}

}
