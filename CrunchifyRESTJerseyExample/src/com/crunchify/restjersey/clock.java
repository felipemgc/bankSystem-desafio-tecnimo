package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.LinkedList;

@Path("/clock")
public class clock {
	
	public static boolean isInteger(String s) 
	{
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean horaValida(String hora)
	{
		if ( !hora.isEmpty() && hora.length() == 5 && isInteger(hora.substring(0,2)) && hora.charAt(2)== ':' && isInteger(hora.substring(3,5)))
			return true;
		return false;
	}
	
	  @GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
	
		JSONObject jsonObject = new JSONObject();
		
	   
		String result = "@Produces(\"application/json\") Output: \n\nPasse uma string pela URL como EX 09:30: \n\n" + jsonObject;
		 
		return Response.status(200).entity(result).build();
	  }
	
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") String hora) throws JSONException {
		  
			
		JSONObject jsonObject = new JSONObject();
		
		String result;
		LinkedList<Relogio> rList = new LinkedList<Relogio>();
		boolean contem;
		Relogio relogio = new Relogio();
		
		if(horaValida(hora.trim()) && hora.length()== 5)
		{
			contem = false;
			for (Relogio r : rList) 
			{
				
				if(r.getHora().equals(hora))
				{
					contem = true;
					relogio = r;
					break;
				}
			}
			if (contem == false)
			{
				relogio = new Relogio(hora);
				rList.add(relogio);
			}
		
		
		jsonObject.put("hora Informada: ", hora.trim());
		jsonObject.put("menor ângulo : ", relogio.getAngulo());
			
		String r = "@Produces(\"application/json\") Output: \n\n Busca do menor ângulo dos pondetiros baseado no horário informado: \n\n" + jsonObject;
		return Response.status(200).entity(r).build();
		
		}
		else{
			String r = "@Produces(\"application/json\") Output: \n\nPasse uma string pela URL como EX 09:30: \n\n" + jsonObject;
			 
			return Response.status(200).entity(r).build();
		}
		
		
	  }
}
