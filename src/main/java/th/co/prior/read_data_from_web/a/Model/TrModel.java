package th.co.prior.read_data_from_web.a.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TrModel {
    private String symbol;

    private LocalDate transactionDate;

    private Double openPrice;

    private Double maxPrice;

    private Double minPrice;

    private Double closePrice;

    private Double changePrice;

    private Double changeRatio;

    private Double noOfStock;

    private Double volume;

    private String reason;

    private String status;

    private Long batchId;

}
