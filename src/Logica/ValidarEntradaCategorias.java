package Logica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;

public class ValidarEntradaCategorias {

    public static void ValidarEntradaForAddCategoria(String nombre, String descripcion,String imagen){

        if(!Herramientas.ValidarEntradas(nombre,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Ingrese unicamente letras y no numeros");
            return;
        }

        if(!Herramientas.ValidarEntradas(descripcion,Herramientas.TipoValidacion.TEXTO_LIBRE)){
            JOptionPane.showMessageDialog(null,"La descripción no puede estar vacía.");
            return;
        }

        if (imagen== null) {
            JOptionPane.showMessageDialog(null,
                    "Primero debes importar una imagen.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }


        else {
            AgregarDatos ADDdatos= new AgregarDatos();
            ADDdatos.AgregarCategoria(nombre,descripcion,imagen);
        }

    }
}
