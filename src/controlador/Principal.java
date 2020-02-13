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
		modelo.calcularCasillas(30, 16);
		modelo.setMinasTotales(99);
		// 9x9 panel3 185x185, panel2 205x205, VentanaPpal 209x279, panel 205x48, panel1 189x32 
		// 16x16 panel3 325x325, panel2
		// 
		vistaJuego.setBounds(100, 100, (modelo.columnasTablero * 20) + 29, (modelo.filasTablero * 20) + 100);
		vistaJuego.panel.setBounds(0, 0, (modelo.columnasTablero * 20) + 25, 48);
		vistaJuego.panel_1.setBounds(8, 8, (modelo.columnasTablero * 20) + 9, 32);
		vistaJuego.panel_2.setBounds(0, 47, (modelo.columnasTablero * 20) + 25, (modelo.filasTablero * 20) + 25);
		vistaJuego.panel_3.setBounds(10, 10, (modelo.columnasTablero * 20) + 5, (modelo.filasTablero * 20) + 5);
		
		// Inicializar las casillas del tablero
		controlador.inicializarCasillas();
		
		// Poner el juego en su estado inicial
		controlador.inicializarJuego();
		
		vistaJuego.setVisible(true);
	}

}
