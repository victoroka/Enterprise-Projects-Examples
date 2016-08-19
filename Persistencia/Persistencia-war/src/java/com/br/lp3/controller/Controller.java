/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller;

import com.br.lp3.model.PokemonDAO;
import com.br.lp3.model.entities.Pokemon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victoroka
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    PokemonDAO pokemonDAO = lookupPokemonDAOBean();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // O parametro e o nome da unidade de persistencia
            // EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemon-warPU");
            // EntityManager em = emf.createEntityManager();
            
            // Pokemon p1 = new Pokemon();
            // out.println(p1 + "<br>");
            
            // em.getTransaction().begin();
            // em.persist(p1);
            // em.getTransaction().commit();
            // out.println(p1 + "<br>");
            
            List<Pokemon> pokemons = pokemonDAO.read();
            for (Pokemon pokemon : pokemons) {
                out.println("<p>" + pokemon + "<p>");
            }
            
            out.println("<hr>");
            
            Pokemon p1 = pokemonDAO.readById(2);
            p1.setPokemon_cp(130);
            pokemonDAO.update(p1);
            
            
            List<Pokemon> pokemons2 = pokemonDAO.read();
            for (Pokemon pokemon : pokemons2) {
                out.println("<p>" + pokemon + "<p>");
            }
            
            out.println("<hr>");
            
            Pokemon p2 = pokemonDAO.readById(1);
            pokemonDAO.delete(p2);
            
            List<Pokemon> pokemons3 = pokemonDAO.read();
            for (Pokemon pokemon : pokemons3) {
                out.println("<p>" + pokemon + "<p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private PokemonDAO lookupPokemonDAOBean() {
        try {
            Context c = new InitialContext();
            return (PokemonDAO) c.lookup("java:global/Persistencia/Persistencia-ejb/PokemonDAO!com.br.lp3.model.PokemonDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
