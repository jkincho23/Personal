/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend.resources;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logic.Word;
import logic.Service;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author jjgr2
 */

@Path("/words")
public class Words {
    
    String location="C:/AAA/images/";
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Word p) {  
        try {
            Service.instance().SpaWordsCREATE(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA) 
    @Path("{cedula}/imagen")
    public void addImage(@PathParam("cedula") String cedula, @FormDataParam("imagen") InputStream in) {  
        try{
                OutputStream out = new FileOutputStream(new File(location + cedula));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Word> read() { 
        return Service.instance().SpaWordsREAD();
    }     
    
    @GET
    @Path("{palabra}")
    @Produces({MediaType.APPLICATION_JSON})
    public Word read(@PathParam("palabra") String palabra) {
        try {
            return Service.instance().SpaWordsREAD(palabra);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @GET
    @Path("{cedula}/imagen")
    @Produces("image/png")
    public Response getImge(@PathParam("cedula") String cedula) throws IOException {
        File file = new File(location+cedula);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }   
    
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("cedula") String cedula, Word p) {  
        try {
            Service.instance().SpaWordsUPDATE(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

    @DELETE
    @Path("{cedula}")
    public void delete(@PathParam("cedula") String cedula) {
        try {
            Service.instance().SpaWordsDELETE(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    
}
