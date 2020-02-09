package controlador;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import modelo.Modelo;
import vista.Boton;
import vista.VentanaPpal;

public class Controlador {
	private VentanaPpal vistaJuego;
	private Modelo modelo;
	
	public Controlador(Modelo modelo, VentanaPpal vistaJuego) {
		this.modelo = modelo;
		this.vistaJuego = vistaJuego;
	}
	
	public void botonInicio() {
		vistaJuego.btnInicio.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face4.png")));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face0.png")));
				inicializarJuego();
			}
			
			
		});
	}
	
	public void inicializarJuago() {
		modelo.setMinasMarcadas(0);
		vistaJuego.panel_3.removeAll();
		//inicializarCasillas();
		vistaJuego.validate();
	}
	
	public void inicializarCasillas() {
		modelo.casillas = new ArrayList<Boton>();
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				Boton casilla = new Boton();
				casilla.setBounds(2 + (20 * j), 2 + (20 * i), 20, 20);
				casilla.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-3_20.png")));
				casilla.setFocusPainted(false);
				casilla.setMargin(new Insets(0, 0, 0, 0));
				casilla.setContentAreaFilled(false);
				casilla.setBorderPainted(false);
				casilla.setOpaque(false);
				casilla.addMouseListener(new casillaML(casilla));
				modelo.casillas.add(casilla);
				vistaJuego.panel_3.add(casilla);
			}
		}
	
	}
	
	private class casillaML implements MouseListener {
		private Boton boton;
		
		public casillaML(Boton boton) {
			this.boton = boton;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if (arg0.getButton() == 1 && !boton.isMarcado()) {
				vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face1.png")));
				boton.setVisible(false);
			}
			if (arg0.getButton() == 3) {
				if (boton.isMarcado()) {
					boton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-3_20.png")));
					boton.setMarcado(false);
					modelo.setMinasMarcadas(modelo.getMinasMarcadas() - 1);
					mostrarMinasMarcadas();
				} else if(modelo.getMinasMarcadas() < 10) {
					boton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-4_20.png")));
					boton.setMarcado(true);
					modelo.setMinasMarcadas(modelo.getMinasMarcadas() + 1);
					mostrarMinasMarcadas();
				}
			}			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face0.png")));
		}
		
	}
	
	private void inicializarTablero() {
		calcularMinas();
	}
	
	private void calcularMinas() {
		
	}
	
	public void inicializarJuego() {
		modelo.setMinasTotales(10);
		modelo.setMinasMarcadas(0);
		
		mostrarMinasMarcadas();
	}
	
	public void mostrarMinasMarcadas() {
		int minas = modelo.getMinasTotales() -  modelo.getMinasMarcadas();
		int primerDigito = (int) minas / 100;
		int segundoDigito = (int) (minas % 100) / 10;
		int tercerDigito = (int) (minas % 100) % 10;
		
		vistaJuego.lblMinas1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + primerDigito + ".png")));
		vistaJuego.lblMinas2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + segundoDigito + ".png")));
		vistaJuego.lblMinas3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + tercerDigito + ".png")));
	}
}
