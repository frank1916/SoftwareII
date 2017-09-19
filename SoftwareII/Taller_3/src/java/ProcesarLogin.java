//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesarLogin", urlPatterns = {"/ProcesarLogin"})
public class ProcesarLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            String usuario = req.getParameter("usuario");
            String pass = req.getParameter("contrasena");

            if (usuario.equals(pass)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<tittle>Servlet Prueba</tittle>");
                out.println("</head>");
                out.println("<body>");
                out.println("Bienvenido" + usuario);
//                resp.sendRedirect("Taller_3/login.html");
                out.println("</body>");
                out.println("</html>");
                req.getSession().setAttribute("usuario", usuario);
            } else {
                resp.sendRedirect("Taller_3/login.html");
            }

        } catch (Exception e) {
            System.err.println("error_1_ " + e);
        }

    }

}
