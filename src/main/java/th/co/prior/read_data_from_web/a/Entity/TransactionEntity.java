package th.co.prior.read_data_from_web.a.Entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "tr_transaction")
@IdClass(TrTransaction.class)
public class TransactionEntity {

    @Id
    @Column(name = "SYMBOL", nullable = false)
    private String symbol;

    @Id
    @Column(name = "TRANSACTION_DATE", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "OPEN_PRICE")
    private Double openPrice;

    @Column(name = "MAX_PRICE")
    private Double maxPrice;

    @Column(name = "MIN_PRICE")
    private Double minPrice;

    @Column(name = "CLOSE_PRICE")
    private Double closePrice;

    @Column(name = "CHANGE_PRICE")
    private Double changePrice;

    @Column(name = "CHANGE_RATIO")
    private Double changeRatio;

    @Column(name = "NO_OF_STOCK")
    private Double noOfStock;

    @Column(name = "VOLUME")
    private Double volume;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "BATCH_ID")
    private Long batchId;

    // Constructors, getters and setters
}
