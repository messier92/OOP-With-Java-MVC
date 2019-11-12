//JAVA COURSEWORK 1 - C1868149
//COMPANY CLASS HAS STOCKSYMBOL, COMPANYNAME, STOCKOPEN, STOCKHIGH, STOCKLOW, STOCKCLOSE, STOCKVOLUME, STOCKADJCLOSE

package cw.stockapp.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


//Create a class 'Company' with the columns given in the .sv file
public class Company {
	private final StringProperty stockSymbol;
	private final StringProperty companyName;
	private final DoubleProperty stockOpen;
	private final DoubleProperty stockHigh;
	private final DoubleProperty stockLow;
	private final DoubleProperty stockClose;
	private final DoubleProperty stockVolume;
	private final DoubleProperty stockAdjClose;

	public Company() {
		this(null, null, null, null, null, null, null, null);
	}

	/**
	 * Constructor
	 * @param stockSymbol
	 * @param companyName
	 * @param stockOpen
	 * @param stockHigh
	 * @param stockLow
	 * @param stockClose
	 * @param stockVolume
	 * @param stockAdjClose
	 */
	public Company(String stockSymbol, String companyName, Double stockOpen, Double stockHigh, Double stockLow, Double stockClose, Double stockVolume, Double stockAdjClose) {
		this.stockSymbol = new SimpleStringProperty(stockSymbol);
		this.companyName = new SimpleStringProperty(companyName);
		this.stockOpen = new SimpleDoubleProperty(stockOpen);
		this.stockHigh = new SimpleDoubleProperty(stockHigh);
		this.stockLow = new SimpleDoubleProperty(stockLow);
		this.stockClose = new SimpleDoubleProperty(stockClose);
		this.stockVolume = new SimpleDoubleProperty(stockVolume);
		this.stockAdjClose = new SimpleDoubleProperty(stockAdjClose);
	}

	//Check if we need getStockSymbol and other gets
	public String getstockSymbol() {
		return stockSymbol.get();
	}

	public StringProperty stockSymbolProperty() {
		return stockSymbol;
	}

	public String getCompanyName() {
		return companyName.get();
	}

	public StringProperty companyNameProperty() {
		return companyName;
	}

    public double getStockOpen() {
        return stockOpen.get();
    }

    public DoubleProperty stockOpenProperty() {
        return stockOpen;
    }

    public double getStockHigh() {
        return stockHigh.get();
    }

    public DoubleProperty stockHighProperty() {
        return stockHigh;
    }

    public Double getStockLow() {
        return stockLow.get();
    }


    public DoubleProperty stockLowProperty() {
        return stockLow;
    }

    public Double getStockClose() {
        return stockClose.get();
    }

    public DoubleProperty stockCloseProperty() {
        return stockClose;
    }

    public Double getStockVolume() {
        return stockVolume.get();
    }

    public DoubleProperty stockVolumeProperty() {
        return stockVolume;
    }

    public double getStockAdjClose() {
        return stockAdjClose.get();
    }

    public DoubleProperty stockAdjCloseProperty() {
        return stockAdjClose;
    }
}
