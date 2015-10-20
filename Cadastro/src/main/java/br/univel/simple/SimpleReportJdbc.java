package br.univel.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReportJdbc {

	private String arq = "C:\\Users\\Alex Tezza\\JaspersoftWorkspace\\MyReports\\Exercicio.jasper";

	public SimpleReportJdbc() throws SQLException {
		
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(arq, null, getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://192.168.101.10/employees";
		
		String user = "jasper";
		
		String password = "jasper";
		
		Connection conexao = DriverManager.getConnection(url, user, password);
		
		return conexao;
	}

	public static void main(String[] args) {
		try {
			new SimpleReportJdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
