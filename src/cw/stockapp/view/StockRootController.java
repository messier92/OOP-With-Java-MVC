//JAVA COURSEWORK 1 - C1868149
//Default page that displays when code is initialized

package cw.stockapp.view;

import cw.stockapp.MainApp;
import cw.stockapp.model.Company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StockRootController {
	//Declare variables and give relevant widget in the scene an ID
	@FXML
	public ChoiceBox<String> dateChoiceBox;
    @FXML
    public TableView<Company> companyTable;
    @FXML
    public TableColumn<Company, String> stockSymbolColumn;
    @FXML
    public TableColumn<Company, String> companyNameColumn;
    @FXML
    public TableColumn<Company, Double> stockOpenColumn;
    @FXML
    public TableColumn<Company, Double> stockHighColumn;
    @FXML
    public TableColumn<Company, Double> stockLowColumn;
    @FXML
    public TableColumn<Company, Double> stockCloseColumn;
    @FXML
    public TableColumn<Company, Double> stockVolumeColumn;
    @FXML
    public TableColumn<Company, Double> stockAdjCloseColumn;
    @FXML
    public Button viewbutton;
    @FXML
    public MenuItem menuabout;

    public ObservableList<Company> companyData = FXCollections.observableArrayList();

    public String inputcsvAHT = "AHT.csv";

    public ObservableList<String> lines;

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

	public ObservableList<String> companiessymbollist = FXCollections.observableArrayList("AHT.L","ANTO.L","BA.L",
            "BATS.L", "CCH.L", "CCL.L",
            "CNA.L", "CPG.L","EXPN.L",
            "EZJ.L", "GKN.L", "MDC.L",
            "PFG.L", "PPB.L", "PRU.L",
            "PSN.L", "RB.L", "RDSA.L",
            "RR.L", "SDR.L", "SHP.L",
            "SKY.L", "SSE.L", "STJ.L",
            "TSCO.L", "TUI.L","VOD.L",
            "WPG.L");

	public ObservableList<String> companiesnamelist = FXCollections.observableArrayList("Ashtead Group plc","Antofagasta plc","BAE Systems plc",
            "British American Tobacco plc", "Coca-Cola HBC AG", "Carnival plc",
            "Centrica plc", "Compass Group plc","Experian plc",
            "EasyJet plc", "GKN plc", "Mediclinic International plc",
            "Provident Financial plc", "Paddy Power Betfair plc", "Prudential plc",
            "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
            "Rolls-Royce Holdings plc", "Schroders plc", "Shire plc",
            "Sky plc", "SSE plc", "St. James's Place plc", "Tesco plc",
            "TUI AG", "Vodafone Group plc", "Worldpay Group plc");


    //Reference to the main application
    private MainApp mainApp;
	private BufferedReader reader;

    public StockRootController() {
    }


    //Set this to be the main page
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    //Initialize the columns on the main page
    @FXML
    private void initialize() {
        stockSymbolColumn.setCellValueFactory(cellData -> cellData.getValue().stockSymbolProperty());
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        stockOpenColumn.setCellValueFactory(cellData -> cellData.getValue().stockOpenProperty().asObject());
        stockHighColumn.setCellValueFactory(cellData -> cellData.getValue().stockHighProperty().asObject());
        stockLowColumn.setCellValueFactory(cellData -> cellData.getValue().stockLowProperty().asObject());
        stockCloseColumn.setCellValueFactory(cellData -> cellData.getValue().stockCloseProperty().asObject());
        stockVolumeColumn.setCellValueFactory(cellData -> cellData.getValue().stockVolumeProperty().asObject());
        stockAdjCloseColumn.setCellValueFactory(cellData -> cellData.getValue().stockAdjCloseProperty().asObject());

        menuabout.setOnAction(e -> {
        	try {
        		FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/AboutWindow.fxml"));
                AnchorPane helplayout = (AnchorPane) loader.load();
                Scene scene = new Scene(helplayout);
                Stage stageabout = new Stage();
                stageabout.setScene(scene);
                stageabout.setTitle("About");
				stageabout.show();
        	} catch (Exception e1) {
        		e1.printStackTrace();
        	}
        });
    }

    // Run the initRootLayout function on the MainApp.java to set the scene
	@FXML
	private void handleStockOverview() throws IOException {
		mainApp.initRootLayout();
	}

	//Populate the dropdown list with a list of dates from the .csv file
	public void runfuncSRC(){
		dateChoiceBox.getItems().clear();
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
				 dateChoiceBox.getItems().addAll(alllist[0]);
				 }
			reader.close();
			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }
		//Select the default option
		dateChoiceBox.getSelectionModel().select(0);
	}

	//Given the selected date in the choice box by the user, get the index and set it to load the corresponding .csv file
	@FXML
    private void setCompanyData() throws IOException {
		int selectedIndexDate = dateChoiceBox.getSelectionModel().getSelectedIndex();

    	companyTable.getItems().clear();

    	for (int i = 0; i < companiescsvlist.size(); i++) {
		List<String> lines = Files.readAllLines(Paths
				.get(companiescsvlist.get(i)));

		String entirelinedata = lines.get(selectedIndexDate+1);

		String[] columnValue = entirelinedata.split(",");

		 //Store the respective columns into lists
		 Double openColumn = Double.parseDouble(columnValue[1]);
		 Double highColumn = Double.parseDouble(columnValue[2]);
		 Double lowColumn = Double.parseDouble(columnValue[3]);
		 Double closeColumn = Double.parseDouble(columnValue[4]);
		 Double volumeColumn = Double.parseDouble(columnValue[5]);
		 Double adjCloseColumn = Double.parseDouble(columnValue[6]);

		 //Add the data to the columns
		 companyTable.setItems(companyData);
		 // adjust the string to change as well
	     companyData.add(new Company(companiessymbollist.get(i),companiesnamelist.get(i), openColumn, highColumn, lowColumn, closeColumn, volumeColumn, adjCloseColumn));
    	}
    }

	//Change the scene upon clicking this
	@FXML
	private void handleStockIndividual() {
		mainApp.showIndvPage();
	}

	//Change the scene upon clicking this
	@FXML
	private void handleStockCompare() {
		mainApp.showCmpPage();
	}

	//Change the scene upon clicking this
	@FXML
	private void handleStockPrint() {
		mainApp.showPrintPage();
	}

	//Change the scene upon clicking this
	@FXML
	private void handleStockCompareGraphs() {
		mainApp.showCmpGrpPage();
	}


}

