package controlador;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Modelo;
import vista.Boton;
import vista.VentanaPpal;

public class Controlador {
	private VentanaPpal vistaJuego;
	private Modelo modelo;
	private Cronometro tiempo;
	private boolean inicializado;
	
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
	
	public void inicializarJuego() {
		modelo.setMinasMarcadas(0);
		modelo.celdasLevantadas = 0;
		modelo.listaMinasMarcadas.clear();
		modelo.setEnJuego(false);
		
		tiempo = new Cronometro(vistaJuego.lblTiempo1, vistaJuego.lblTiempo2, vistaJuego.lblTiempo3, modelo);
		tiempo.inicializarReloj();
		
		mostrarMinasMarcadas();
		inicializarTablero();
		for (Component casilla : vistaJuego.panel_3.getComponents()) {
			if (casilla instanceof Boton) {
				((Boton) casilla).setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-3_20.png")));
				((Boton) casilla).setMarcado(false);
				casilla.setVisible(true);
			}
		}
		inicializado = true;
	}
	
	public void inicializarCasillas() {		
		for (int i=0;i<modelo.filasTablero;i++) {
			for (int j=0;j<modelo.columnasTablero;j++) {
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
			if (!modelo.isEnJuego() && inicializado) {
				modelo.setEnJuego(true);
				tiempo.start();
			}
			
			if (arg0.getButton() == 1 && !boton.isMarcado()) {
				if (modelo.isEnJuego()) {
					vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face1.png")));
				}
			}
			if (arg0.getButton() == 3) {
				if (boton.isMarcado()) {
					boton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-3_20.png")));
					boton.setMarcado(false);
					modelo.setMinasMarcadas(modelo.getMinasMarcadas() - 1);
					modelo.tablero.get(modelo.casillas.indexOf(boton)).setText("");
					mostrarMinasMarcadas();
				} else if(modelo.getMinasMarcadas() < modelo.minasTotales) {
					boton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-4_20.png")));
					boton.setMarcado(true);
					modelo.setMinasMarcadas(modelo.getMinasMarcadas() + 1);
					modelo.tablero.get(modelo.casillas.indexOf(boton)).setText("X");
					mostrarMinasMarcadas();
					modelo.listaMinasMarcadas.add(modelo.casillas.indexOf(boton));
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			if (arg0.getButton() == 1 && modelo.isEnJuego()) {
				vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face0.png")));
				if (!modelo.tablero.get(modelo.casillas.indexOf(boton)).getText().equals("X"))
					levantarCasilla(modelo.casillas.indexOf(boton));
					if (modelo.celdasLevantadas == modelo.casillasTotales - modelo.minasTotales) {
						finalizarJuego("casillas");
					}
			}
		}
		
	}
	
	private void inicializarTablero() {
		crearCeldas();
		for (Component celda : vistaJuego.panel_3.getComponents()) {
			if (celda instanceof JLabel) {
				((JLabel) celda).setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t0_20.png")));
				((JLabel) celda).setText("");
			}
		}
		calcularMinas();
		
		posicionarMinas();
		
		calcularCeldas();
	}
	
	public void crearCeldas() {
		for (int i=0;i<modelo.casillasTotales;i++) {
			JLabel celda = new JLabel();
			int posX = (i % modelo.columnasTablero) * 20;
			int posY = ((int)(i / modelo.columnasTablero)) * 20;
			celda.setBounds(posX, posY, 20, 20);
			celda.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t0_20.png")));
			modelo.tablero.add(celda);
			vistaJuego.panel_3.add(celda);
		}
	}
	
	private void calcularMinas() {
		Random rand = new Random();
		int nuevaMina;
		modelo.minas.clear();
		
		while (modelo.minas.size() < modelo.minasTotales) {
			nuevaMina = rand.nextInt(modelo.casillasTotales);
			if (!modelo.minas.contains(nuevaMina)) {
				modelo.minas.add(nuevaMina);
			}
		}		
	}
	
	private void posicionarMinas() {
		for (int i=0;i<modelo.minas.size();i++) {
			modelo.tablero.get(modelo.minas.get(i)).setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-1_20.png")));
			modelo.tablero.get(modelo.minas.get(i)).setText("M");
		}
	}
	
	private void calcularCeldas() {
		int minas;
		for (int i=0;i<modelo.tablero.size();i++) {
			if (!modelo.tablero.get(i).getText().equals("M")) {
				 minas = contarMinasCercanas(i);
				 modelo.tablero.get(i).setIcon(new ImageIcon (VentanaPpal.class.getResource("/images/t" + minas + "_20.png")));
				 modelo.tablero.get(i).setText(minas + "");
			}
		}
	}
	
	private int contarMinasCercanas(int pos) {
		int minas = 0;
		int filas = modelo.filasTablero;
		int columnas = modelo.columnasTablero;
		
		if (hayMina(pos, -(columnas + 1)) && (pos % columnas) > 0 && (int)(pos / columnas) > 0) {
			minas ++;
		}
		
		if (hayMina(pos, -(columnas)) && (int)(pos / columnas) > 0) {
			minas ++;
		}
		
		if (hayMina(pos, -(columnas - 1)) && (pos % columnas) < (columnas - 1) && (int)(pos / columnas) > 0) {
			minas ++;
		}
		
		if (hayMina(pos, -1)  && (pos % columnas) > 0) {
			minas ++;
		}
		
		if (hayMina(pos, 1)  && (pos % columnas) < (columnas - 1)) {
			minas ++;
		}
		
		if (hayMina(pos, (columnas - 1))  && (pos % columnas) > 0 && (int)(pos / columnas) < (filas - 1)) {
			minas ++;
		}
		
		if (hayMina(pos, columnas) && (int)(pos / columnas) < (filas - 1)) {
			minas ++;
		}
		
		if (hayMina(pos, (columnas + 1)) && (pos % columnas) < (columnas - 1) && (int)(pos / columnas) < (filas - 1)) {
			minas ++;
		}
		
		return minas;
	}
	
	private boolean hayMina (int pos, int offset) {
		try {
			if (modelo.tablero.get(pos + offset).getText().equals("M"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	private void mostrarMinasMarcadas() {
		int minas = modelo.getMinasTotales() -  modelo.getMinasMarcadas();
		int primerDigito = (int) minas / 100;
		int segundoDigito = (int) (minas % 100) / 10;
		int tercerDigito = (int) (minas % 100) % 10;
		
		vistaJuego.lblMinas1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + primerDigito + ".png")));
		vistaJuego.lblMinas2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + segundoDigito + ".png")));
		vistaJuego.lblMinas3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + tercerDigito + ".png")));
	}
	
	private void levantarCasilla(int posCasilla) {
		modelo.casillas.get(posCasilla).setVisible(false);
		modelo.celdasLevantadas ++;

		if (modelo.tablero.get(posCasilla).getText().equals("M")) {
			minaExplota(posCasilla);
		} else if (modelo.tablero.get(posCasilla).getText().equals("0")) {
			levantarHueco(posCasilla);
		}		
	}
	
	private void minaExplota(int posCasilla) {
		modelo.tablero.get(posCasilla).setIcon(new ImageIcon (VentanaPpal.class.getResource("/images/t-2_20.png")));
		vistaJuego.btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face2.png")));
		modelo.setEnJuego(false);
		inicializado = false;
		levantarTodasLasMinas();
	}
	
	private void levantarHueco(int pos) {
		int filas = modelo.filasTablero;
		int columnas = modelo.columnasTablero;
		
		if ((pos % columnas) > 0 && (int)(pos / columnas) > 0) {
			if (modelo.casillas.get(pos - (columnas + 1)).isVisible() == true)
				levantarCasilla(pos - (columnas + 1));
		}
		
		if ((int)(pos / columnas) > 0) {
			if (modelo.casillas.get(pos - columnas).isVisible() == true)
				levantarCasilla(pos - columnas);
		}
		
		if ((pos % columnas) < (columnas - 1) && (int)(pos / columnas) > 0) {
			if (modelo.casillas.get(pos - (columnas - 1)).isVisible() == true)
				levantarCasilla(pos - (columnas -1));
		}
		
		if ((pos % columnas) > 0) {
			if (modelo.casillas.get(pos - 1).isVisible() == true)
				levantarCasilla(pos - 1);
		}
		
		if ((pos % columnas) < (columnas -1)) {
			if (modelo.casillas.get(pos + 1).isVisible() == true)
				levantarCasilla(pos + 1);
		}
		
		if ((pos % columnas) > 0 && (int)(pos / columnas) < filas - 1) {
			if (modelo.casillas.get(pos + (columnas - 1)).isVisible() == true)
				levantarCasilla(pos + (columnas - 1));
		}
		
		if ((int)(pos / columnas) < (filas - 1)) {
			if (modelo.casillas.get(pos + columnas).isVisible() == true)
				levantarCasilla(pos + columnas);
		}
		
		if ((pos % columnas) < (columnas - 1) && (int)(pos / columnas) < (filas - 1)) {
			if (modelo.casillas.get(pos + (columnas + 1)).isVisible() == true)
				levantarCasilla(pos + (columnas + 1));
		}
		
	}
	
	private void levantarTodasLasMinas() {
		for (int i=0;i<modelo.casillasTotales;i++) {
			if (modelo.minas.contains(i) && !modelo.tablero.get(i).getText().equals("X")) {
				modelo.casillas.get(i).setVisible(false);
			}
			if (!modelo.minas.contains(i) && modelo.tablero.get(i).getText().equals("X")) {
				modelo.casillas.get(i).setVisible(false);
				modelo.tablero.get(i).setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-5_20.png")));
			}
		}
		finalizarJuego("pierde");
	}
	
//	private boolean comprobarFin() {
//		if (modelo.minasMarcadas == 10) {
//			for (int mina : modelo.listaMinasMarcadas) {
//				if (!modelo.minas.contains(mina)) {
//					return false;
//				}
//			}
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	private void finalizarJuego(String caso) {
		if (caso.equals("minas")) {
			for (Component casilla : vistaJuego.panel_3.getComponents()) {
				if (casilla instanceof Boton && !(modelo.tablero.get(modelo.casillas.indexOf((Boton) casilla)).getText().equals("X"))) {
					((Boton) casilla).setVisible(false);
				}
			}
		}
		
		if (caso.equals("casillas")) {
			for (Component casilla : vistaJuego.panel_3.getComponents()) {
				if (casilla instanceof Boton && casilla.isVisible()) {
					((Boton) casilla).setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/t-4_20.png")));
				}
			}
			modelo.setMinasMarcadas(modelo.minasTotales);
			mostrarMinasMarcadas();
		}
		
		modelo.enJuego = false;
		if (!caso.equals("pierde"))
			vistaJuego.btnInicio.setIcon(new ImageIcon (VentanaPpal.class.getResource("/images/face3.png")));
	}
	
}
