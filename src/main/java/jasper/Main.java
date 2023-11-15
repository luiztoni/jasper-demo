package jasper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Main {

	public static void main(String[] args) throws JRException, IOException {
		List<Estudante> estudantes = new ArrayList<Estudante>();
		Estudante e;
		for(int i = 1; i < 5; i++) {
			e = new Estudante();
			e.setNome("Luiz");
			e.setNota1(10);
			e.setNota2(15);
			e.setNota3(20);
			estudantes.add(e);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "materia", "Português" );
	    JasperFillManager.fillReportToFile(System.getProperty("user.dir")+"/src/main/resources/template/relatorio_analitico.jasper", params, new JRBeanCollectionDataSource(estudantes, false));
        JasperExportManager.exportReportToPdfFile(System.getProperty("user.dir")+"/src/main/resources/template/relatorio_analitico.jrprint");
        System.out.println("Ok");
	}

}
