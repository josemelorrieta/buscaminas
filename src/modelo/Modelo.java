package modelo;

import java.util.ArrayList;

import vista.Boton;

public class Modelo {
	public ArrayList<Boton> casillas = new ArrayList<Boton>();
	public int minasTotales;
	public int minasMarcadas;
	
	public int getMinasTotales() {
		return minasTotales;
	}
	public void setMinasTotales(int minasTotales) {
		this.minasTotales = minasTotales;
	}
	public int getMinasMarcadas() {
		return minasMarcadas;
	}
	public void setMinasMarcadas(int minasMarcadas) {
		this.minasMarcadas = minasMarcadas;
	}

	
}
