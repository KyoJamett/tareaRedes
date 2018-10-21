package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;

	public VentanaPrincipal() {
		setTitle("Server");
		initComponents();
		createEvents();
	}
	
	public void initComponents() {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setForeground(Color.CYAN);
		textPane.setBackground(Color.BLACK);
		textPane.setBounds(0, 0, 434, 261);
		textPane.setEditable(false);
		contentPane.add(textPane);
		
	}
	
	public void createEvents() {
		
	}
	
	public void modificarTexto(String s) {
		textPane.setText(textPane.getText() + "\n" + s);
	}
}
