package com.trainschedule.Trainsarathi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainschedule.pojo.Route;
import com.trainschedule.pojo.TrainScheduleResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TrainScheduleStatusURL")
public class TrainScheduleStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String trainNumber=req.getParameter("tnumber");
				
		String endPointURL="https://79b8f371-f084-4536-a103-8efeaf0524e2.mock.pstmn.io/TrainRunningStatus";
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPointURL))
				.header("X-RapidAPI-Key", "dbfcfc80c7mshf2194436a8a2b90p1aa510jsn156b3c5f7dee")
				.header("X-RapidAPI-Host", "irctc1.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody())
				.build();


		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
		
			e.printStackTrace();
		}
		    //  out.println(response.body());
		String jsonString = response.body();
		

		ObjectMapper objectMapper = new ObjectMapper();
		TrainScheduleResponse trainScheduleResponse = objectMapper.readValue(jsonString, TrainScheduleResponse.class);
		if (!trainScheduleResponse.status) {
			//log
			System.out.println("CheckTrainScheduleStatus:doPost, "+trainScheduleResponse.message);
			out.println("There is Something wrong. We are working to fix it. Please try later. We are really sorry for the inconvenience.");
			return;
		}
		
		ArrayList<Route> routeList = trainScheduleResponse.trainSchedule.routeList;
		
		if (routeList.size()<=0) {
			out.println("No route found.");
			return;
		}
		
// me code
		
		Route sourceRoute = routeList.get(0);
		Route destinationRoute = routeList.get(routeList.size()-1);
		out.print("15450 " +sourceRoute.trainSource+"-"+destinationRoute.stationCode+"- EXP "+"<br>");

		out.println(sourceRoute.stationName+" - "+destinationRoute.stationName+"<br>");
		
		out.println("Days of Run:Daily"+"<br>");
		out.println("Class Of Travels:: 2S,3A,2A,SL");

          
		out.println("<html><body><table border='1'> <tr> <th>Station</th> <th>Day</th> <th>Arr.Dep </th>"
				+ "</th><th>Halt</th><th>Dist</th></tr>");
		
		for (int i=0; i< routeList.size(); i++) {

			Route route = routeList.get(i);
			
			int staHour=route.sta/60;
			int staMin=route.sta%60;
			
			int stdHour=route.stdMin/60;
			
			if (staHour > 23) {
				int diffSTAHR = staHour-24;
				staHour = diffSTAHR;
			}
			
			if (stdHour > 23) {
				int diffSTAHR = stdHour-24;
				stdHour = diffSTAHR;
			}
			
			int stdMin=route.stdMin%60;
			String staHR_Min= staHour+":"+staMin;
			String stdHR_Min= stdHour+":"+stdMin;
			
			int halt = route.stdMin-route.sta;

			out.print("<tr>");
			out.print("<td color:'red'>"+ route.stationName +"</td>");
			out.print("<td>"+ route.day+"</td>");

			out.print("<td>"+ staHR_Min + "-"+ stdHR_Min+"</td>");
			out.print("<td>"+ halt +"</td>");

			out.print("<td>"+ route.distanceFromSource+"</td>");
			out.print("</tr>");
		}		out.print("</body></html>");
	}
}
