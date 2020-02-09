package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Principal {

	public static void main(String[] args) {
		VentanaPpal vistaJuego = new VentanaPpal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vistaJuego);
		
		controlador.botonInicio();
		controlador.inicializarCasillas();
		vistaJuego.setVisible(true);
		controlador.inicializarJuego();
		
		System.out.println("Fin");
	}

}
