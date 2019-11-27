package vista;

import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	public JButton[][] casillas;
	public JLabel[][] tablero;

	public VentanaPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 0, 208, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(8, 8, 192, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 13, 23);
		lblNewLabel.setIcon(new ImageIcon("C:\\workspace-accesodatos\\BuscaMinas\\imagenes\\d0.png"));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(0, 48, 208, 213);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 188, 191);
		panel_2.add(panel_3);
		inicializarCasillas();
		inicializarTablero();
	}
	
	private void inicializarCasillas() {
		for (int i=0;i<8;i++) {
			for (int j=0;i<8;i++) {
				Button casilla = new Button();
				
			}
		}
	}
	
	private void inicializarTablero() {
		calcularMinas();
	}
	
	private void calcularMinas() {
		
	}
}
