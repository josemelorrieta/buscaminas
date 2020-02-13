package modelo;

import java.util.ArrayList;

import javax.swing.JLabel;

import vista.Boton;

public class Modelo {
	public ArrayList<Boton> casillas;
	public ArrayList<JLabel> tablero;
	public ArrayList<Integer> minas;
	public ArrayList<Integer> listaMinasMarcadas;
	public int casillasTotales;
	public int minasTotales;
	public int minasMarcadas;
	public int celdasLevantadas;
	public boolean enJuego;
	
	public Modelo() {
		this.enJuego = false;
		this.casillas = new ArrayList<Boton>();
		this.tablero = new ArrayList<JLabel>();
		this.minas = new ArrayList<Integer>();
		this.listaMinasMarcadas = new ArrayList<Integer>();
	}
	
	public int getMinasTotales() {
		return minasTotales;
	}
	public void setMinasTotales(int minasTotales) {
		this.minasTotales = minasTotales;
	}
	public int getMinasMarcadas() {
		return minasMarcadas;
	}
	
	public int casillasTotales() {
		return casillasTotales;
	}
	
	public void setMinasMarcadas(int minasMarcadas) {
		this.minasMarcadas = minasMarcadas;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}
	
	public void setCasillasTotales(int casillasTotales) {
		this.casillasTotales = casillasTotales;
	}
		
}
