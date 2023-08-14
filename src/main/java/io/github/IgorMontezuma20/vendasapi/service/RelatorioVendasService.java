package io.github.IgorMontezuma20.vendasapi.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RelatorioVendasService {

    @Value("classpath:reports/~relatorio-vendas.jrxml")
    private Resource relatorioVendas;

    @Autowired
    private DataSource dataSource;

    public byte[] gerarRelatorio(){

        //try with resources
        try (Connection connection = dataSource.getConnection()){
            JasperReport compiledReport = JasperCompileManager
                    .compileReport(relatorioVendas.getInputStream());
            Map<String, Object> parametros = new HashMap<>();
            JasperPrint print = JasperFillManager
                    .fillReport(compiledReport, parametros, connection);

            return JasperExportManager.exportReportToPdf(print);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
