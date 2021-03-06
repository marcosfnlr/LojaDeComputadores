package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlacaMae;
import repositories.RepositorioItem;

@WebServlet("/ComputadorController")
public class ComputadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComputadorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<PlacaMae> placas = (ArrayList<PlacaMae>) RepositorioItem.getInstance().getPlacasMae();
		request.setAttribute("listaPlacas", placas);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/computador-lista-placa.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
