package th.co.prior.read_data_from_web.a.Model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseModel<T> {
    private Integer statusCode;
    private String description;

    private List<String> errors;

    private List<String> errorNameStock;

    private T data;
}