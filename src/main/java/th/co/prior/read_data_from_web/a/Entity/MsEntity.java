package th.co.prior.read_data_from_web.a.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ms_set")
public class MsEntity {
    @Id
    @Column(name = "SYMBOL", nullable = false)
    private String symbol;
    @Column(name = "COMPANY")
    private String company;

    @Column(name = "MARKET")
    private String market;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "WEBSITE")
    private String website;

}
