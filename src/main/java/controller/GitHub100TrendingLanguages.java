package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.TredingRepositoryService;


/**
 * Servlet implementation class GitHub100TrendingLanguages
 */
@WebServlet("/GitHub100TrendingLanguages")
public class GitHub100TrendingLanguages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GitHub100TrendingLanguages() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		TredingRepositoryService tredingRepositoryService = new TredingRepositoryService();

		try {
			String tredingRepositoriesJsonString = new Gson().toJson(tredingRepositoryService.getLanguagesOf100TrendingRepository());
			out.print(tredingRepositoriesJsonString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}