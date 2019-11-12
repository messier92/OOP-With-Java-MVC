//JAVA COURSEWORK 1 - C1868149
//COMPANYCOMPARE CLASS HAS COMPANYSTRPARAMETERS, COMPANY1PARAMETERS, COMPANY2PARAMETERS, COMPANYDIFFPARAMETERS
//Parameters to be compared are: Open, High, Low, Close, Volume and Adj. Close

package cw.stockapp.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import cw.stockapp.model.CompanyCompare;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class StockCompareController {
	//Declare variables and give relevant widget in the scene an ID
	@FXML
	public ChoiceBox<String> dateChoiceBox1;
	@FXML
	public ChoiceBox<String> companyChoiceBox1;
	@FXML
	public ChoiceBox<String> companyChoiceBox2;

    @FXML
    public TableView<CompanyCompare> companyTableCompare;
    @FXML
    public TableColumn<CompanyCompare, String> companyParametersColumn;
    @FXML
    public TableColumn<CompanyCompare, Double> company1Column;
    @FXML
    public TableColumn<CompanyCompare, Double> company2Column;
    @FXML
    public TableColumn<CompanyCompare, Double> companyDifferenceColumn;

    private ObservableList<CompanyCompare> companyDataCompare = FXCollections.observableArrayList();

	private ObservableList<String> companiesCompareParameters = FXCollections.observableArrayList("Open","High","Low","Close","Volume","Adj. Close");
    private ObservableList<Double> company1Compare = FXCollections.observableArrayList();
    private ObservableList<Double> company2Compare = FXCollections.observableArrayList();
    private ObservableList<Double> companyDiffCompare = FXCollections.observableArrayList();

	public String inputcsvAHT = "AHT.csv";
	public int selectedIndexDate;

	public ArrayList<Double> volume1 = new ArrayList<Double>();
	public ArrayList<Double> open1 = new ArrayList<Double>();
	public ArrayList<Double> close1 = new ArrayList<Double>();
	public ArrayList<Double> high1 = new ArrayList<Double>();
	public ArrayList<Double> low1 = new ArrayList<Double>();
	public ArrayList<Double> adjclose1 = new ArrayList<Double>();

	public ArrayList<Double> volume2 = new ArrayList<Double>();
	public ArrayList<Double> open2 = new ArrayList<Double>();
	public ArrayList<Double> close2 = new ArrayList<Double>();
	public ArrayList<Double> high2 = new ArrayList<Double>();
	public ArrayList<Double> low2 = new ArrayList<Double>();
	public ArrayList<Double> adjclose2 = new ArrayList<Double>();

	public ObservableList<String> companiesnamelist = FXCollections.observableArrayList("Ashtead Group plc","Antofagasta plc","BAE Systems plc",
            "British American Tobacco plc", "Coca-Cola HBC AG", "Carnival plc",
            "Centrica plc", "Compass Group plc","Experian plc",
            "EasyJet plc", "GKN plc", "Mediclinic International plc",
            "Provident Financial plc", "Paddy Power Betfair plc", "Prudential plc",
            "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
            "Rolls-Royce Holdings plc", "Schroders plc", "Shire plc",
            "Sky plc", "SSE plc", "St. James's Place plc", "Tesco plc",
            "TUI AG", "Vodafone Group plc", "Worldpay Group plc");

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

    //Reference to the main application
	private BufferedReader reader;

	//Initialize the table columns upon loading
    @FXML
    private void initialize() {
    	companyParametersColumn.setCellValueFactory(cellData -> cellData.getValue().companyStrParametersProperty());
    	company1Column.setCellValueFactory(cellData -> cellData.getValue().company1ParametersProperty().asObject());
    	company2Column.setCellValueFactory(cellData -> cellData.getValue().company2ParametersProperty().asObject());
        companyDifferenceColumn.setCellValueFactory(cellData -> cellData.getValue().companyDiffParametersProperty().asObject());
    }

    //Run the function setData() to populate the dropdown lists
	public void runfuncSCC(){
		companyChoiceBox1.getItems().addAll(companiesnamelist);
		companyChoiceBox2.getItems().addAll(companiesnamelist);
		dateChoiceBox1.getItems().clear();
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
				 dateChoiceBox1.getItems().addAll(alllist[0]);
				 }
			reader.close();
			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }
		//Select the default option
		dateChoiceBox1.getSelectionModel().select(0);
		companyChoiceBox1.getSelectionModel().select(0);
		companyChoiceBox2.getSelectionModel().select(0);
	}

	//Upon clicking the button to compare the company,
	//Get the relevant data of each company and find the difference between each parameter
	public void compareCompany() throws IOException {
		company1Compare.clear();
		company2Compare.clear();
		companyDiffCompare.clear();
		companyTableCompare.getItems().clear();
		open1.clear();
		open2.clear();
		high1.clear();
		high2.clear();
		low1.clear();
		low2.clear();
		close1.clear();
		close2.clear();
		volume1.clear();
		volume2.clear();
		adjclose1.clear();
		adjclose2.clear();

		int selectedIndexDate = dateChoiceBox1.getSelectionModel().getSelectedIndex();

		int selectedIndexCompany1 = companyChoiceBox1.getSelectionModel().getSelectedIndex();

		int selectedIndexCompany2 = companyChoiceBox2.getSelectionModel().getSelectedIndex();

		try {
			reader = new BufferedReader(new FileReader(companiescsvlist.get(selectedIndexCompany1)));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line1=null;
			// While the list is not null
			while ((line1 = reader.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist1 = line1.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 open1.add(Double.parseDouble(alllist1[1]));
				 high1.add(Double.parseDouble(alllist1[2]));
				 low1.add(Double.parseDouble(alllist1[3]));
				 close1.add(Double.parseDouble(alllist1[4]));
				 volume1.add(Double.parseDouble(alllist1[5]));
				 adjclose1.add(Double.parseDouble(alllist1[6]));
				 alllist1 = null;
				 }
		}  catch (Exception e) {
 		e.printStackTrace();
    }

		try {
			reader = new BufferedReader(new FileReader(companiescsvlist.get(selectedIndexCompany2)));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line2=null;
			// While the list is not null
			while ((line2 = reader.readLine()) != null){
			// Split each string and store them into a list called 'alllist'
			String[] alllist2 = line2.split(",");
			//Populate the dropdown list with the items inside 'alllist'
			open2.add(Double.parseDouble(alllist2[1]));
			high2.add(Double.parseDouble(alllist2[2]));
			low2.add(Double.parseDouble(alllist2[3]));
			close2.add(Double.parseDouble(alllist2[4]));
			volume2.add(Double.parseDouble(alllist2[5]));
			adjclose2.add(Double.parseDouble(alllist2[6]));
			}

		} catch (Exception e) {
     		e.printStackTrace();
	    }

		company1Compare.add(open1.get(selectedIndexDate));
		company1Compare.add(high1.get(selectedIndexDate));
		company1Compare.add(low1.get(selectedIndexDate));
		company1Compare.add(close1.get(selectedIndexDate));
		company1Compare.add(volume1.get(selectedIndexDate));
		company1Compare.add(adjclose1.get(selectedIndexDate));

		company2Compare.add(open2.get(selectedIndexDate));
		company2Compare.add(high2.get(selectedIndexDate));
		company2Compare.add(low2.get(selectedIndexDate));
		company2Compare.add(close2.get(selectedIndexDate));
		company2Compare.add(volume2.get(selectedIndexDate));
		company2Compare.add(adjclose2.get(selectedIndexDate));

	 	Double diffOpen = open1.get(selectedIndexDate) - open2.get(selectedIndexDate);
		Double diffHigh = high1.get(selectedIndexDate) - high2.get(selectedIndexDate);
		Double diffLow = low1.get(selectedIndexDate) - low2.get(selectedIndexDate);
		Double diffClose = close1.get(selectedIndexDate) - close2.get(selectedIndexDate);
		Double diffVolume = volume1.get(selectedIndexDate) - volume2.get(selectedIndexDate);
		Double diffAdjClose = adjclose1.get(selectedIndexDate) - adjclose2.get(selectedIndexDate);

		companyDiffCompare.add(diffOpen);
		companyDiffCompare.add(diffHigh);
		companyDiffCompare.add(diffLow);
		companyDiffCompare.add(diffClose);
		companyDiffCompare.add(diffVolume);
		companyDiffCompare.add(diffAdjClose);

		//Load all the retrieved and calculated data into the table
		companyTableCompare.setItems(companyDataCompare);

		for (int i = 0; i < companiesCompareParameters.size(); i++) {
		companyDataCompare.add(new CompanyCompare(companiesCompareParameters.get(i),company1Compare.get(i),company2Compare.get(i),companyDiffCompare.get(i)));
		}
	}
}





