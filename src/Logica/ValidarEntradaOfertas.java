package Logica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;

public class ValidarEntradaOfertas {
   public static void ValidarEntradasForAddOfertas(String nombre,String idProducto
           , String Descuento,String FechaInicio, String FechaFin){

       if(!Herramientas.ValidarEntradas(nombre,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese solo letras y numeros");
           return;
       }

       if(!Herramientas.ValidarEntradas(idProducto,Herramientas.TipoValidacion.SOLO_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese unicamente numeros");
           return;
       }

       if(!Herramientas.ValidarEntradas(Descuento,Herramientas.TipoValidacion.SOLO_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese solo numeros");
           return;
       }

       if(!Herramientas.ValidarEntradas(FechaInicio,Herramientas.TipoValidacion.FECHA)){
           JOptionPane.showMessageDialog(null,"Respuesta incorrecta en la fecha de inicio");
           return;
       }

       if(!Herramientas.ValidarEntradas(FechaFin,Herramientas.TipoValidacion.FECHA)){
           JOptionPane.showMessageDialog(null,"Respuesta incorrecta en la fecha de fin");
           return;
       }

       AgregarDatos agregarDatos = new AgregarDatos();
       agregarDatos.AgregarOferta(nombre, idProducto, Descuento, FechaInicio, FechaFin);

   }
}
