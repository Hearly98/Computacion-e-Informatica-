package semana15;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Tienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidad;
	private JComboBox cboMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(306, 11, 118, 23);
		contentPane.add(btnProcesar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 414, 355);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Courier New", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(23, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(23, 40, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(99, 37, 128, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"REXONA", "NIVEA", "GILLETTE"}));
		cboMarca.setBounds(99, 11, 128, 22);
		contentPane.add(cboMarca);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	//declarar variables globales
	int cu0=0,cu1=0,cu2=0;
	double ia0=0,ia1=0,ia2=0;

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declarar variables
		double ipag;
		int can, marca;
		//Entrada
		can=leerCantidad();
		marca=leerMarca();
		//Proceso
		ipag=calcularImportePagar(marca, can);
		efectuarIncrementos(marca,can, ipag);
		//Salida
		mostrarResultados(ipag);
	}
	//Definir los métodos
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	int leerMarca() {
		return cboMarca.getSelectedIndex();
	}
	double calcularImportePagar(int marca, int can) {
		double ia=0;
		switch(marca) {
		case 0: 	ia=7.9*can;	break;
		case 1:		ia=8.6*can;	break;
		default:	ia=9*can;	break;			
		}		
		return ia;
	}
	void efectuarIncrementos(int marca, int can, double ipag) {
		switch(marca) {
		case 0:
		cu0=cu0+can; 	ia0=ia0+ipag;
		break;
		case 1:
		cu1=cu1+can;	ia1=ia1+ipag;
		break;
		case 2:
		cu2=cu2+can;	ia2=ia2+ipag;
		break;
		}
	}
	void mostrarResultados(double ipag) {
		txtS.setText("");
		imprimir("Importe a Pagar: "+ipag);
		imprimir("Cantidad de unidades de la marca Rexona   : "+ cu0);
		imprimir("Cantidad de unidades de la marca Nivea    : "+ cu1);
		imprimir("Cantidad de unidades de la marca Gillette: "+ cu2);
		imprimir("Importe acumulado de la marca Rexona       : "+ ia0);
		imprimir("Importe acumulado de la marca Nivea       : "+ ia1);
		imprimir("Importe acumulado de la marca Gillette   : "+ ia2);		
	}
	

	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
