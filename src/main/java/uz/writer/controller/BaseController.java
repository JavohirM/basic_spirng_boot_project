package uz.writer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import uz.writer.dao.dto.PortLd10Model;
import uz.writer.dao.dto.ResultDto;
import uz.writer.service.FileCreatorService;

import java.util.concurrent.atomic.AtomicReference;

@RestController
public class BaseController {
    private final FileCreatorService service;

    public BaseController(FileCreatorService service) {
        this.service = service;
    }


    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public Flux<PortLd10Model> getByBranch(@RequestParam String date) {

        return service.getAllDetails(date);
    }

    @RequestMapping(value = "/port_ld_10/report", method = RequestMethod.GET)
    public ResponseEntity<ResultDto> test(@RequestParam String date, @RequestParam String branch) {
        AtomicReference<String> query1 = new AtomicReference<>("");
        AtomicReference<String> query2 = new AtomicReference<>("");
        query1.set(date);
        query2.set(branch);

        if (query2.get().equals("all")) {
            ResultDto byAll = service.getByAll(query1.get());
            return new ResponseEntity<>(byAll, HttpStatus.OK);
        } else {
            ResultDto byBranch = service.getByBranch(query1.get(), query2.get());
            return new ResponseEntity<>(byBranch, HttpStatus.OK);
        }


    }

}
