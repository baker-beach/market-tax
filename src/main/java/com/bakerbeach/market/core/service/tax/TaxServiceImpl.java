package com.bakerbeach.market.core.service.tax;

import java.math.BigDecimal;

import com.bakerbeach.market.core.api.model.TaxCode;
import com.bakerbeach.market.tax.api.service.TaxService;

public class TaxServiceImpl implements TaxService {
	private static final String DEFAULT_COUNTRY_OF_DELIVERY = "DE";

	private TaxDAO dao;
	private String defaultCountryOfDelivery = DEFAULT_COUNTRY_OF_DELIVERY;

	@Override
	public BigDecimal getTaxRate(TaxCode productTaxCode, TaxCode customerTaxCode, String countryOfDelivery) {
		return dao.getTaxRate(productTaxCode, customerTaxCode, countryOfDelivery, defaultCountryOfDelivery);
	}

	public void setDao(TaxDAO dao) {
		this.dao = dao;
	}

	public void setDefaultCountryOfDelivery(String defaultCountryOfDelivery) {
		this.defaultCountryOfDelivery = defaultCountryOfDelivery;
	}

}
