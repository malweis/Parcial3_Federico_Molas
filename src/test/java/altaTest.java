import Controlador.operacionesEquipos;
import Datos.Equipo;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;



public class altaTest  {

     int codigoE = 35;
    int añotT = 1890;
    int partidosG = 2;
    int partidosP = 3;
    int partidosE = 4;
    int posicionN = 8;

    int mayorGD = 20;
    int mayorGR = 8;
    String nombreE = "Deportivo A";

    String nombreEn = "Octavio A";

    String codigoTemp = "pa";

    String ciudadE = "Ciudad del este" ;

    String  estadoE = "B";

   @Test
    public void alta (){

        ArrayList<Equipo> listae = new ArrayList<Equipo>();
        boolean confirmacion = true;

        for (Equipo k:listae) {
            if (k.getNombreE().equals(nombreE) && k.getCiudadE().equals(ciudadE)){
                confirmacion = false;
                System.out.println("Ya existe un equipo con ese nombre en la misma ciudad");
                break;
            }
            if (k.getPosicionN() == posicionN){
                confirmacion = false;
                System.out.println("Posicion en el ranking nacional ya esta ocupada");
            }
            if (k.getNombreEn().equals(nombreEn) && k.getCodigoTemp() == codigoTemp && k.getAñotT() == añotT){
                confirmacion = false;
                System.out.printf("Este entrenador estaba ocupado con otro equipo en este año y temporada");
            }
        }

        if(confirmacion == true) {
            Equipo equipo1 = new Equipo(codigoE, añotT, partidosG, partidosP, partidosE , posicionN, mayorGD, mayorGR, nombreE , nombreEn, codigoTemp, ciudadE, estadoE.charAt(0));
            listae.add(equipo1);
        }

       for (Equipo k:listae) {
           System.out.println(k.toString());
       }

    }
}
