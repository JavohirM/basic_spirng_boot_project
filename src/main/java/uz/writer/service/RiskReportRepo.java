package uz.writer.service;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import uz.writer.dao.dto.PortLd10Model;

@Repository
public interface RiskReportRepo {

    Flux<PortLd10Model> getByBranch(String date, String branch);
    Flux<PortLd10Model> getAll(String date);
}
