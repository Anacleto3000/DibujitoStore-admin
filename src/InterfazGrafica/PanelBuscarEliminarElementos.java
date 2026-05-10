package InterfazGrafica;

import OperacionesCRUD.DeclararAcciones.AgregarDatos;
import OperacionesCRUD.DefinirAcciones.BuscarOrEliminarDatos;
import OperacionesCRUD.DefinirAcciones.MostrarDatos;

import javax.swing.*;
import java.awt.*;

public class PanelBuscarEliminarElementos extends JPanel {

    private JTextField txtID;
    private JButton btnBuscar, btnEliminar;



    public PanelBuscarEliminarElementos(String Nombre) {
        initComponents(Nombre);
    }

    private void initComponents(String Nombre) {
        setLayout(new BorderLayout());

        // ================= PANEL IZQUIERDO ====================
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setPreferredSize(new Dimension(350, 0));
        panelIzquierdo.setBackground(new Color(138, 155, 143)); // Verde del diseño
        panelIzquierdo.setLayout(null);

        // ===== Título =====
        JLabel lblTitulo = new JLabel("Buscar o eliminar " + Nombre);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(30, 40, 300, 60);
        panelIzquierdo.add(lblTitulo);

        // ===== Label para ID =====
        JLabel lblID = new JLabel("ID del " + Nombre);
        lblID.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblID.setForeground(Color.WHITE);
        lblID.setBounds(30, 120, 200, 30);
        panelIzquierdo.add(lblID);

        // ===== Campo de texto =====
        txtID = new JTextField();
        txtID.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtID.setBounds(30, 160, 250, 40);
        panelIzquierdo.add(txtID);

        // ===== BOTÓN BUSCAR =====
        btnBuscar = new JButton("Buscar " + Nombre);
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBackground(new Color(194, 181, 199)); // Color lila del diseño
        btnBuscar.setBounds(30, 240, 250, 45);
        panelIzquierdo.add(btnBuscar);





        // ===== BOTÓN ELIMINAR =====
        btnEliminar = new JButton("Eliminar " + Nombre);
        btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(new Color(194, 181, 199));
        btnEliminar.setBounds(30, 310, 250, 45);
        panelIzquierdo.add(btnEliminar);

        add(panelIzquierdo, BorderLayout.WEST);

        // ================= PANEL DERECHO ====================
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(230, 230, 230)); // Gris claro del diseño
        add(panelDerecho, BorderLayout.CENTER);



        //===========================

                                                 //================================


        btnEliminar.addActionListener(e -> {
            BuscarOrEliminarDatos buscaroreliminarDatos= new BuscarOrEliminarDatos();
            int id=Integer.parseInt(txtID.getText());
            buscaroreliminarDatos.EliminarDatos(Nombre,id);
        });




        btnBuscar.addActionListener(e -> {
            BuscarOrEliminarDatos buscaroreliminarDatos= new BuscarOrEliminarDatos();
            int id=Integer.parseInt(txtID.getText());

            if(Nombre.equals("usuarios")){
                panelDerecho.removeAll();
                panelDerecho.add(buscaroreliminarDatos.BuscarDatos("usuarios",id));
                panelDerecho.revalidate();
                panelDerecho.repaint();
            }

             if(Nombre.equals("productos")){
                 panelDerecho.removeAll();
                 panelDerecho.add(buscaroreliminarDatos.BuscarDatos("productos",id));
                 panelDerecho.revalidate();
                 panelDerecho.repaint();


             }


             if(Nombre.equals("categorias")){
                 panelDerecho.removeAll();
                 panelDerecho.add(buscaroreliminarDatos.BuscarDatos("categorias",id));
                 panelDerecho.revalidate();
                 panelDerecho.repaint();

             }


             if(Nombre.equals("anuncios")){
                 panelDerecho.removeAll();
                 panelDerecho.add(buscaroreliminarDatos.BuscarDatos("anuncios",id));
                 panelDerecho.revalidate();
                 panelDerecho.repaint();
             }


             if(Nombre.equals("promociones")){
                 panelDerecho.removeAll();
                 panelDerecho.add(buscaroreliminarDatos.BuscarDatos("promociones", id));
                 panelDerecho.revalidate();
                 panelDerecho.repaint();
             }

             if(Nombre.equals("ofertas")){
                 panelDerecho.removeAll();
                 panelDerecho.add(buscaroreliminarDatos.BuscarDatos("ofertas", id));
                 panelDerecho.revalidate();
                 panelDerecho.repaint();
             }







        });
    }

    // Métodos para obtener valores
    public String getIDProducto() {
        return txtID.getText().trim();
    }

    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnEliminar() { return btnEliminar; }
}
