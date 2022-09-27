package uz.writer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.writer.dao.constant.Database;
import uz.writer.dao.dto.PortLd10Model;
import uz.writer.dao.dto.Report;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService implements RiskReportRepo {


    private final R2dbcEntityTemplate template;
    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);

    public DatabaseService(R2dbcEntityTemplate template) {
        this.template = template;
    }

    @Override
    public Flux<PortLd10Model> getByBranch(String date, String branch) {
        return template.getDatabaseClient()
                .sql(Database.SELECT_PORT_LD_10_FOR_SINGLE)
                .bind("branch", branch)
                .bind("date", date)
                .map(Database.MAPPING_PORT_LD_10)
                .all()
                .onErrorResume(Mono::error)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<PortLd10Model> getAll(String date) {
        return template.getDatabaseClient()
                .sql(Database.SELECT_PORT_LD_10_FOR_ALL)
                .bind("date", date)
                .map(Database.MAPPING_PORT_LD_10)
                .all()
                .onErrorResume(Mono::error)
                .switchIfEmpty(Mono.empty());
    }


    public Flux<Report> test(String date) {
        return template.getDatabaseClient()
                .sql(Database.sql)
                .map(Database.MAPPING)
                .all()
                .onErrorResume(Mono::error)
                .switchIfEmpty(Mono.empty());
    }


}
