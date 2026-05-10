package InterfazGrafica;

import OperacionesCRUD.DefinirAcciones.MostrarDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JPanel panelTop;
    private JPanel panelLateral;
    private JPanel panelContenido;
    private JPanel panelAcciones;
    private JPanel panelBarraAcciones;

    private JButton btnCerrarSesion;
    private JButton btnAdminClientes;
    private JButton btnAdminProductos;
    private JButton btnAdminPromos;
    private JButton btnAdminOfertas;
    private JButton btnAdminCategorias;
    private JButton btnAdminAnuncios;
    private JButton btnAdminVentas;
    private JButton btnAdminBanners;

    private JButton btnConfig;

    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30));

        // ===================== BARRA SUPERIOR =====================
        panelTop = new JPanel();
        panelTop.setBackground(new Color(80,88,109));
        panelTop.setPreferredSize(new Dimension(0, 80));
        panelTop.setLayout(new BorderLayout());

        // -------- Panel Izquierdo (avatar + usuario) --------
        JPanel panelUsuario = new JPanel();
        panelUsuario.setOpaque(false);
        panelUsuario.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lblAvatar = new JLabel();
        lblAvatar.setPreferredSize(new Dimension(50, 50));
        lblAvatar.setIcon(escalar("Icons/image 18.png", 50, 50));

        JLabel lblUsuario = new JLabel("Usuario: Admin");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));

        panelUsuario.add(lblAvatar);
        panelUsuario.add(lblUsuario);

        // -------- Panel Derecho (cerrar sesión + config) --------
        panelAcciones = new JPanel();
        panelAcciones.setOpaque(false);
        panelAcciones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setPreferredSize(new Dimension(150, 35));
        btnCerrarSesion.setBackground(new Color(210, 210, 210));
        btnCerrarSesion.setForeground(Color.BLACK);
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesion.setBackground(new Color(180, 180, 180));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesion.setBackground(new Color(210, 210, 210));
            }
        });

        btnConfig = new JButton();
        btnConfig.setPreferredSize(new Dimension(40, 40));
        btnConfig.setBackground(new Color(210, 210, 210));
        btnConfig.setFocusPainted(false);
        btnConfig.setBorderPainted(false);
        btnConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfig.setIcon(escalar("Icons/image 19.png", 40, 40));

        panelAcciones.add(btnCerrarSesion);
        panelAcciones.add(btnConfig);

        panelTop.add(panelUsuario, BorderLayout.WEST);
        panelTop.add(panelAcciones, BorderLayout.EAST);

        // ===================== BARRA DE ACCIONES CRUD =====================
        panelBarraAcciones = new JPanel();
        panelBarraAcciones.setBackground(new Color(138, 155, 143));
        panelBarraAcciones.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

        // ===================== CONTENEDOR NORTE =====================
        JPanel panelPadreNorte = new JPanel();
        panelPadreNorte.setLayout(new BorderLayout());

        panelPadreNorte.add(panelTop, BorderLayout.NORTH);
        panelPadreNorte.add(panelBarraAcciones, BorderLayout.CENTER);

        add(panelPadreNorte, BorderLayout.NORTH);

        // ===================== PANEL LATERAL =====================
        panelLateral = new JPanel();
        panelLateral.setBackground(new Color(194, 181, 199));
        panelLateral.setPreferredSize(new Dimension(260, 0));
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));

        panelLateral.add(Box.createVerticalStrut(40));

        btnAdminClientes   = crearBotonLateral("Administrar Usuarios");
        btnAdminProductos  = crearBotonLateral("Administrar Productos");
        btnAdminCategorias = crearBotonLateral("Administrar Categorías");
        btnAdminAnuncios = crearBotonLateral("Administrar Anuncios");
        btnAdminPromos     =crearBotonLateral("Administrar Promociones");
        btnAdminOfertas= crearBotonLateral("Administrar Ofertas");
        btnAdminVentas     = crearBotonLateral("Administrar Ventas");
        btnAdminBanners = crearBotonLateral(("Administrar banners"));

        btnAdminClientes.addActionListener(e -> mostrarAccionesClientes());
        btnAdminProductos.addActionListener(e -> mostrarAccionesProductos());
        btnAdminCategorias.addActionListener(e -> mostrarAccionesCategorias());
        btnAdminAnuncios.addActionListener(e -> mostrarAccionesAnuncios());
        btnAdminPromos.addActionListener(e -> mostrarAccionesPromociones());
        btnAdminOfertas.addActionListener(e -> mostrarAccionesOfertas());
        btnAdminVentas.addActionListener(e -> mostrarAccionesVentas());
        btnAdminBanners.addActionListener(e -> mostrarAccionesBanners());

        panelLateral.add(btnAdminClientes);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminProductos);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminCategorias);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminAnuncios);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminPromos);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminOfertas);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminVentas);
        panelLateral.add(Box.createVerticalStrut(20));
        panelLateral.add(btnAdminBanners);


        add(panelLateral, BorderLayout.WEST);

        // ===================== PANEL PRINCIPAL =====================
        panelContenido = new JPanel();
        panelContenido.setBackground(Color.WHITE);
        panelContenido.setLayout(new BorderLayout());

        JLabel lblBienvenida = new JLabel("Bienvenido, selecciona una opción del menú lateral.",
                SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panelContenido.add(lblBienvenida, BorderLayout.CENTER);

        add(panelContenido, BorderLayout.CENTER);
    }

    // =======================================================
    // MÉTODOS AUXILIARES
    // =======================================================

    private JButton crearBotonLateral(String texto) {
        JButton btn = new JButton(texto);
        btn.setMaximumSize(new Dimension(240, 50));
        btn.setBackground(new Color(210, 210, 210));
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(180, 180, 180));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(210, 210, 210));
            }
        });

        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        return btn;
    }

    public ImageIcon escalar(String ruta, int w, int h) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private JButton crearBotonAccion(String texto) {
        JButton btn = new JButton(texto);
        btn.setPreferredSize(new Dimension(250, 40));
        btn.setBackground(new Color(220, 220, 220));
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(190, 190, 190));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(220, 220, 220));
            }
        });

        return btn;
    }

    private void mostrarAccionesClientes() {
        panelBarraAcciones.removeAll();


        JButton BtnBuscarOREliminarClientes =crearBotonAccion("Buscar o Eliminar Usuarios");
        panelBarraAcciones.add(BtnBuscarOREliminarClientes);
        BtnBuscarOREliminarClientes.addActionListener(e -> mostrarFormularioCentrado(new PanelBuscarEliminarElementos("usuarios")));


        JButton BtnMostrarClientes=crearBotonAccion("Mostrar Usuarios");
        panelBarraAcciones.add(BtnMostrarClientes);
        BtnMostrarClientes.addActionListener(e -> {
            MostrarDatos mostrarDatos =  new MostrarDatos();
            String[] columnas = {"cliente_id", "nombre", "apellido", "Telefono", "correo", "dni"};
            mostrarTablaEnContenido(TablaMostrarDatos.TablaMostrarDatos(columnas, mostrarDatos.MostrarClientes()));
        });

        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();
    }

    private void mostrarAccionesProductos() {
        panelBarraAcciones.removeAll();

        JButton BtnAgregarProducto = crearBotonAccion("Agregar Producto");
        panelBarraAcciones.add(BtnAgregarProducto);
        BtnAgregarProducto.addActionListener(e -> {
            mostrarFormularioCentrado(new PanelAgregarProducto());
        });



        JButton BtnBuscarOREliminarProducto =crearBotonAccion("Buscar o Eliminar Producto");
        panelBarraAcciones.add(BtnBuscarOREliminarProducto);
        BtnBuscarOREliminarProducto.addActionListener(e -> mostrarFormularioCentrado(new PanelBuscarEliminarElementos("productos")));


        JButton BtnMostrarProductos=crearBotonAccion("Mostrar Productos");
        panelBarraAcciones.add(BtnMostrarProductos);
        BtnMostrarProductos.addActionListener(e -> {
            MostrarDatos mostrarDatos = new MostrarDatos();
            String [] columnas = {"ID", "nombre", "Descripcion", "precio", "stock", "categoria_id", "imagen" };
            mostrarTablaEnContenido(TablaMostrarDatos.TablaMostrarDatos(columnas,mostrarDatos.MostrarProductos()));
        });


        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();
    }

    private void mostrarAccionesCategorias() {
        panelBarraAcciones.removeAll();


        JButton BtnAgregarCategoria=crearBotonAccion("Agregar Categoría");
        panelBarraAcciones.add(BtnAgregarCategoria);

        BtnAgregarCategoria.addActionListener(e -> mostrarFormularioCentrado(new PanelAgregarCategoria()));
        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();


        JButton BtnBuscarOREliminarCategoria= crearBotonAccion("Buscar o Eliminar Categoría");
        panelBarraAcciones.add(BtnBuscarOREliminarCategoria);
        BtnBuscarOREliminarCategoria.addActionListener(e -> mostrarFormularioCentrado(new PanelBuscarEliminarElementos("categorias")));

        JButton BtnMostrarCategorias= crearBotonAccion("Mostrar Categorías");

        String [] columnas= {"ID", "nombre", "descripcion","nombre imagen"};
        panelBarraAcciones.add(BtnMostrarCategorias);
        MostrarDatos mostrarDatos = new MostrarDatos();
        BtnMostrarCategorias.addActionListener(e -> mostrarTablaEnContenido(TablaMostrarDatos.TablaMostrarDatos(columnas,mostrarDatos.MostrarCategorias())));

        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();
    }

    private void mostrarAccionesAnuncios(){
        panelBarraAcciones.removeAll();

        JButton BtnAgregarAnuncio= crearBotonAccion("Agregar Anuncio");
        panelBarraAcciones.add(BtnAgregarAnuncio);
        BtnAgregarAnuncio.addActionListener(e -> mostrarFormularioCentrado(new PanelAgregarAnuncio()));
        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();


        JButton BtnEBuscarOrEliminarAnuncio= crearBotonAccion("Buscar o Eliminar Anuncio");
        panelBarraAcciones.add(BtnEBuscarOrEliminarAnuncio);
        BtnEBuscarOrEliminarAnuncio.addActionListener(e ->mostrarFormularioCentrado(new PanelBuscarEliminarElementos("anuncios")));
        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();


        JButton BtnActivarOrDesactivarAnuncios= crearBotonAccion("Activar o desactivar Anuncios");
        panelBarraAcciones.add(BtnActivarOrDesactivarAnuncios);
        BtnActivarOrDesactivarAnuncios.addActionListener(e -> mostrarFormularioCentrado(Herramientas.crearPanelActivarOrDesactivarElementos("anuncios")));
        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();


    }

    private void mostrarAccionesPromociones(){
        panelBarraAcciones.removeAll();

        JButton BtnAgregarPromo= crearBotonAccion("Agregar Promocion");
        panelBarraAcciones.add(BtnAgregarPromo);
        BtnAgregarPromo.addActionListener(e -> mostrarFormularioCentrado(new PanelAgregarPromocion()));

        JButton BtnBuscarOREliminarPromo=crearBotonAccion("Buscar o Eliminar Promocion");
        panelBarraAcciones.add(BtnBuscarOREliminarPromo);
        BtnBuscarOREliminarPromo.addActionListener(e -> mostrarFormularioCentrado(new PanelBuscarEliminarElementos("promociones")));


        JButton BtnMostrarPromos=crearBotonAccion("Mostrar Promociones");
        panelBarraAcciones.add(BtnMostrarPromos);
        BtnMostrarPromos.addActionListener(e -> {
            MostrarDatos mostrarDatos = new MostrarDatos();
            String [] Columnas={"ID", "Nombre", "Descripcion", "Descuento", "Fecha de Inicio", "Fecha de Fin", "Estado"};
            mostrarTablaEnContenido(TablaMostrarDatos.TablaMostrarDatos(Columnas,mostrarDatos.MostrarPromociones()));
        });

        JButton BtnActivarOrDesactivarPromociones= crearBotonAccion("Activar o Desactivar Promociones");
        panelBarraAcciones.add(BtnActivarOrDesactivarPromociones);
        BtnActivarOrDesactivarPromociones.addActionListener(e -> {
            mostrarFormularioCentrado(Herramientas.crearPanelActivarOrDesactivarElementos("promociones"));});


        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();



    }


    private void mostrarAccionesOfertas(){
        panelBarraAcciones.removeAll();
        JButton BtnAgregarOferta= crearBotonAccion("Agregar Oferta");
        panelBarraAcciones.add(BtnAgregarOferta);

        BtnAgregarOferta.addActionListener(e -> mostrarFormularioCentrado(new PanelAgregarOferta()));


        JButton BtnActivarOrDesactivarOfertas= crearBotonAccion("Activar o Desactivar Ofertas");
        panelBarraAcciones.add(BtnActivarOrDesactivarOfertas);
        BtnActivarOrDesactivarOfertas.addActionListener(e ->
                mostrarFormularioCentrado(Herramientas.crearPanelActivarOrDesactivarElementos("ofertas")));

        JButton BtnBuscarOREliminarOferta = crearBotonAccion("Buscar o Eliminar Oferta");
        panelBarraAcciones.add(BtnBuscarOREliminarOferta);
        BtnBuscarOREliminarOferta.addActionListener(e -> mostrarFormularioCentrado(new PanelBuscarEliminarElementos("ofertas")));

        JButton BtnMostrarOfertas = crearBotonAccion("Mostrar Ofertas");
        panelBarraAcciones.add(BtnMostrarOfertas);
        BtnMostrarOfertas.addActionListener(e -> {
            MostrarDatos mostrarDatos = new MostrarDatos();
            String[] columnas = {"ID", "Nombre", "Descuento", "Fecha Inicio", "Fecha Fin", "Estado"};
            mostrarTablaEnContenido(TablaMostrarDatos.TablaMostrarDatos(columnas, mostrarDatos.MostrarOfertas()));
        });

        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();
    }

    private void mostrarAccionesVentas() {
        panelBarraAcciones.removeAll();

        panelBarraAcciones.add(crearBotonAccion("Historial de Ventas"));

        panelBarraAcciones.revalidate();
        panelBarraAcciones.repaint();
    }

    private void mostrarAccionesBanners(){
       panelBarraAcciones.removeAll();
       JButton BtnAgregarBanner=crearBotonAccion("Agregar Banner");
       panelBarraAcciones.add(BtnAgregarBanner);

       BtnAgregarBanner.addActionListener(e -> mostrarFormularioCentrado(new PanelAgregarBanner()));

       JButton BtnActivarOrDesactivarBanners = crearBotonAccion("Activar o Desactivar Banners");
       panelBarraAcciones.add(BtnActivarOrDesactivarBanners);
       BtnActivarOrDesactivarBanners.addActionListener(e -> mostrarFormularioCentrado(Herramientas.crearPanelActivarOrDesactivarElementos("Banners")));

       panelBarraAcciones.revalidate();
       panelBarraAcciones.repaint();
    }

    private void mostrarFormularioCentrado(JPanel formulario) {

        formulario.setPreferredSize(new Dimension(900, 500)); // tamaño visible

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(new Color(240, 240, 240));

        wrapper.add(formulario);

        panelContenido.removeAll();
        panelContenido.add(wrapper, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }


    private void mostrarTablaEnContenido(JScrollPane tabla) {
        panelContenido.removeAll();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.add(tabla, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }









}
