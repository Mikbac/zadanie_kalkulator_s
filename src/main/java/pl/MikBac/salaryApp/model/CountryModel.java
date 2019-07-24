/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.MikBac.salaryApp.constants.EntitiesNames;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = EntitiesNames.Country.TABLE)
public class CountryModel implements Serializable {

    @Id
    @Column(name = EntitiesNames.Country.COUNTRY_CODE)
    private String countryCode;

    @Column(name = EntitiesNames.Country.TAX)
    private BigDecimal tax;

    @Column(name = EntitiesNames.Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @Column(name = EntitiesNames.Country.CURRENCY_CODE)
    private String currencyCode;

}
