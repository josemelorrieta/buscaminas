package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	public Button[][] casillas;
	public Label[][] tablero;

	public VentanaPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 30, 23);
		btnNewButton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/imagenes/t-3.png")));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaPpal.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		lblNewLabel.setBounds(86, 76, 46, 14);
		contentPane.add(lblNewLabel);
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
