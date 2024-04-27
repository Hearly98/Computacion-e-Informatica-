package semana04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Caja extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	private JLabel lblLargo;
	private JTextField txtLargo;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblAlto;
	private JTextField txtAlto;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja frame = new Caja();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Caja() {
		setTitle("Caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 89, 414, 92);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
		
		lblLargo = new JLabel("Largo");
		lblLargo.setBounds(10, 11, 46, 14);
		contentPane.add(lblLargo);
		
		txtLargo = new JTextField();
		txtLargo.setBounds(66, 8, 86, 20);
		contentPane.add(txtLargo);
		txtLargo.setColumns(10);
		
		lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(10, 36, 46, 14);
		contentPane.add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(66, 33, 86, 20);
		contentPane.add(txtAncho);
		txtAncho.setColumns(10);
		
		lblAlto = new JLabel("Alto");
		lblAlto.setBounds(10, 61, 46, 14);
		contentPane.add(lblAlto);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(66, 58, 86, 20);
		contentPane.add(txtAlto);
		txtAlto.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtLargo.setText("");
		txtAncho.setText("");
		txtAlto.setText("");
		txtS.setText("");
		txtLargo.requestFocus();
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

	}
}
