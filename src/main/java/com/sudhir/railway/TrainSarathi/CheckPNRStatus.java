package com.sudhir.railway.TrainSarathi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;    
import java.util.Date;  

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudhir.railway.pojo.PNRStatusResponse;

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

		 //String urlString = baseURLString+pnrNumber;
		String urlString = "https://869849af-dec5-46c9-bcd3-c36e5b08cc0e.mock.pstmn.io/getPNRStatus";

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
		
		String jsonString = response.body();

		ObjectMapper objectMapper = new ObjectMapper();
		PNRStatusResponse pnrResponse = objectMapper.readValue(jsonString, PNRStatusResponse.class);
		
		if (!pnrResponse.status) {
			//log
			System.out.println("CheckPNRStatus:doPost, "+pnrResponse.message);
			out.println("There is Something wrong. We are working to fix it. Please try later. We are really sorry for the inconvenience.");
			return;
		}
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());  
        Date date=new Date(ts.getTime());  
        
        out.print("<br>");
		out.println(date);
		out.print("<br><br>");
		
		
		out.println("<table border='1'> <tr> <th>Train Number</th> <th>Train Name</th> <th>Boarding Date <br>"
				+ "(DD-MM-YYYY)</th><th>From</th><th>Reserved Upto</th><th>Boarding Point</th><th>Class</th></tr> ");
		  
		out.print("<tr>");
		out.print("<td>"+ pnrResponse.pnrDetails.trainNo +"</td>");
		out.print("<td>"+ pnrResponse.pnrDetails.trainName +"</td>");		
		out.print("<td>"+ pnrResponse.pnrDetails.sourceDoj +"</td>");		
		out.print("<td>"+ pnrResponse.pnrDetails.from +"</td>");		
		out.print("<td>"+ pnrResponse.pnrDetails.to +"</td>");	
		out.print("<td>"+ pnrResponse.pnrDetails.reservationUpto +"</td>");
		out.print("<td>"+ pnrResponse.pnrDetails.boardingPoint +"</td>");
		out.print("<td>"+ pnrResponse.pnrDetails.bookedClass +"</td>");
		out.print("</tr>");
		out.print("</table>");

		out.print("<table border='1'> <tr> <th>S.No.</th> <th>Booking Status (Coach No , Berth No., Quota)</th> <th>*Current Status (Coach No , Berth No.)</th><th>Coach Position</th><br></tr>");
		
		pnrResponse.pnrDetails.passengerList.forEach((passenger -> {
			out.print("<tr>");
			out.print("<td>"+ "Passenger 1" +"</td>");
			out.print("<td>"+ passenger.bookingStatus +"</td>");		
			out.print("<td>"+ passenger.currentStatus +"</td>");		
			out.print("<td>"+ " " +"</td>");		
			out.print("</tr>");
		})) ;
		
		out.print("</table>");
		
		out.println("<br><table border='1'> <tr> <th>Total Fare</th> <th>Charting Status</th> <th>Remarks if any</th><th>Train Status</th></tr>");

		out.print("<tr>");
		out.print("<td>"+ pnrResponse.pnrDetails.bookingFare +"</td>");
		out.print("<td>"+ (pnrResponse.pnrDetails.chartPrepared ? "Chart Prepared":"Chart Not Prepared") +"</td>");		
		out.print("<td> </td>");		
		out.print("<td>"+ pnrResponse.pnrDetails.trainStatus +"</td>");				
		out.print("</table>");
	}
}
