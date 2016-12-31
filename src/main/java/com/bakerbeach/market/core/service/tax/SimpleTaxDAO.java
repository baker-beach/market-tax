package com.bakerbeach.market.core.service.tax;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bakerbeach.market.core.api.model.TaxCode;

public class SimpleTaxDAO implements TaxDAO {
	private static final Logger log = Logger.getLogger(SimpleTaxDAO.class.getName());
	
	private Map<String, BigDecimal> map;
	private String failoverKey = "DE|NORMAL|NORMAL";

	public SimpleTaxDAO(Map<String, BigDecimal> map) {
		this.map = map;
	}

	@Override
	public BigDecimal getTaxRate(TaxCode productTaxCode,
			TaxCode  customerTaxCode, String countryOfDelivery, String defaultCountryOfDelivery) {
		String k = new StringBuilder(countryOfDelivery).append("|").append(productTaxCode.name()).append("|").append(customerTaxCode.name()).toString();
		BigDecimal taxRate = map.get(k);
		
		if (taxRate != null)
			return taxRate;
		
		k = new StringBuilder(defaultCountryOfDelivery).append("|").append(productTaxCode.name()).append("|").append(customerTaxCode.name()).toString();
		taxRate = map.get(k);

		if (taxRate != null)
			return taxRate;

		log.error("missing tax rate even for default country of delivery");
		return map.get(failoverKey);
	}

	public void setFailoverKey(String failoverKey) {
		this.failoverKey = failoverKey;
	}
	
}
