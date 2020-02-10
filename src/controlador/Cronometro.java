package controlador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.VentanaPpal;

public class Cronometro implements Runnable{
	Thread reloj;
	Integer seg;
	Integer min;
	JLabel lblDigito1, lblDigito2, lblDigito3;
	int digito1, digito2, digito3;
	boolean enMarcha;
	
	public Cronometro(JLabel lblDigito1, JLabel lblDigito2, JLabel lblDigito3) {
		this.reloj = new Thread(this);
		this.lblDigito1 = lblDigito1;
		this.lblDigito2 = lblDigito2;
		this.lblDigito3 = lblDigito3;
		this.seg = 0;
		this.enMarcha = false;
	}
	
	public void run() {
		enMarcha = true;
		while (enMarcha) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			seg++;
			
			digito1 = (int) seg / 100;
			digito2 = (int) (seg % 100) / 10;
			digito3 = (int) (seg % 100) % 10;
			lblDigito1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + digito1 + ".png")));
			lblDigito2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + digito2 + ".png")));
			lblDigito3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d" + digito3 + ".png")));
		}
		seg = 0;
		lblDigito1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblDigito2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblDigito3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
	}
	
	public int getSeg() {
		return this.seg;
	}
	
	public void setSeg(int seg) {
		this.seg = seg;
	}
	
	public boolean isAlive() {
		if (reloj.isAlive())
			return true;
		else
			return false;
	}
	
	public void start() {
		reloj.start();
	}
	
	public void stop() {
		enMarcha= false;
		
	}
}
