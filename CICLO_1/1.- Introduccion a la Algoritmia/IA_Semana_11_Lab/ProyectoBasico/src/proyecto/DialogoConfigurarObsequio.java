package proyecto;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConfigurarObsequio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtObsequio;
	private JLabel lblObsequio;
	private JLabel lblImporteMinimo;
	private JTextField txtImporteMinimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoConfigurarObsequio dialog = new DialogoConfigurarObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarObsequio() {
		setTitle("Configurar obsequio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 408, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblObsequio = new JLabel("Obsequio");
		lblObsequio.setBounds(10, 36, 147, 14);
		contentPanel.add(lblObsequio);

		txtObsequio = new JTextField();
		txtObsequio.setBounds(167, 33, 98, 20);
		contentPanel.add(txtObsequio);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(293, 7, 89, 23);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(293, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
		lblImporteMinimo = new JLabel("Importe a pagar m\u00EDnimo");
		lblImporteMinimo.setBounds(10, 11, 147, 14);
		contentPanel.add(lblImporteMinimo);
		
		txtImporteMinimo = new JTextField();
		txtImporteMinimo.setBounds(167, 8, 98, 20);
		contentPanel.add(txtImporteMinimo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {

	}
}
