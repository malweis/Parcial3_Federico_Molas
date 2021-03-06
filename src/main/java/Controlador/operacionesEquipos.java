package Controlador;

import Datos.Equipo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Path("/equipo")
public class operacionesEquipos {

    ArrayList <Equipo> listae = new ArrayList<Equipo>();
    boolean confirmacion = true;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/agregar")
    public void alta (String equipo){


            Gson gson = new Gson();

            Equipo msg = gson.fromJson(equipo, Equipo.class);

            for (Equipo k:listae) {
                if (k.getNombreE().equals(msg.getNombreE()) && k.getCiudadE().equals(msg.getCiudadE())){
                    confirmacion = false;
                    System.out.println("Ya existe un equipo con ese nombre en la misma ciudad");
                    break;
                }
                if (k.getPosicionN() == msg.getPosicionN()){
                    confirmacion = false;
                    System.out.println("Posicion en el ranking nacional ya esta ocupada");
                }
                if (k.getNombreEn().equals(msg.getNombreEn()) && k.getCodigoTemp() == msg.getCodigoTemp() && k.getAñotT() == msg.getAñotT()){
                    confirmacion = false;
                    System.out.printf("Este entrenador estaba ocupado con otro equipo en este año y temporada");
                }
            }

        if(confirmacion == true) {
            listae.add(msg);
        }
        System.out.println(listae.toString());

    }

    @POST
    @Path("/consultar")
    public void  consultar17 (){


        ArrayList<Equipo> aux17 = new ArrayList<Equipo>();
        Gson json = new Gson();
        for (Equipo k:listae) {
            if( k.getEstadoE() != 'B' || k.getPosicionN() <= 17){
                aux17.add(k);
            }
        }
        Gson gson = new Gson();

        String listString = gson.toJson(
                aux17,
                new TypeToken<ArrayList<Equipo>>() {}.getType());

        JSONArray jsonArray =  new JSONArray(listString);

        System.out.printf(jsonArray.toString());
    }
    @DELETE
    @Path("/eliminar")
    public void  eliminar (@QueryParam("codigoE") int codigoE,@QueryParam("añoT") int añoT,@QueryParam("codigoTemp") String codigoTemp, @QueryParam("jsonr") String jsonr) {



        for (Equipo k:listae) {
                if ( k.getCodigoE() == codigoE && k.getAñotT() == añoT  && k.getCodigoTemp().equals(codigoTemp)){
                    if(k.getEstadoE() == 'B' || k.getPosicionN() > 28){
                        listae.remove(k);
                    }else{
                        System.out.println("No se puede eliminar este equipo");
                    }
                }
        }

    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editar")
    public void  editar (@QueryParam("codigoE") int codigoE,@QueryParam("añoT") int añoT,@QueryParam("codigoTemp") String codigoTemp, String jsonR) {

        Gson gson = new Gson();

        Equipo equipo = gson.fromJson(jsonR, Equipo.class);

        for (Equipo k:listae) {
            if ( k.getCodigoE() == codigoE && k.getAñotT() == añoT &&  k.getEstadoE() != 'B'){

                k = equipo ;

                }else{
                    System.out.println("No se encontro el equipo");
                }
            }
        }



    @POST
    @Path("/consultar")
    public void  consultarOrden (@QueryParam("añoT") int añoT,@QueryParam("codigoTemp") String codigoTemp ){


        ArrayList<Equipo> auxtodo = new ArrayList<Equipo>();
        Gson json = new Gson();
        for (Equipo k:listae) {
            if( k.getAñotT() != añoT || k.getCodigoTemp() == codigoTemp){
                auxtodo.add(k);
            }
        }

      Collections.sort(auxtodo, Comparator.comparing(Equipo::getEstadoE)
                .thenComparing(Equipo::getPosicionN));

        Gson gson = new Gson();

        String listString = gson.toJson(
                auxtodo,
                new TypeToken<ArrayList<Equipo>>() {}.getType());

        JSONArray jsonArray =  new JSONArray(listString);

        System.out.printf(jsonArray.toString());
    }


    // Equipo(int codigoE, int añotT, int partidosG, int partidosP, int partidosE, int posicionN, int mayorGD, int mayorGR, String nombreE, String nombreEn, String codigoTemp, String ciudadE, char estadoE)

}
