package co.edu.uniquindio.poo.MoveTemplate.BasicGraficInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.uniquindio.poo.MoveTemplate.MoveTemplate;
import dbFiles.cruds.MoveCategoryTable;

public class TerminalInterfaceTemplate {

    // esta lista va a ser las obciones que se van a aparecer en el menu
    public void showContent(String titulo,String nombreObciones,String obciones[]){

        System.out.println(titulo+"\n\n");
        System.out.println(nombreObciones+"\n");
        for (String obcion : obciones) {
            System.out.println(obcion);
        }
    }
    // hacer un chain of responsability
    public void selectionObtionAdd(MoveCategoryTable tabla, MoveTemplate mt){
        
        int resultado = tabla.addOne(mt);
        System.out.println("se ha agregado"+resultado);

    }

    public void selectionSerchForDate(MoveCategoryTable tabla, String date, int cantidadMax){

        Collection <MoveTemplate> registros = tabla.searchForDate(date);

        List<MoveTemplate> listaRegistros = new ArrayList<>(registros);

        if(listaRegistros.size() >= cantidadMax){

            for(int i= 0; i<= cantidadMax; i++){
                System.out.println(listaRegistros.get(i).toString());
            }

        }else{
            for (MoveTemplate moveTemplate : listaRegistros) {
                System.out.println(moveTemplate.toString());
            }
        }
    }

    public void selectionSearchForType(String type){
       
    }

}
