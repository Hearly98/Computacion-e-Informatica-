package proyecto;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConsultarLibro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 32705407359759178L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JButton btnCerrar;
	private JLabel lblCodigo;
	private JComboBox<String> cboCodigo;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogoConsultarLibro dialog = new DialogoConsultarLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConsultarLibro() {
		setTitle("Consultar libro");
		setResizable(false);
		setBounds(100, 100, 460, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblCodigo);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 36, 46, 14);
		contentPanel.add(lblTitulo);

		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 61, 46, 14);
		contentPanel.add(lblAutor);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 86, 46, 14);
		contentPanel.add(lblPrecio);

		cboCodigo = new JComboBox<String>();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel<String>(new String[] { "c000", "c001", "c002" }));
		cboCodigo.setBounds(66, 8, 89, 20);
		contentPanel.add(cboCodigo);

		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(66, 33, 219, 20);
		contentPanel.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setBounds(66, 58, 219, 20);
		contentPanel.add(txtAutor);
		txtAutor.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(66, 83, 89, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(345, 7, 89, 23);
		contentPanel.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedCboCodigo(ActionEvent e) {

	}
}
