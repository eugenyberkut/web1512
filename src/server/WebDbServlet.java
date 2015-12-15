package server;

import beans.AvtorService;
import tables.Avtor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevhen on 15.12.2015.
 */
@WebServlet(name = "WebDbServlet", urlPatterns = {"/main"})
public class WebDbServlet extends HttpServlet {
    @EJB
    AvtorService as;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("books_by_aid")!=null) {
            showBooksByAvtor(request,response);
        } else {
            showAvtors(request, response);
        }
    }

    private void showAvtors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Avtor> avtors = as.findAll();
        request.setAttribute("avtors", avtors);
        request.getRequestDispatcher("/avtors.jsp").forward(request, response);
    }

    private void showBooksByAvtor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String books_by_aid = request.getParameter("books_by_aid");
        try {
            Integer aid = Integer.valueOf(books_by_aid);
            Avtor avtor = as.find(aid);
            request.setAttribute("avtor",avtor);
            request.getRequestDispatcher("/booksbyavtor.jsp").forward(request,response);
        } catch (NumberFormatException ex) {
            showAvtors(request,response);
        }
    }
}
