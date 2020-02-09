package controlador;

import vista.VentanaPpal;

public class Principal {

	public static void main(String[] args) {
		VentanaPpal juego = new VentanaPpal();
		
		juego.inicializarCasillas();
		juego.setVisible(true);
		
		System.out.println("Fin");
	}

}
