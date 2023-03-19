package com.sudhir.railway.TrainSarathi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudhir.railway.pojo.*;

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
		PrintWriter out = res.getWriter();
		String pnrNumber = req.getParameter("pnr");

		String baseURLString = "https://irctc1.p.rapidapi.com/api/v3/getPNRStatus?pnrNumber=";

		 String urlString = baseURLString+pnrNumber;
		//String urlString = "https://869849af-dec5-46c9-bcd3-c36e5b08cc0e.mock.pstmn.io/getPNRStatus";

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString))
				.header("X-RapidAPI-Key", "84ec970e55msh29237cd1c10520dp1cc193jsn773b967a76d6")
				.header("X-RapidAPI-Host", "irctc1.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody())
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

		ObjectMapper objectMapper = new ObjectMapper();
		PNRStatusResponse pnrResponse = objectMapper.readValue(jsonString, PNRStatusResponse.class);
		
		if (!pnrResponse.status) {
			//log
			System.out.println("CheckPNRStatus:doPost, "+pnrResponse.message);
			out.println("There is Something wrong. We are working to fix it. Please try later. We are really sorry for the inconvenience.");
			return;
		}
		
		out.println("Message: " + pnrResponse.message);
		out.println("Arrival Time: " + pnrResponse.pnrDetails.arrivalTime);
		out.println("Coach Position: " + pnrResponse.pnrDetails.coachPosition);
				
		pnrResponse.pnrDetails.passengerList.forEach((passenger -> {
			out.println("######################################");
			out.println("Status: " + passenger.bookingStatus);
			out.println("Berth: " + passenger.berth);
			out.println("Coach: " + passenger.coach);
		})) ;
	}
}
