package semana05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Yogurt extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yogurt frame = new Yogurt();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Yogurt() {
		setTitle("Yogurt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 87, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Laive", "Gloria", "Pura Vida", "Milkito" }));
		cboMarca.setBounds(107, 8, 100, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(107, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int modelo = cboMarca.getSelectedIndex();
		int cantidad = Integer.parseInt(txtCantidad.getText());
		double importeCompra = 0, descuento = 0, importePagar = 0;
		int caramelos = 0;
		
		if (modelo == 0) {
			importeCompra = cantidad * 5.4;
			 caramelos = 2;
		} else if (modelo == 1) {
			importeCompra = cantidad * 5.7;
			caramelos = 3;
		} else if (modelo == 2) {
			importeCompra = cantidad * 4.8;
			caramelos = 4;
		} else if (modelo == 3) {
			importeCompra = cantidad * 5.3;
			caramelos = 5;
		} 
	
		
		if (cantidad < 5) {
			descuento = importeCompra * 0.05;
		} else if (cantidad >= 3 && cantidad <10) {
			descuento = importeCompra * 0.07;
		} else if (cantidad >= 10 && cantidad <20) {
			descuento = importeCompra * 0.09;
		} else if (cantidad >= 20) {
			descuento = importeCompra * 0.11;
		}
		
		importePagar = importeCompra - descuento;
		
		if (importePagar < 200) {
			caramelos = cantidad * 1;
		} else if (importePagar >= 200 && importePagar < 500) {
			caramelos = cantidad * 2;
		} else if (importePagar >= 500 && importePagar < 700) {
			caramelos = 8;
		} else if (importePagar >= 700) {
			caramelos = 10;
		}
		
		txtS.setText("Importe de compra\t: "+ importeCompra + "\n");
		txtS.append("Descuento\t\t: "+ descuento + "\n");
		txtS.append("Importe a pagar\t\t: "+ importePagar + "\n");
		txtS.append("Caramelos\t\t: "+ caramelos + "\n");
	}
}

