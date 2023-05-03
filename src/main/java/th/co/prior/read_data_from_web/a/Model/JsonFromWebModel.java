package th.co.prior.read_data_from_web.a.Model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JsonFromWebModel {
    private String date;
    private String symbol;
    private Double prior;
    private Double open;
    private Double high;
    private Double low;
    private Double average;
    private Double close;
    private Double change;
    private Double percentChange;
    private Double totalVolume;
    private Double totalValue;
    private Double pe;
    private Double pbv;
    private Double bookValuePerShare;
    private Double dividendYield;
    private Double marketCap;
    private Double listedShare;
    private Double par;
    private String financialDate;
    private Double nav;
    private Double marketIndex;
    private Double marketPercentChange;
}
