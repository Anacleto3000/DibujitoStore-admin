package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarBanner extends JPanel {

    private String nombreImagenBanner;

    public PanelAgregarBanner() {

        setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        // ===== CONTENEDOR CENTRAL =====
        JPanel contenido = new JPanel();
        contenido.setOpaque(false);
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        add(contenido, BorderLayout.CENTER);

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Agregar Nuevo Banner");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblTitulo);

        contenido.add(Box.createVerticalStrut(30));

        // ===== CAMPO NOMBRE =====
        JLabel lblNombre = new JLabel("Nombre del Banner");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblNombre);

        contenido.add(Box.createVerticalStrut(8));

        JTextField txtNombre = new JTextField();
        txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        contenido.add(txtNombre);

        contenido.add(Box.createVerticalStrut(20));

        // ===== MENÚ DESPLEGABLE DE REDIRECCIÓN =====
        JLabel lblRedireccion = new JLabel("El banner redirige a:");
        lblRedireccion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblRedireccion.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblRedireccion);

        contenido.add(Box.createVerticalStrut(8));

        String[] opcionesRedireccion = {"Seleccionar...", "Producto Individual", "Conjunto de Productos"};
        JComboBox<String> cmbRedireccion = new JComboBox<>(opcionesRedireccion);
        cmbRedireccion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        cmbRedireccion.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(cmbRedireccion);

        // ===== CAMPO ID DESTINO (DINÁMICO) =====
        JPanel panelDestino = new JPanel();
        panelDestino.setOpaque(false);
        panelDestino.setLayout(new BoxLayout(panelDestino, BoxLayout.Y_AXIS));
        panelDestino.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelDestino.setVisible(false);

        panelDestino.add(Box.createVerticalStrut(20));

        JLabel lblIDDestino = new JLabel("ID del Destino:");
        lblIDDestino.setFont(new Font("Arial", Font.PLAIN, 14));
        lblIDDestino.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelDestino.add(lblIDDestino);

        panelDestino.add(Box.createVerticalStrut(8));

        JTextField txtIDDestino = new JTextField();
        txtIDDestino.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        panelDestino.add(txtIDDestino);
        
        contenido.add(panelDestino);

        // Agregamos el listener para mostrar/ocultar dinámicamente
        cmbRedireccion.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                int index = cmbRedireccion.getSelectedIndex();
                if (index == 1) {
                    lblIDDestino.setText("ID del Producto a redirigir:");
                    panelDestino.setVisible(true);
                } else if (index == 2) {
                    lblIDDestino.setText("ID de la Categoría / Conjunto a redirigir:");
                    panelDestino.setVisible(true);
                } else {
                    panelDestino.setVisible(false);
                    txtIDDestino.setText("");
                }
                // Refrescar el diseño de la pantalla
                contenido.revalidate();
                contenido.repaint();
            }
        });

        contenido.add(Box.createVerticalStrut(20));

        // ===== UBICACIÓN DEL BANNER (Botones de opción) =====
        JLabel lblUbicacion = new JLabel("Ubicación del banner:");
        lblUbicacion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUbicacion.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblUbicacion);

        contenido.add(Box.createVerticalStrut(8));

        JRadioButton rbPrincipal = new JRadioButton("Contenedor Principal");
        JRadioButton rbSecundario = new JRadioButton("Contenedor Secundario");
        JRadioButton rbExtra = new JRadioButton("Contenedor Extra");
        
        rbPrincipal.setFocusPainted(false);
        rbSecundario.setFocusPainted(false);
        rbExtra.setFocusPainted(false);

        // Agruparlos para que solo se pueda seleccionar uno
        ButtonGroup grupoUbicacion = new ButtonGroup();
        grupoUbicacion.add(rbPrincipal);
        grupoUbicacion.add(rbSecundario);
        grupoUbicacion.add(rbExtra);

        // Contenedor horizontal para los botones
        JPanel panelUbicacion = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelUbicacion.setOpaque(false);
        panelUbicacion.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelUbicacion.add(rbPrincipal);
        panelUbicacion.add(rbSecundario);
        panelUbicacion.add(rbExtra);

        contenido.add(panelUbicacion);

        contenido.add(Box.createVerticalStrut(30));

        // ===== BOTÓN IMPORTAR IMAGEN =====
        JButton btnImportar = new JButton("Importar imagen del Banner");
        btnImportar.setFocusPainted(false);
        btnImportar.setBackground(new Color(220, 220, 220));
        btnImportar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImportar.setMaximumSize(new Dimension(260, 45));
        contenido.add(btnImportar);

        contenido.add(Box.createVerticalStrut(40));

        // ===== BOTÓN AGREGAR BANNER =====
        JButton btnAgregar = new JButton("Agregar Banner");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBackground(new Color(120, 120, 120));
        btnAgregar.setForeground(Color.BLACK);
        btnAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAgregar.setMaximumSize(new Dimension(220, 45));
        contenido.add(btnAgregar);

        // ===== EVENTOS =====
        btnImportar.addActionListener(e -> {
            // Reutilizamos el método de Herramientas que ya tienes en tu proyecto
            nombreImagenBanner = Herramientas.seleccionarImagen(this, "Banner");
        });

        btnAgregar.addActionListener(e -> {

            String nombreBanner = txtNombre.getText().trim();
            String tipoRedireccion = (String) cmbRedireccion.getSelectedItem();
            String idDestino = txtIDDestino.getText().trim();

            String ubicacionSeleccionada = "";
            if (rbPrincipal.isSelected()) ubicacionSeleccionada = "Contenedor Principal";
            else if (rbSecundario.isSelected()) ubicacionSeleccionada = "Contenedor Secundario";
            else if (rbExtra.isSelected()) ubicacionSeleccionada = "Contenedor Extra";

            // Enviar todo al validador de la capa Lógica
            boolean exito = Logica.ValidarEntradaBanners.ValidarEntradasForAddBanner(
                    nombreBanner, 
                    cmbRedireccion.getSelectedIndex(), 
                    tipoRedireccion, 
                    idDestino, 
                    ubicacionSeleccionada, 
                    nombreImagenBanner
            );

            // Si la lógica indica que todo fue un éxito, limpiamos el panel visual
            if (exito) {
                txtNombre.setText("");
                cmbRedireccion.setSelectedIndex(0);
                txtIDDestino.setText(""); // El listener ocultará el panel entero
                grupoUbicacion.clearSelection();
                nombreImagenBanner = null;
            }
        });
    }
}
