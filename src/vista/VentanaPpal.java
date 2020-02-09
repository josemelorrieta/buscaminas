package vista;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel[][] tablero;
	public JPanel panel_3;
	public JLabel lblMinas1, lblMinas2, lblMinas3, lblTiempo1, lblTiempo2, lblTiempo3;
	public JButton btnInicio;

	public VentanaPpal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 0, 205, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(8, 8, 189, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblMinas1 = new JLabel("");
		lblMinas1.setBounds(5, 4, 13, 23);
		lblMinas1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		panel_1.add(lblMinas1);
		
		lblMinas2 = new JLabel("");
		lblMinas2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d1.png")));
		lblMinas2.setBounds(18, 4, 13, 23);
		panel_1.add(lblMinas2);
		
		lblMinas3 = new JLabel("");
		lblMinas3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblMinas3.setBounds(31, 4, 13, 23);
		panel_1.add(lblMinas3);
		
		lblTiempo1 = new JLabel("");
		lblTiempo1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblTiempo1.setBounds(145, 4, 13, 23);
		panel_1.add(lblTiempo1);
		
		lblTiempo2 = new JLabel("");
		lblTiempo2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblTiempo2.setBounds(158, 4, 13, 23);
		panel_1.add(lblTiempo2);
		
		lblTiempo3 = new JLabel("");
		lblTiempo3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/d0.png")));
		lblTiempo3.setBounds(171, 4, 13, 23);
		panel_1.add(lblTiempo3);
		
		btnInicio = new JButton("");
		btnInicio.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/face0.png")));
		btnInicio.setBounds(81, 2, 26, 26);
		btnInicio.setFocusPainted(false);
		btnInicio.setMargin(new Insets(0, 0, 0, 0));
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setOpaque(false);
		panel_1.add(btnInicio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(0, 47, 205, 207);
		panel_2.setLayout(null);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 185, 185);
		panel_3.setLayout(null);
		panel_2.add(panel_3);
		
	}
}
