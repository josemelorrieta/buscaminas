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
		controlador.menuJuego();
		modelo.calcularCasillas(16, 16);
		modelo.setMinasTotales(40);
		vistaJuego.mntmNivel2.setSelected(true);
		controlador.tamanoVentana();
				
		controlador.resetJuego();
		vistaJuego.setLocationRelativeTo(null);
		vistaJuego.setVisible(true);
	}

}
