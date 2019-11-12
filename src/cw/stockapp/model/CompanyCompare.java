//JAVA COURSEWORK 1 - C1868149
//COMPANYCOMPARE CLASS HAS COMPANYSTRPARAMETERS, COMPANY1PARAMETERS, COMPANY2PARAMETERS, COMPANYDIFFPARAMETERS
//Parameters to be compared are: Open, High, Low, Close, Volume and Adj. Close
package cw.stockapp.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class CompanyCompare {
	private StringProperty companyStrParameters;
	private DoubleProperty company1Parameters;
	private DoubleProperty company2Parameters;
	private DoubleProperty companyDiffParameters;

	/**
	 * Constructor
	 * @param companyStrParameters
	 * @param company1Parameters
	 * @param company2Parameters
	 * @param companyDiffParameters
	 */
	public CompanyCompare (String companyStrParameters, double company1Parameters, double company2Parameters, double companyDiffParameters) {
		this.companyStrParameters = new SimpleStringProperty(companyStrParameters);
		this.company1Parameters = new SimpleDoubleProperty(company1Parameters);
		this.company2Parameters = new SimpleDoubleProperty(company2Parameters);
		this.companyDiffParameters = new SimpleDoubleProperty(companyDiffParameters);
	}

	public CompanyCompare() {
	}


	public String getCompanyStrParameters() {
		return companyStrParameters.get();
	}

	public StringProperty companyStrParametersProperty() {
		return companyStrParameters;
	}

	public Double getCompany1Parameters() {
		return company1Parameters.get();
	}

	public DoubleProperty company1ParametersProperty() {
		return company1Parameters;
	}

	public Double getCompany2Parameters() {
		return company2Parameters.get();
	}

	public DoubleProperty company2ParametersProperty() {
		return company2Parameters;
	}

	public Double getCompanyDiffParameters() {
		return companyDiffParameters.get();
	}

	public DoubleProperty companyDiffParametersProperty() {
		return companyDiffParameters;
	}
}
