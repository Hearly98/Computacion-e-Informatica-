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

public class Ejemplo2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 frame = new Ejemplo2();
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
	public Ejemplo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(10, 11, 118, 23);
		contentPane.add(btnProcesar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 374);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Courier New", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int min = 200, max = 800, n, suma = 0;
		int c0 = 0, c1 = 0;
		txtS.setText("");
		for (int i = 0; i < 5; i++) {
			// Generamos los números
			n = (int) ((max - min + 1) * Math.random() + min);
			// Mostramos los números generados
			imprimir(n + "");
			// Sumamos los números generados
			suma += n;
			// contamos los intervalos
			if (n <= 400)
				c0++;
			else
				c1++;
		}
		imprimir("Suma: " + suma);
		imprimir("Cantidad de números entre 200 y 400: " + c0);
		imprimir("Cantidad de números entre 401 y 800: " + c1);

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

}
