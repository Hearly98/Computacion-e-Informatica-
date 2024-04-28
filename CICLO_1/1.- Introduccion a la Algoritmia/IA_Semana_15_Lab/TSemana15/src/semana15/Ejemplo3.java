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

public class Ejemplo3 extends JFrame implements ActionListener {

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
					Ejemplo3 frame = new Ejemplo3();
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
	public Ejemplo3() {
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
		int numr=40,denr=5;
		double suma=0;
		for(int i=0;i<30;i++) {
			suma+=(numr/(denr*1.0));
			numr-=3;
			denr+=5;
			imprimir(numr+"/"+denr);
			
		}
		imprimir("Suma: "+suma);
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

}
