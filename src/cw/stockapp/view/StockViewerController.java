//JAVA COURSEWORK 1 - C1868149
//Graphs page
package cw.stockapp.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ChoiceBox;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;


public class StockViewerController {
	//Declare variables and give relevant widget in the scene an ID
	@FXML
	public ChoiceBox<String> myChoiceBox;

	@FXML
	public LineChart<String, Integer> lineChartDateVol;
	public BarChart<String, Double> barChartDateDiff;

	private CategoryAxis xAxisScatter = new CategoryAxis();
    private NumberAxis yAxisScatter = new NumberAxis(1200, 2000, 100);
	public ScatterChart<String, Number> scatterChartDateHighLow = new ScatterChart<String, Number>(xAxisScatter, yAxisScatter);

	private ObservableList<String> companies;

	private ArrayList<String> datePlot = new ArrayList<String>();
	private ArrayList<Integer> volumePlot = new ArrayList<Integer>();
	private ArrayList<Double> openPlot = new ArrayList<Double>();
	private ArrayList<Double> closePlot = new ArrayList<Double>();
	private ArrayList<Double> highPlot = new ArrayList<Double>();
	private ArrayList<Double> lowPlot = new ArrayList<Double>();
	private ArrayList<Double> diffPlot = new ArrayList<Double>();

	private BufferedReader reader;

	@FXML
	public void initialize(){
	}

	//Populate the dropdown box with the selectinos
	public void runfuncSVC() throws IOException{
		myChoiceBox.getItems().clear();
		//myChoiceBox.setItems(companies);

		myChoiceBox.getItems().addAll("Ashtead Group plc","Antofagasta plc","BAE Systems plc",
                "British American Tobacco plc", "Coca-Cola HBC AG", "Carnival plc",
                "Centrica plc", "Compass Group plc","Experian plc",
                "EasyJet plc", "GKN plc", "Mediclinic International plc",
                "Provident Financial plc", "Paddy Power Betfair plc", "Prudential plc",
                "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
                "Rolls-Royce Holdings plc", "Schroders plc", "Shire plc",
                "Sky plc", "SSE plc", "St. James's Place plc", "Tesco plc",
                "TUI AG", "Vodafone Group plc", "Worldpay Group plc");

		myChoiceBox.getSelectionModel().select(0);
		getCompanyDetails();
	}

	@FXML
	public void getCompanyDetails() throws IOException {
		//Clear the list to load in the new entry every time the button is clicked
		 datePlot.clear();
		 openPlot.clear();
		 highPlot.clear();
		 lowPlot.clear();
		 closePlot.clear();
		 volumePlot.clear();
		 diffPlot.clear();

		companies = FXCollections.observableArrayList("AHT.csv","ANTO.csv","BA.csv",
                "BATS.csv", "CCH.csv", "CCL.csv",
                "CNA.csv", "CPG.csv","EXPN.csv",
                "EZJ.csv", "GKN.csv", "MDC.csv",
                "PFG.csv", "PPB.csv", "PRU.csv",
                "PSN.csv", "RB.csv", "RDSA.csv",
                "RR.csv", "SDR.csv", "SHP.csv",
                "SKY.csv", "SSE.csv", "STJ.csv",
                "TSCO.csv", "TUI.csv","VOD.csv",
                "WPG.csv");

		int selectedIndexCompany = myChoiceBox.getSelectionModel().getSelectedIndex();

		//Read the data from the selected company and store them in respective lists
		try {
			reader = new BufferedReader(new FileReader(companies.get(selectedIndexCompany)));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line=null;
			// While the list is not null
			while ((line = reader.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 datePlot.add(alllist[0]);
				 openPlot.add(Double.parseDouble(alllist[1]));
				 highPlot.add(Double.parseDouble(alllist[2]));
				 lowPlot.add(Double.parseDouble(alllist[3]));
				 closePlot.add(Double.parseDouble(alllist[4]));
				 volumePlot.add(Integer.parseInt(alllist[5]));
				 }

			for (int i = 0; i < openPlot.size(); i++) {
				diffPlot.add(openPlot.get(i)-closePlot.get(i));
			}

			//Plot the line chart
			//Clear the data and set title
			lineChartDateVol.getData().clear();
			lineChartDateVol.setTitle("Volume of Stocks Traded Per Day");
			//Create the series to input the chart
			XYChart.Series<String, Integer> seriesDateVol = new XYChart.Series<String, Integer>();
			seriesDateVol.setName("Volume of Stocks");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
			seriesDateVol.getData().add(new XYChart.Data<String, Integer>(datePlot.get(i), volumePlot.get(i)));
			}
			//Add the data into lineChartDateVol
			lineChartDateVol.getData().addAll(seriesDateVol);


			//Plot the bar chart
			//Clear the data and set the title
			barChartDateDiff.getData().clear();
			barChartDateDiff.setTitle("Difference of Open and Close Per Day");
			XYChart.Series<String, Double> seriesDateDiff = new XYChart.Series<String, Double>();
			seriesDateDiff.setName("Difference of Open and Close");
			for (int i = 0; i < datePlot.size(); i++) {
			seriesDateDiff.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), diffPlot.get(i)));
			}

			barChartDateDiff.getData().addAll(seriesDateDiff);

			//Plot the scatter chart
			scatterChartDateHighLow.getData().clear();
			scatterChartDateHighLow.setTitle("Highest and Lowest price Per Day");

			XYChart.Series<String, Number> seriesDateHigh = new XYChart.Series<String, Number>();
			seriesDateHigh.setName("Highest Value");
			XYChart.Series<String, Number> seriesDateLow = new XYChart.Series<String, Number>();
			seriesDateLow.setName("Lowest Value");

			for (int i = 0; i < datePlot.size(); i++) {
			seriesDateHigh.getData().add(new XYChart.Data<String, Number>(datePlot.get(i), highPlot.get(i)));
			seriesDateLow.getData().add(new XYChart.Data<String, Number>(datePlot.get(i), lowPlot.get(i)));
			}

			scatterChartDateHighLow.getData().addAll(seriesDateHigh, seriesDateLow);

			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }

	}

	//Upon clicking the respective graphs, the functions below maximizes the same graph by creating a new window for better viewing
	@FXML
	private void maximizeDateVolChart() {
		Stage lineGraphWindow = new Stage();

		final CategoryAxis xAxis = new CategoryAxis();
	    final NumberAxis yAxis = new NumberAxis();

        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis, yAxis);

        xAxis.setLabel("Date");
        yAxis.setLabel("Volume");

        lineChart.getData().clear();

        lineChart.setTitle("Volume of Stocks Traded Per Day");

        XYChart.Series seriesDateVol = new XYChart.Series();
        seriesDateVol.setName("Volume of Stocks");

		for (int i = 0; i < datePlot.size(); i++) {
		seriesDateVol.getData().add(new XYChart.Data<String, Integer>(datePlot.get(i), volumePlot.get(i)));
		}

        lineChart.getData().add(seriesDateVol);

        Scene scenelineGraph = new Scene(lineChart, 1200, 800);

        lineGraphWindow.setScene(scenelineGraph);
        lineGraphWindow.show();

	}

	@FXML
	private void maximizeDateDiffChart() {
		Stage barChartWindow = new Stage();

		final CategoryAxis xAxis = new CategoryAxis();
	    final NumberAxis yAxis = new NumberAxis();

        final BarChart<String,Number> barChart =
                new BarChart<String,Number>(xAxis, yAxis);

        xAxis.setLabel("Date");
        yAxis.setLabel("Price Difference");

        barChart.getData().clear();

        barChart.setTitle("Difference of Open and Close Per Day");

        XYChart.Series seriesDateDiff = new XYChart.Series();
        seriesDateDiff.setName("Difference of Open and Close");

		for (int i = 0; i < datePlot.size(); i++) {
		seriesDateDiff.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), diffPlot.get(i)));
		}

		barChart.getData().add(seriesDateDiff);

        Scene scenebarChart = new Scene(barChart, 1200, 800);

        barChartWindow.setScene(scenebarChart);
        barChartWindow.show();
	}

	@FXML
	private void maximizeHighLowChart() {
		Stage scatterChartWindow = new Stage();

		final CategoryAxis xAxis = new CategoryAxis();
	    final NumberAxis yAxis = new NumberAxis();

        final ScatterChart<String,Number> scatterChart =
                new ScatterChart<String,Number>(xAxis, yAxis);

        yAxis.setTickUnit(100);

        xAxis.setLabel("Date");
        yAxis.setLabel("Highs and Lows");

        scatterChart.getData().clear();

        scatterChart.setTitle("Highest and Lowest prices Per Day");

		XYChart.Series seriesDateHigh = new XYChart.Series();
		seriesDateHigh.setName("Highest Value");
		XYChart.Series seriesDateLow = new XYChart.Series();
		seriesDateLow.setName("Lowest Value");

		for (int i = 0; i < datePlot.size(); i++) {
		seriesDateHigh.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), highPlot.get(i)));
		seriesDateLow.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), lowPlot.get(i)));
		}

		scatterChart.getData().addAll(seriesDateHigh, seriesDateLow);

        Scene scenescatterChart = new Scene(scatterChart, 1200, 800);

        scatterChartWindow.setScene(scenescatterChart);
        scatterChartWindow.show();
	}

}




