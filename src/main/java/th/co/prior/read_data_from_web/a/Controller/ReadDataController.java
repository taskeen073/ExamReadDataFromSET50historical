package th.co.prior.read_data_from_web.a.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import th.co.prior.read_data_from_web.a.Model.ExamTime;
import th.co.prior.read_data_from_web.a.Model.ResponseModel;
import th.co.prior.read_data_from_web.a.Service.ReadDataService;

import java.io.IOException;
import java.util.List;

@RestController
public class ReadDataController {

    private ReadDataService readDataService;

    public ReadDataController(ReadDataService readDataService) {
        this.readDataService = readDataService;
    }

    @PostMapping("/example")
    public ResponseModel<List<?>> createNewExample() throws IOException {
        return this.readDataService.Example();
    }

    @PostMapping("/example/2")
    public ResponseModel<?> newGame(@RequestBody ExamTime examTime) throws IOException {
        return this.readDataService.newGame(examTime);
    }

}
