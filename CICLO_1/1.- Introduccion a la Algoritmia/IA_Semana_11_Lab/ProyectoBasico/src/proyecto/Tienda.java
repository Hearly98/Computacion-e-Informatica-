package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Tienda extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnuArchivo;
	private JMenuItem mnuSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenuItem mntmListar;
	private JMenu mnConfigurar;
	private JMenuItem mntmConfigurarObsequio;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setLocationRelativeTo(null);
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
	public Tienda() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 401);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnuArchivo = new JMenu("Archivo");
		menuBar.add(mnuArchivo);

		mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuArchivo.add(mnuSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);
		
		mnConfigurar = new JMenu("Configurar");
		menuBar.add(mnConfigurar);
		
		mntmConfigurarObsequio = new JMenuItem("Configurar obsequio");
		mntmConfigurarObsequio.addActionListener(this);
		mnConfigurar.add(mntmConfigurarObsequio);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmConfigurarObsequio) {
			actionPerformedMntmConfigurarObsequio(arg0);
		}
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		if (arg0.getSource() == mnuSalir) {
			actionPerformedMnuSalir(arg0);
		}
	}

	protected void actionPerformedMnuSalir(ActionEvent arg0) {
		System.exit(0);
	}

	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		DialogoConsultarLibro d = new DialogoConsultarLibro();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmAcercaDeTienda(ActionEvent arg0) {
		DialogoAcercaDeTienda d = new DialogoAcercaDeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmListar(ActionEvent arg0) {
		DialogoListar d = new DialogoListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent arg0) {
		DialogoConfigurarObsequio d = new DialogoConfigurarObsequio();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}