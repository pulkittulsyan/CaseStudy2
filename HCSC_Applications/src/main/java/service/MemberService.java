package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import bean.Member;
import dbhandler.DbHandler;
import bean.AppDetails;
import bean.ApplicationDetails;

public class MemberService {

	public String verifydetails(int usernumber) {
		String x = null;
		String y = null;

		DbHandler db = DbHandler.getInstance();
		Connection conn = db.ObtainConnection();

		System.out.println("entered in dao");
		String queryString = "SELECT status FROM userdetail where userid =" + usernumber;
		ResultSet rs;

		try {

			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				System.out.println("entered in while loop");
				x = rs.getString(1);
				System.out.println("Status is " + x);

				if (x.equals("A"))
					y = "Active";
				else if (x.equals("I"))
					y = "Inactive";

				System.out.println("status is " + y);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.CloseConnection();
		return y;

	}

	public List<ApplicationDetails> getappdetails(int appid) {

		DbHandler db = DbHandler.getInstance();
		Connection conn = db.ObtainConnection();
		List<ApplicationDetails> details = new LinkedList<ApplicationDetails>();

		ResultSet rs;
		//String queryString = "SELECT * FROM appstream where appid =" + appid;
		String queryString1 = "SELECT * FROM application_details where appid =" + appid;


		try {
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(queryString1);

			int count = 0;
			System.out.println("ID \tNAME");
			System.out.println("============" + rs.getFetchSize());
			while (rs.next()) {
				count++;
				/*AppDetails m = new AppDetails();
				
				m.setSno(rs.getInt(1));
				m.setAppid(rs.getString(2));
				m.setAppname(rs.getString(3));
				m.setUpstream(rs.getString(4));
				m.setDownstream(rs.getString(5));*/
				
				ApplicationDetails m= new ApplicationDetails();
				m.setId(rs.getInt(1));
				m.setAppid(rs.getString(2));
				m.setAppname(rs.getString(3));
				m.setUpstream(rs.getString(4));
				m.setDownstream(rs.getString(5));
				
				System.out.println("count : " + count);
				details.add(m);
			}

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
		db.CloseConnection();
		return details;
	}

	public List<AppDetails> insertappdetails() {

		System.out.println("inside service insertappdetails ");
		DbHandler db = DbHandler.getInstance();
		Connection conn = db.ObtainConnection();

		PreparedStatement preparedStatement = null;
		List<AppDetails> details = new LinkedList<AppDetails>();

		ResultSet rs;
		String query = "INSERT INTO application_details" + "(`appid`, `appname`,`upstream`, `downstream`) VALUES"
				+ "(?,?,?,?)";

		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, 202);
			preparedStatement.setString(2, "app3");
			preparedStatement.setString(3, "[\"upapp31\", \"upapp32\"]");
			preparedStatement.setString(4, "[\"downapp31\", \"downapp32\"]");
			int result = preparedStatement.executeUpdate();
			System.out.println("result of insertion:   " + result);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		db.CloseConnection();
		return details;
	}

}
