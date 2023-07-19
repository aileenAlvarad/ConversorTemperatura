package com.interfaz.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.logica.CalcularTipoDeGradoSeleccionado;
import com.logica.ConversorDeGrados;
import com.logica.ConvertirStringAEnum;
import com.logica.GradosEnum;
import com.logica.Validaciones;

public class ConvertidorTemperaturaPrincipal extends JFrame {

	public JPanel panel;

	private JTextField cantidadGrados = new JTextField();

	public static void main(String[] args) {
		ConvertidorTemperaturaPrincipal convertidorTemp = new ConvertidorTemperaturaPrincipal();
		convertidorTemp.setVisible(true);
	}

	public ConvertidorTemperaturaPrincipal() {
		ImageIcon image = new ImageIcon("C:\\Users\\Aileen\\Downloads\\grados.png"); // create an IageIcon
		this.setIconImage(image.getImage()); // change icon of this
		setSize(500, 360);
		setTitle("Conversor de Grados");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(200, 200));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colocarPaneles();
		iniciarComponentes();
		colocarEtiquetas();
		// convirtiendoMonedas();
		colocarBotones();
	}

	private void iniciarComponentes() {
		colocarPaneles();

	}

	private void colocarPaneles() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 248, 220));
		this.getContentPane().add(panel); //
	}

	private void colocarEtiquetas() {

		JLabel etiquetaBienvenida = new JLabel("Bienvenido al Conversor de temperatura", SwingConstants.CENTER); // creamos
																													// una
																													// etiqueta
		etiquetaBienvenida.setBounds(80, 10, 300, 20);
		etiquetaBienvenida.setHorizontalAlignment(SwingConstants.CENTER); // Establecemos la alineacion horizontal del
																			// texto
		etiquetaBienvenida.setForeground(Color.darkGray); // Establecemos el color de la letra
		etiquetaBienvenida.setFont(new Font("arial", Font.BOLD, 15)); // Establecemos la fuente del texto
		panel.add(etiquetaBienvenida); // agregamos la etiqueta al panel //

		JLabel etiquetaCantidadGrados = new JLabel("Ingresa los grados que deseas convertir", SwingConstants.CENTER);
		etiquetaCantidadGrados.setBounds(80, 40, 300, 20);
		etiquetaCantidadGrados.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCantidadGrados.setForeground(Color.darkGray); // Establecemos el color de la letra
		etiquetaCantidadGrados.setFont(new Font("arial", Font.ITALIC, 13)); // Establecemos la fuente del texto
		panel.add(etiquetaCantidadGrados);

		cantidadGrados.setBounds(80, 60, 300, 28);
		cantidadGrados.setEditable(true);// permite editar o no editar el area de texto
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		cantidadGrados
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(4, 10, 10, 10)));
		panel.add(cantidadGrados);

		JLabel elegirGrado = new JLabel("Elige los grados que deseas convertir", SwingConstants.CENTER); // creamos
																											// una
																											// etiqueta
		elegirGrado.setBounds(80, 100, 300, 20);
		elegirGrado.setHorizontalAlignment(SwingConstants.CENTER); // Establecemos la alineacion horizontal del texto
		elegirGrado.setForeground(Color.darkGray); // Establecemos el color de la letra
		elegirGrado.setFont(new Font("arial", Font.ITALIC, 13)); // Establecemos la fuente del texto
		panel.add(elegirGrado);

	}

	private void colocarBotones() { ///////// Creando botones

		String[] grupoGrados = { GradosEnum.CELSIUS_A_FAHRENHEIT.toString(),
				GradosEnum.FAHRENHEIT_A_CELSIUS.toString() };

		JComboBox listaDesplegableGrados = new JComboBox(grupoGrados);
		listaDesplegableGrados.setBounds(80, 120, 300, 20);

		panel.add(listaDesplegableGrados);
		JButton boton1 = new JButton();
		boton1.setText("Convertir");
		boton1.setBounds(80, 190, 100, 20);
		boton1.setEnabled(true);
		boton1.setForeground(Color.BLACK);
		boton1.setFont(new Font("cooper", Font.BOLD, 12));

		panel.add(boton1);

		// Agregando Evento de tipo ActionLitener
		ActionListener btnConvertir = new ActionListener() {

			@Override // Implementamos el metodo abtracto de ActionEventListener
			public void actionPerformed(ActionEvent e) {
				// Este codigo se jecuta Al precionar el boton
				String stringCantidadGrados = cantidadGrados.getText(); // Obteniendo texto del inputDinero
				boolean esEntero = Validaciones.validarString(stringCantidadGrados);
				JFrame jFrameresultado = new JFrame();

				if (!esEntero) {
					JOptionPane.showMessageDialog(jFrameresultado, "El valor ingresado no es valido", "Error", 0);
					return;
				}

				String valorGradoSeleccionado = listaDesplegableGrados.getSelectedItem().toString(); // Obtenemos el
																										// valor
				// del combobox
				int cantidadDinero = Integer.parseInt(stringCantidadGrados);// Convirtiendo string a entero
				GradosEnum valorEnum = ConvertirStringAEnum.convertir(valorGradoSeleccionado);
				double resultadoGradosConvertidos = ConversorDeGrados.convertir(valorEnum, cantidadDinero);
				String tipoGradoResultado = CalcularTipoDeGradoSeleccionado.calcularTipo(valorGradoSeleccionado);

				BigDecimal bd = new BigDecimal(resultadoGradosConvertidos).setScale(2, RoundingMode.HALF_UP);
				String conFormato = "Tienes " + bd.toString() + " " + tipoGradoResultado;
				JOptionPane.showMessageDialog(jFrameresultado, conFormato, "Mensaje", 3);

				// String list = listaDesplegable.getSelectedItem().toString();
				// System.out.println(list);
				// JFrame jFrame = new JFrame();
				// JOptionPane.showMessageDialog(jFrame, "El valor ingresado no es valido :(",
				// "Error", 0);

				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación",
						JOptionPane.YES_NO_OPTION);

				if (respuesta == JOptionPane.YES_OPTION) {
					System.out.println("El usuario ha elegido continuar.");
				} else {
					System.out.println("El usuario ha elegido no continuar.");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JOptionPane.showMessageDialog(null, "Fin del programa");
					System.exit(1);
				}

			}

			// Fin logica BotonConvertir
		};

		boton1.addActionListener(btnConvertir); // Añade un oyente de accion, en cuanto den click que pase algo

		ActionListener btnCancelar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fin del programa");
				System.exit(1);

			}

		};
		// Boton 2
		JButton botonCancelar = new JButton();
		botonCancelar.setText("Cancelar"); // Establecemos un texto al boton
		botonCancelar.setBounds(280, 190, 100, 20);
		botonCancelar.setEnabled(true); // Habilitar o desabilitar el boton
		botonCancelar.setForeground(Color.BLACK);
		botonCancelar.setFont(new Font("cooper", Font.BOLD, 12));
		botonCancelar.addActionListener(btnCancelar);
		panel.add(botonCancelar);

	}
}
