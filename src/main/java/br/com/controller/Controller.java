package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.DAO;
import br.com.model.JavaBeans;


@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO conexao = new DAO();
	JavaBeans dados = new JavaBeans();


	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			selectContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// CRIANDO UM OBJETO QUE IRA RECEBER OS DADOS DA JAVABEANS
		ArrayList<JavaBeans> lista = conexao.listar();
		// Encaminha a lista para agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		dados.setEmail(request.getParameter("email"));
		dados.setFone(request.getParameter("fone"));
		dados.setNome(request.getParameter("nome"));
		conexao.inserirContato(dados);
		// redirecionar para o agenda.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void selectContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idcon = request.getParameter("idcon");
		System.out.println(idcon);
		dados.setIdcon(idcon);
		conexao.selectContato(dados);
		request.setAttribute("idcon", dados.getIdcon());
		request.setAttribute("nome", dados.getNome());
		request.setAttribute("fone", dados.getFone());
		request.setAttribute("email", dados.getEmail());
		// encaminhar
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as var
		dados.setIdcon(request.getParameter("idcon"));
		dados.setNome(request.getParameter("nome"));
		dados.setFone(request.getParameter("fone"));
		dados.setEmail(request.getParameter("email"));
		conexao.alterarContato(dados);
		response.sendRedirect("main");

	}

	protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		System.out.println(idcon);
		dados.setIdcon(idcon);
		conexao.deletarContato(dados);
		response.sendRedirect("main");
	}
}
