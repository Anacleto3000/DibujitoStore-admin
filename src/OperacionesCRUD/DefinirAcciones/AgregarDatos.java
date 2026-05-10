package OperacionesCRUD.DefinirAcciones;

import ConexionBS.ConexionBS_MYSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import Api.ApiClient;
import java.net.URLEncoder;

public class AgregarDatos implements OperacionesCRUD.DeclararAcciones.AgregarDatos {


    public void AgregarProducto(String Nombre, String Descripcion, String Precio, String Stock, String Categoria, String ImagenName) {

        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion()) {
            String SQLtext = "insert into productos (nombre, descripcion, precio, stock, categoria_id, imagen) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);

            instruccion.setString(1, Nombre);
            instruccion.setString(2, Descripcion);
            instruccion.setDouble(3, Double.parseDouble(Precio));
            instruccion.setInt(4, Integer.parseInt(Stock));
            instruccion.setInt(5, Integer.parseInt(Categoria));
            instruccion.setString(6, ImagenName);

            int resultado = instruccion.executeUpdate();
            System.out.println("Producto agregado correctamente por SQL Directo.");
            
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en número: " + e.getMessage());
        }
    }

    public void AgregarCategoria(String nombre, String descripcion,String imagen){
        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            String SQLtext="insert into categorias (nombre, descripcion, imagen) values(?, ?, ?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);

            instruccion.setString(1,nombre);
            instruccion.setString(2,descripcion);
            instruccion.setString(3,imagen);

            int resultado= instruccion.executeUpdate();

        }

        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }



    public void AgregarAnuncio(String nameAD, String nombreImagen){
        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            String SQLtext="insert into anuncios(imagen, nombre) values(?, ?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);
            instruccion.setString(1,nombreImagen);
            instruccion.setString(2,nameAD);

            int resultado= instruccion.executeUpdate();


        }

        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }


    public void AgregarOferta(String nameOfert, String idProducto, String Descuento, String FechaIni, String FechaFin){
        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            String SQLtext="insert into ofertas(producto_id, porcentaje, fecha_inicio, fecha_fin, nombre) values(?,?,?,?,?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);

            Date ConversionFechaIni= Date.valueOf(FechaIni);
            Date ConversionFechaFin= Date.valueOf(FechaFin);

            instruccion.setInt(1,Integer.parseInt(idProducto));
            instruccion.setInt(2,Integer.parseInt(Descuento));
            instruccion.setDate(3,ConversionFechaIni);
            instruccion.setDate(4,ConversionFechaFin);
            instruccion.setString(5,nameOfert);


            int resultado= instruccion.executeUpdate();

        }

        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }




    public void AgregarPromocion(String Nombre, String Descripcion, String Descuento, String FechaInicio, String FechaFin, String imagen){

        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion();){
            String SQLtext="insert into promociones(nombre, descripcion, descuento, fecha_inicio, fecha_fin, imagen ) values(?,?,?,?,?,?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);

            Date ConversionFechaIni= Date.valueOf(FechaInicio);
            Date ConversionFechaFin= Date.valueOf(FechaFin);

            instruccion.setString(1,Nombre);
            instruccion.setString(2,Descripcion);
            instruccion.setInt(3,Integer.parseInt(Descuento));
            instruccion.setDate(4,ConversionFechaIni);
            instruccion.setDate(5,ConversionFechaFin);
            instruccion.setString(6,imagen);

            int resultado= instruccion.executeUpdate();

        }

        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }

    }

    public void AgregarBanner(String nombre_banner, String enlace_final, String ubicacionSQL, String imagen){
        try (Connection conexion=ConexionBS_MYSQL.ObtenerConexion();){
            String SQLtext="insert into Banners(nombre, redireccion, ubicacion, imagen) values(?,?,?,?)";
            PreparedStatement instruccion= conexion.prepareStatement(SQLtext);

            instruccion.setString(1,nombre_banner);
            instruccion.setString(2,enlace_final);
            instruccion.setString(3,ubicacionSQL);
            instruccion.setString(4,imagen);

            int resultado= instruccion.executeUpdate();

        }

        catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }





}
