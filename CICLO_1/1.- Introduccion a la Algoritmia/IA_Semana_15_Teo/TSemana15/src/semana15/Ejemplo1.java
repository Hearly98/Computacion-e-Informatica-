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

public class Ejemplo1 extends JFrame implements ActionListener {

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
					Ejemplo1 frame = new Ejemplo1();
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
	public Ejemplo1() {
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
        int min = 1000, max = 5000, n = 0, suma=0, c1=0, c2=0, c3=0, c4=0;
        txtS.setText("");
        do {
            //generamos los numeros
            n = (int) ((max - min + 1) * Math.random() + min);
            //mostrar los resultados
            imprimir(n + "");
            //sumar numeros
            suma += n;
            //contamos intervalos
            if (n <= 2000)
                c1++;
            else if(n <=3000)
                c2++;
            else if(n <=4000)
                c3++;
            else
                c4++;

        } while (!(n % 3 == 0 && n > 2000 && n < 6000) );
        imprimir("Suma: " + suma);
        imprimir("Cantidad de numeros entre 1000 y 2000: "+ c1);
        imprimir("Cantidad de numeros entre 2001 y 3000: "+ c2);
        imprimir("Cantidad de numeros entre 3001 y 4000: "+ c3);
        imprimir("Cantidad de numeros entre 4001 y 5000: "+ c4);
    }

    void imprimir(String s) {
        txtS.append(s + "\n");


    }
}