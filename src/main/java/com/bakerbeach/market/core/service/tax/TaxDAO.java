package com.bakerbeach.market.core.service.tax;

import java.math.BigDecimal;

import com.bakerbeach.market.core.api.model.TaxCode;

public interface TaxDAO {

	BigDecimal getTaxRate(TaxCode productTaxCode, TaxCode customerTaxCode, String countryOfDelivery,
			String defaultCountryOfDelivery);

}
