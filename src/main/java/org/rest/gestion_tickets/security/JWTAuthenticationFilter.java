package com.management.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.entities.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Objectif est de générer le Token JWT
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    //bouton droit : generer/constructeur/ choisir la 1ere puis 1ere aussi
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }
    //bouton droit : generer/override / choisir attemptAuthentication / ok puis supprimer la ligne au milieux de la méthode
    //cette methode va extraire l'objet user à partir du request
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        User user =null;
        try {
            //ObjectMapper : sert à serialiser et deserialiser les objets vers JSON
            //les 2 parametres de cette méthode : 1= requete et 2= le type de l'objet à sérialiser
            //generer tous les exceptions
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
    }
    //bouton droit : generer/override / choisir successfulAuthentication / ok
    //puis supprimer le contenu
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        //ecrire : User et choisir celle de userdetails et non celle de l'entite
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        //chercher les roles de ce user
        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach(a-> {
            roles.add(a.getAuthority());
        });
        //construction du TOKEN
        String jwt = JWT.create()
                .withSubject(user.getUsername())
                //conversion au tableau
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                //expiration du TOKEN
                .withExpiresAt(new Date(System.currentTimeMillis()+ SecurityParameters.EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SecurityParameters.SECRET));
        response.addHeader("Authorization", jwt);
    }
}

