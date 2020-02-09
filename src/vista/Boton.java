package vista;

import javax.swing.JButton;

public class Boton extends JButton{
	
	private static final long serialVersionUID = 1L;
	private boolean marcado;
	
	public Boton() {
		super();
		this.marcado = false;
	}
	
	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}
	
	public boolean isMarcado() {
		return this.marcado;
	}
	
}
