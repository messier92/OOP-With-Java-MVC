package cw.stockapp.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class StockCompareGraphController {

	//Many variables
	@FXML
	public CheckBox boxaht = new CheckBox("Ashtead Group plc");
	@FXML
	public CheckBox boxanto = new CheckBox("Antofagasta plc");
	@FXML
	public CheckBox boxba = new CheckBox("BAE Systems plc");
	@FXML
	public CheckBox boxbats = new CheckBox("Britisn American Tobacco plc");
	@FXML
	public CheckBox boxcch = new CheckBox("Coca-Cola HBG AG");
	@FXML
	public CheckBox boxccl = new CheckBox("Carnival plc");
	@FXML
	public CheckBox boxcna = new CheckBox("Centrica plc");
	@FXML
	public CheckBox boxcpg = new CheckBox("Compass Group plc");
	@FXML
	public CheckBox boxexpn = new CheckBox("Experian plc");
	@FXML
	public CheckBox boxezj = new CheckBox("EasyJet plc");
	@FXML
	public CheckBox boxgkn = new CheckBox("GKN plc");
	@FXML
	public CheckBox boxmdc = new CheckBox("Mediclinic International plc");
	@FXML
	public CheckBox boxpfg = new CheckBox("Provident Financial plc");
	@FXML
	public CheckBox boxppb = new CheckBox("Paddy Power Betfair plc");
	@FXML
	public CheckBox boxpru = new CheckBox("Prudential plc");
	@FXML
	public CheckBox boxpsn = new CheckBox("Persimmon plc");
	@FXML
	public CheckBox boxrb = new CheckBox("Reckitt Benckiser Group plc");
	@FXML
	public CheckBox boxrdsa = new CheckBox("Royal Dutch Shell plc");
	@FXML
	public CheckBox boxrr = new CheckBox("Rolls-Royce Holdings plc");
	@FXML
	public CheckBox boxsdr = new CheckBox("Schroders plc");
	@FXML
	public CheckBox boxshp = new CheckBox("Shire plc");
	@FXML
	public CheckBox boxsky = new CheckBox("Sky plc");
	@FXML
	public CheckBox boxsse = new CheckBox("SSE plc");
	@FXML
	public CheckBox boxstj = new CheckBox("St. James's Place plc");
	@FXML
	public CheckBox boxtsco = new CheckBox("Tesco plc");
	@FXML
	public CheckBox boxtui = new CheckBox("TUI AG");
	@FXML
	public CheckBox boxvod = new CheckBox("Vodafone Group plc");
	@FXML
	public CheckBox boxwpg = new CheckBox("Worldpay Group plc");

    public ObservableList<String> datePlot = FXCollections.observableArrayList();
    public ObservableList<Double> openAHT = FXCollections.observableArrayList();

    public ObservableList<Double> paralistAHT = FXCollections.observableArrayList();
    public ObservableList<Double> paralistANTO = FXCollections.observableArrayList();
    public ObservableList<Double> paralistBA = FXCollections.observableArrayList();
    public ObservableList<Double> paralistBATS = FXCollections.observableArrayList();
    public ObservableList<Double> paralistCCH = FXCollections.observableArrayList();
    public ObservableList<Double> paralistCCL = FXCollections.observableArrayList();
    public ObservableList<Double> paralistCNA = FXCollections.observableArrayList();
    public ObservableList<Double> paralistCPG = FXCollections.observableArrayList();
    public ObservableList<Double> paralistEXPN = FXCollections.observableArrayList();
    public ObservableList<Double> paralistEZJ = FXCollections.observableArrayList();
    public ObservableList<Double> paralistGKN = FXCollections.observableArrayList();
    public ObservableList<Double> paralistMDC = FXCollections.observableArrayList();
    public ObservableList<Double> paralistPFG = FXCollections.observableArrayList();
    public ObservableList<Double> paralistPPB = FXCollections.observableArrayList();
    public ObservableList<Double> paralistPRU = FXCollections.observableArrayList();
    public ObservableList<Double> paralistPSN = FXCollections.observableArrayList();
    public ObservableList<Double> paralistRB = FXCollections.observableArrayList();
    public ObservableList<Double> paralistRDSA = FXCollections.observableArrayList();
    public ObservableList<Double> paralistRR = FXCollections.observableArrayList();
    public ObservableList<Double> paralistSDR = FXCollections.observableArrayList();
    public ObservableList<Double> paralistSHP = FXCollections.observableArrayList();
    public ObservableList<Double> paralistSKY = FXCollections.observableArrayList();
    public ObservableList<Double> paralistSSE = FXCollections.observableArrayList();
    public ObservableList<Double> paralistSTJ = FXCollections.observableArrayList();
    public ObservableList<Double> paralistTSCO = FXCollections.observableArrayList();
    public ObservableList<Double> paralistTUI = FXCollections.observableArrayList();
    public ObservableList<Double> paralistVOD = FXCollections.observableArrayList();
    public ObservableList<Double> paralistWPG = FXCollections.observableArrayList();

	private BufferedReader reader, reader0, reader1, reader2, reader3, reader4, reader5, reader6, reader7, reader8,	reader9, reader10, reader11, reader12, reader13, reader14, reader15, reader16, reader17, reader18, reader19, reader20, reader21, reader22, reader23, reader24, reader25, reader26, reader27;

	//Fixed variables
	public ObservableList<String> companiescsvlist = FXCollections.observableArrayList("AHT.csv","ANTO.csv","BA.csv",
            "BATS.csv", "CCH.csv", "CCL.csv",
            "CNA.csv", "CPG.csv","EXPN.csv",
            "EZJ.csv", "GKN.csv", "MDC.csv",
            "PFG.csv", "PPB.csv", "PRU.csv",
            "PSN.csv", "RB.csv", "RDSA.csv",
            "RR.csv", "SDR.csv", "SHP.csv",
            "SKY.csv", "SSE.csv", "STJ.csv",
            "TSCO.csv", "TUI.csv","VOD.csv",
            "WPG.csv");

	public ObservableList<String> graphparameters = FXCollections.observableArrayList("Open","High","Low","Close","Volume","Adj Close");


	@FXML
	public ChoiceBox<String> parametersChoiceBox1;

	@FXML
	public LineChart<String, Double> lineChartDatePara;

	public int parameterselectedindex;
	public String parameterselected;

	public String inputcsvAHT = "AHT.csv";

	public void runfuncSCG(){
		parametersChoiceBox1.getItems().addAll(graphparameters);
		parametersChoiceBox1.getSelectionModel().select(0);

		boxaht.setSelected(true);

		//initialize the graph
		try {
			reader = new BufferedReader(new FileReader(inputcsvAHT));
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
				 openAHT.add(Double.parseDouble(alllist[1]));
				 }
			XYChart.Series<String, Double> seriesx = new XYChart.Series<String, Double>();
			seriesx.setName("Ashtead Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				seriesx.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), openAHT.get(i)));
			}
			lineChartDatePara.getData().add(seriesx);
		} catch (Exception e) {
     		e.printStackTrace();
	    }
	}

	public void plotcomparegraph() throws IOException {
		paralistAHT.clear();
		paralistANTO.clear();
		paralistBA.clear();
		paralistBATS.clear();
    	paralistCCH.clear();
	    paralistCCL.clear();
	    paralistCNA.clear();
	    paralistCPG.clear();
	    paralistEXPN.clear();
	    paralistEZJ.clear();
	    paralistGKN.clear();
	    paralistMDC.clear();
	    paralistPFG.clear();
	    paralistPPB.clear();
	    paralistPRU.clear();
	    paralistPSN.clear();
	    paralistRB.clear();
	    paralistRDSA.clear();
	    paralistRR.clear();
	    paralistSDR.clear();
	    paralistSHP.clear();
	    paralistSKY.clear();
	    paralistSSE.clear();
	    paralistSTJ.clear();
	    paralistTSCO.clear();
	    paralistTUI.clear();
	    paralistVOD.clear();
	    paralistWPG.clear();
		lineChartDatePara.getData().clear();

		parameterselectedindex = parametersChoiceBox1.getSelectionModel().getSelectedIndex();
		parameterselected = parametersChoiceBox1.getValue();

		System.out.println(parameterselected);
		System.out.println(parameterselectedindex);

		if (boxaht.isSelected()) {
			reader0 = new BufferedReader(new FileReader(companiescsvlist.get(0)));
			//Read the first line
			reader0.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader0.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistAHT.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			//Create the series to input the chart
			XYChart.Series<String, Double> series0 = new XYChart.Series<String, Double>();
			series0.setName("Ashtead Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series0.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistAHT.get(i)));
			}
			lineChartDatePara.getData().add(series0);
		}

		if (boxanto.isSelected()) {
			reader1 = new BufferedReader(new FileReader(companiescsvlist.get(1)));
			//Read the first line
			reader1.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader1.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistANTO.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series1.setName("Antofagasta plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series1.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistANTO.get(i)));
			}
			lineChartDatePara.getData().add(series1);
		}

		if (boxba.isSelected()) {
			reader2 = new BufferedReader(new FileReader(companiescsvlist.get(2)));
			//Read the first line
			reader2.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader2.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistBA.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series2.setName("BAE Systems plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series2.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistBA.get(i)));
			}
			lineChartDatePara.getData().add(series2);
		}

		if (boxbats.isSelected()) {
			reader3 = new BufferedReader(new FileReader(companiescsvlist.get(3)));
			//Read the first line
			reader3.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader3.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistBATS.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series3 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series3.setName("British American Tobacco plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series3.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistBATS.get(i)));
			}
			lineChartDatePara.getData().add(series3);
		}

		if (boxcch.isSelected()) {
			reader4 = new BufferedReader(new FileReader(companiescsvlist.get(4)));
			//Read the first line
			reader4.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader4.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistCCH.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series4 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series4.setName("Coca-Cola HBG plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series4.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistCCH.get(i)));
			}
			lineChartDatePara.getData().add(series4);
		}

		if (boxccl.isSelected()) {
			reader5 = new BufferedReader(new FileReader(companiescsvlist.get(5)));
			//Read the first line
			reader5.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader5.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistCCL.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series5 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series5.setName("Carnival plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series5.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistCCL.get(i)));
			}
			lineChartDatePara.getData().add(series5);
		}

		if (boxcna.isSelected()) {
			reader6 = new BufferedReader(new FileReader(companiescsvlist.get(6)));
			//Read the first line
			reader6.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader6.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistCNA.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series6 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series6.setName("Centrica plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series6.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistCNA.get(i)));
			}
			lineChartDatePara.getData().add(series6);
		}

		if (boxcpg.isSelected()) {
			reader7 = new BufferedReader(new FileReader(companiescsvlist.get(7)));
			//Read the first line
			reader7.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader7.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistCPG.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series7 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series7.setName("Compass Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series7.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistCPG.get(i)));
			}
			lineChartDatePara.getData().add(series7);
		}

		if (boxexpn.isSelected()) {
			reader8 = new BufferedReader(new FileReader(companiescsvlist.get(8)));
			//Read the first line
			reader8.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader8.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistEXPN.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series8 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series8.setName("Experian plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series8.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistEXPN.get(i)));
			}
			lineChartDatePara.getData().add(series8);
		}

		if (boxezj.isSelected()) {
			reader9 = new BufferedReader(new FileReader(companiescsvlist.get(9)));
			//Read the first line
			reader9.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader9.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistEZJ.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series9 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series9.setName("EasyJet plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series9.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistEZJ.get(i)));
			}
			lineChartDatePara.getData().add(series9);
		}

		if (boxgkn.isSelected()) {
			reader10 = new BufferedReader(new FileReader(companiescsvlist.get(10)));
			//Read the first line
			reader10.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader10.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistGKN.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series10 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series10.setName("GKN plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series10.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistGKN.get(i)));
			}
			lineChartDatePara.getData().add(series10);
		}

		if (boxmdc.isSelected()) {
			reader11 = new BufferedReader(new FileReader(companiescsvlist.get(11)));
			//Read the first line
			reader11.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader11.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistMDC.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series11 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series11.setName("Mediclinic International plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series11.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistMDC.get(i)));
			}
			lineChartDatePara.getData().add(series11);
		}

		if (boxpfg.isSelected()) {
			reader12 = new BufferedReader(new FileReader(companiescsvlist.get(12)));
			//Read the first line
			reader12.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader12.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistPFG.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series12 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series12.setName("Provident Financial plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series12.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistPFG.get(i)));
			}
			lineChartDatePara.getData().add(series12);
		}

		if (boxppb.isSelected()) {
			reader13 = new BufferedReader(new FileReader(companiescsvlist.get(13)));
			//Read the first line
			reader13.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader13.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistPPB.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series13 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series13.setName("Paddy Power Betfair plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series13.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistPPB.get(i)));
			}
			lineChartDatePara.getData().add(series13);
		}

		if (boxpru.isSelected()) {
			reader14 = new BufferedReader(new FileReader(companiescsvlist.get(14)));
			//Read the first line
			reader14.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader14.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistPRU.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series14 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series14.setName("Prudential plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series14.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistPRU.get(i)));
			}
			lineChartDatePara.getData().add(series14);
		}

		if (boxpsn.isSelected()) {
			reader15 = new BufferedReader(new FileReader(companiescsvlist.get(15)));
			//Read the first line
			reader15.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader15.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistPSN.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series15 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series15.setName("Persimmon plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series15.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistPSN.get(i)));
			}
			lineChartDatePara.getData().add(series15);
		}

		if (boxrb.isSelected()) {
			reader16 = new BufferedReader(new FileReader(companiescsvlist.get(16)));
			//Read the first line
			reader16.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader16.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistRB.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series16 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series16.setName("Reckitt Benckiser Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series16.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistRB.get(i)));
			}
			lineChartDatePara.getData().add(series16);
		}

		if (boxrdsa.isSelected()) {
			reader17 = new BufferedReader(new FileReader(companiescsvlist.get(17)));
			//Read the first line
			reader17.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader17.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistRDSA.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series17 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series17.setName("Royal Dutch Shell plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series17.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistRDSA.get(i)));
			}
			lineChartDatePara.getData().add(series17);
		}

		if (boxrr.isSelected()) {
			reader18 = new BufferedReader(new FileReader(companiescsvlist.get(18)));
			//Read the first line
			reader18.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader18.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistRR.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series18 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series18.setName("Rolls-Royce Holdings plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series18.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistRR.get(i)));
			}
			lineChartDatePara.getData().add(series18);
		}

		if (boxsdr.isSelected()) {
			reader19 = new BufferedReader(new FileReader(companiescsvlist.get(19)));
			//Read the first line
			reader19.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader19.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistSDR.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series19 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series19.setName("Schroders plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series19.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistSDR.get(i)));
			}
			lineChartDatePara.getData().add(series19);
		}

		if (boxshp.isSelected()) {
			reader20 = new BufferedReader(new FileReader(companiescsvlist.get(20)));
			//Read the first line
			reader20.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader20.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistSHP.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series20 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series20.setName("Shire plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series20.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistSHP.get(i)));
			}
			lineChartDatePara.getData().add(series20);
		}

		if (boxsky.isSelected()) {
			reader21 = new BufferedReader(new FileReader(companiescsvlist.get(21)));
			//Read the first line
			reader21.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader21.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistSKY.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series21 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series21.setName("SKY plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series21.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistSKY.get(i)));
			}
			lineChartDatePara.getData().add(series21);
		}

		if (boxsse.isSelected()) {
			reader22 = new BufferedReader(new FileReader(companiescsvlist.get(22)));
			//Read the first line
			reader22.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader22.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistSSE.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series22 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series22.setName("SSE plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series22.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistSSE.get(i)));
			}
			lineChartDatePara.getData().add(series22);
		}

		if (boxstj.isSelected()) {
			reader23 = new BufferedReader(new FileReader(companiescsvlist.get(23)));
			//Read the first line
			reader23.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader23.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistSTJ.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series23 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series23.setName("STJ plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series23.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistSTJ.get(i)));
			}
			lineChartDatePara.getData().add(series23);
		}

		if (boxtsco.isSelected()) {
			reader24 = new BufferedReader(new FileReader(companiescsvlist.get(24)));
			//Read the first line
			reader24.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader24.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistTSCO.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series24 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series24.setName("Tesco plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series24.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistTSCO.get(i)));
			}
			lineChartDatePara.getData().add(series24);
		}

		if (boxtui.isSelected()) {
			reader25 = new BufferedReader(new FileReader(companiescsvlist.get(25)));
			//Read the first line
			reader25.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader25.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistTUI.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series25 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series25.setName("TUI AG");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series25.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistTUI.get(i)));
			}
			lineChartDatePara.getData().add(series25);
		}

		if (boxvod.isSelected()) {
			reader26 = new BufferedReader(new FileReader(companiescsvlist.get(26)));
			//Read the first line
			reader26.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader26.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistVOD.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series26 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series26.setName("Vodafone Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series26.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistVOD.get(i)));
			}
			lineChartDatePara.getData().add(series26);
		}

		if (boxwpg.isSelected()) {
			reader27 = new BufferedReader(new FileReader(companiescsvlist.get(27)));
			//Read the first line
			reader27.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader27.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 paralistWPG.add(Double.parseDouble(alllist[parameterselectedindex+1]));
				 }
			XYChart.Series<String, Double> series27 = new XYChart.Series<String, Double>();
			//Create the series to input the chart
			series27.setName("Worldpay Group plc");
			//For each item in the list 'datePlot' and 'volumePlot'
			for (int i = 0; i < datePlot.size(); i++) {
				series27.getData().add(new XYChart.Data<String, Double>(datePlot.get(i), paralistWPG.get(i)));
			}
			lineChartDatePara.getData().add(series27);
		}
	}
}
