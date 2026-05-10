package Logica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;

public class ValidarEntradaBanners {

    /**
     * Valida las entradas para el banner y procede a guardar en la base de datos si son correctas.
     * Retorna true si el guardado fue exitoso, útil para que la vista limpie los campos.
     */
    public static boolean ValidarEntradasForAddBanner(String nombreBanner, int indexRedireccion, String tipoRedireccion, String idDestino, String ubicacionSeleccionada, String nombreImagenBanner) {

        if (!Herramientas.ValidarEntradas(nombreBanner, Herramientas.TipoValidacion.LETRAS_NUMEROS)) {
            JOptionPane.showMessageDialog(null, "El nombre del banner debe contener solo letras y números o no debe estar vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (indexRedireccion == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar a dónde redirige el banner.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!Herramientas.ValidarEntradas(idDestino, Herramientas.TipoValidacion.SOLO_NUMEROS)) {
            JOptionPane.showMessageDialog(null, "Debes ingresar únicamente números válidos en el ID de destino.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (ubicacionSeleccionada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una ubicación para el banner.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (nombreImagenBanner == null || nombreImagenBanner.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debes importar una imagen.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // CONSTRUIR EL ENLACE DE REDIRECCIÓN (Estrategia 1: Guardar URL directamente)
        String enlaceFinal = "";
        if (indexRedireccion == 1) { // Producto
            enlaceFinal = "Producto.php?id=" + idDestino;
        } else if (indexRedireccion == 2) { // Conjunto/Categoría
            enlaceFinal = "ResultadoProductos.php?categoria_id=" + idDestino;
        }

        // Formatear la ubicación para que coincida con el ENUM de la base de datos
        String ubicacionSQL = "";
        switch(ubicacionSeleccionada) {
            case "Contenedor Principal": ubicacionSQL = "contenedor_principal"; break;
            case "Contenedor Secundario": ubicacionSQL = "contenedor_secundario"; break;
            case "Contenedor Extra": ubicacionSQL = "contenedor_extra"; break;
        }

        // --- VERIFICACIÓN DE EXISTENCIA EN BASE DE DATOS ---
        try (java.sql.Connection conexion = ConexionBS.ConexionBS_MYSQL.ObtenerConexion()) {
            String tabla = (indexRedireccion == 1) ? "productos" : "categorias";
            String query = "SELECT id FROM " + tabla + " WHERE id = ?";
            try (java.sql.PreparedStatement instruccion = conexion.prepareStatement(query)) {
                instruccion.setInt(1, Integer.parseInt(idDestino));
                try (java.sql.ResultSet rs = instruccion.executeQuery()) {
                    if (!rs.next()) {
                        String tipoItem = (indexRedireccion == 1) ? "El producto" : "La categoría / conjunto";
                        JOptionPane.showMessageDialog(null, "¡" + tipoItem + " con el ID " + idDestino + " no existe!\nPor favor ingresa un ID válido.", "Registro Denegado", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia en la base de datos: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // --- GUARDAR EN LA BASE DE DATOS ---
        AgregarDatos agregarDatos = new AgregarDatos();
        agregarDatos.AgregarBanner(nombreBanner, enlaceFinal, ubicacionSQL, nombreImagenBanner);
        

        // Mensaje temporal de éxito
        JOptionPane.showMessageDialog(null,
                "¡Simulación exitosa!\n\nNombre: " + nombreBanner 
                + "\nEnlace Final (A guardar en BD): " + enlaceFinal 
                + "\nUbicación (Lista para SQL): " + ubicacionSQL 
                + "\nImagen: " + nombreImagenBanner,
                "Banner Listo",
                JOptionPane.INFORMATION_MESSAGE);

        return true;
    }
}
