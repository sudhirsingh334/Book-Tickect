package com.sudhir.railway.TrainSarathi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkURL")
public class CheckPNRStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String pnrstatus=req.getParameter("pnr");

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://irctc1.p.rapidapi.com/api/v3/getPNRStatus?pnrNumber="+pnrstatus))
				.header("X-RapidAPI-Key", "84ec970e55msh29237cd1c10520dp1cc193jsn773b967a76d6")
				.header("X-RapidAPI-Host", "irctc1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();


		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(response.body());

		String jsonString = response.body();

		Object object = new JSONParser(jsonString);

		@SuppressWarnings("unchecked")
		Map<String,Object> map = (Map<String, Object>)object;

		out.print("Status: "+map.get("status"));
		out.print("Message: "+map.get("message"));
	}
}
