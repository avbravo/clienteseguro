/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.desktopclient;


import com.avbravo.desktopclient.entity.Paises;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author avbravo
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            HttpAuthenticationFeature autentificacion = HttpAuthenticationFeature.basic("myusername", "mypassword");

            Client client = ClientBuilder.newClient();
            client.register(autentificacion);


            
            WebTarget target = client.target("http://localhost:8080/resources/paises");

            GenericType<List<Paises>> paises = new GenericType<List<Paises>>() {
            };

            List<Paises> listaPaises = target.request(MediaType.APPLICATION_JSON).get(paises);
            for (Paises n : listaPaises) {
                System.out.println(n.getId());
                System.out.println(n.getPais());
            }

            
            
        } catch (Exception e) {
            System.out.println("main() " + e.getLocalizedMessage());
        }
    }

}
