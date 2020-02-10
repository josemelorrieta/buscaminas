package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Principal {

	public static void main(String[] args) {
		VentanaPpal vistaJuego = new VentanaPpal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vistaJuego);
		
		// Añadir eventos boton al boton de inicio
		controlador.botonInicio();
		// Inicializar las casillas del tablero
		controlador.inicializarCasillas();
		// Poner el juego en su estado inicial
		controlador.inicializarJuego();
		vistaJuego.setVisible(true);
		
	}

}
