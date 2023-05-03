package th.co.prior.read_data_from_web.a.Entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TrTransaction implements Serializable {
    private String symbol;
    private LocalDate transactionDate;

}
