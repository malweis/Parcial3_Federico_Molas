import Controlador.operacionesEquipos;
import Datos.ClaseTest;
import Datos.Equipo;
import com.google.gson.Gson;
import org.junit.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;



public class altaTest  {

    String json ="{\n" +
            "    \"codigoE\": \"3221\",\n" +
            "    \"añoT\": \"2002\",\n" +
            "    \"partidosG\": \"4\",\n" +
            "    \"partidosP\": \"5\",\n" +
            "    \"partidosE\": \"10\",\n" +
            "    \"mayorGD\": \"30\",\n" +
            "    \"mayorGR\": \"10\",\n" +
            "    \"nombreE\": \"Deportivo Ciudad\",\n" +
            "    \"nombreEn\": \"Juan Hernandez\",\n" +
            "    \"codigoTemp\": \"pa\",\n" +
            "    \"ciudadE\": \"Ciudad del este\",\n" +
            "    \"estadoE\": \"A\"\n" +
            "}";

   @Test
   @Consumes(MediaType.APPLICATION_JSON)
    public void alta (){


       Gson gson = new Gson();

       Equipo equipo = gson.fromJson(json, Equipo.class);

        ArrayList<Equipo> listae = new ArrayList<Equipo>();
        boolean confirmacion = true;

        for (Equipo k:listae) {
            if (k.getNombreE().equals(equipo.getNombreE()) && k.getCiudadE().equals(equipo.getCiudadE())){
                confirmacion = false;
                System.out.println("Ya existe un equipo con ese nombre en la misma ciudad");
                break;
            }
            if (k.getPosicionN() == equipo.getPosicionN()){
                confirmacion = false;
                System.out.println("Posicion en el ranking nacional ya esta ocupada");
            }
            if (k.getNombreEn().equals(equipo.getNombreEn()) && k.getCodigoTemp() == equipo.getCodigoTemp() && k.getAñotT() == equipo.getAñotT()){
                confirmacion = false;
                System.out.printf("Este entrenador estaba ocupado con otro equipo en este año y temporada");
            }
        }

        if(confirmacion) {
            listae.add(equipo);
        }


       for (Equipo k:listae) {
           System.out.println(k.toString());
       }

    }
}
