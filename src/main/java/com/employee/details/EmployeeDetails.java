package com.employee.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.employeedetail.pojo.EmployeeDetailsRoot;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeURL")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String endPointURL = "https://4c33c683-f4fd-4892-b946-c3e343e09c03.mock.pstmn.io/employeedetails";

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPointURL))
				.header("X-RapidAPI-Host", "irctc1.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {

			e.printStackTrace();
		}
		String jsonString = response.body();

		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeDetailsRoot employeeDetailsRoot = objectMapper.readValue(jsonString, EmployeeDetailsRoot.class);

		out.println("<html><body><table border='1'> <tr>  <th>User Id</th>   <th>Employee Code</th>   <th>Job </th>"
				+ "</th><th>First Name</th>  <th>Last Name</th>   <th>Full Name</th> <th>Region</th> <th>Phone Number</th>  <th>Email Address</th></tr>");

		employeeDetailsRoot.employeeList.forEach((employee -> {
			out.print("<tr>");
			out.print("<td color:'red'>" + employee.userId + "</td>");
			out.print("<td>" + employee.employeeCode + "</td>");
			out.print("<td>" + employee.jobTitleName + "</td>");
			out.print("<td>" + employee.firstName + "</td>");
			out.print("<td>" + employee.lastName + "</td>");
			out.print("<td color:'red'>" + employee.preferredFullName + "</td>");
			out.print("<td>" + employee.region + "</td>");
			out.print("<td>" + employee.phoneNumber + "</td>");
			out.print("<td>" + employee.emailAddress + "</td>");
			out.print("</tr>");

		}));
		out.print("</body></html>");
	}
}
