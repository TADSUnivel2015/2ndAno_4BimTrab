package br.univel.simple;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReport {

	private String arq = "C:\\Users\\Alex Tezza\\JaspersoftWorkspace\\MyReports\\simples.jasper";

	public SimpleReport() {
		
		TableModel tableModel = TableModelData();
		
		//	Relatório já preenchido...
		JasperPrint jasperPrint = null;
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("empresa", "Casas Bahia");
			map.put("telefone", "123pim556pim");
			
			//	Faz o preenchimento do relatório...
			jasperPrint = JasperFillManager.fillReport(arq, map,
					new JRTableModelDataSource(tableModel));
			
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private TableModel TableModelData() {
		String[] columnNames = { "Id", "Nome", "Departamento", "Email" };
		
		String[][] data = {
				{ "1", "Hugo", "Financeiro", "hugod@univel.br" },
				{ "2", "José", "Comercial",  "josed@univel.br" },
				{ "3", "Luiz", "Contábil",   "luizd@univel.br" }
		};
		
		return new DefaultTableModel(data, columnNames);
	}

	public static void main(String[] args) {
		new SimpleReport();
	}
}
