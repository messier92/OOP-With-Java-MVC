//JAVA COURSEWORK 1 - C1868149
//Page to print the .txt file and show a summary of all the .csv files

package cw.stockapp.view;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockPrintController {
	//Declare variables and give relevant widget in the scene an ID
	@FXML
	private ChoiceBox<String> companyChoiceBox3;
    @FXML
    private Label numLabel;
    @FXML
    private Label stocksymbolLabel;
    @FXML
    private Label companynameLabel;
    @FXML
    private Label highestLabel;
    @FXML
    private Label lowestLabel;
    @FXML
    private Label avgcloseLabel;
    @FXML
    private Label closeLabel;
    @FXML
    private Label higheststockopeningeverLabel;
    @FXML
    private Label loweststockopeningeverLabel;
    @FXML
    private Label higheststockeverLabel;
    @FXML
    private Label loweststockeverLabel;
    @FXML
    private Label highestvolumeeverLabel;
    @FXML
    private Label lowestvolumeeverLabel;

	public ObservableList<String> companiesnamelist = FXCollections.observableArrayList("Ashtead Group plc","Antofagasta plc","BAE Systems plc",
            "British American Tobacco plc", "Coca-Cola HBC AG", "Carnival plc",
            "Centrica plc", "Compass Group plc","Experian plc",
            "EasyJet plc", "GKN plc", "Mediclinic International plc",
            "Provident Financial plc", "Paddy Power Betfair plc", "Prudential plc",
            "Persimmon plc", "Reckitt Benckiser Group plc", "Royal Dutch Shell plc",
            "Rolls-Royce Holdings plc", "Schroders plc", "Shire plc",
            "Sky plc", "SSE plc", "St. James's Place plc", "Tesco plc",
            "TUI AG", "Vodafone Group plc", "Worldpay Group plc");

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

	private static ObservableList<String> companiesprintparameters = FXCollections.observableArrayList("Number:","Stock Symbol:","Company Name:","Highest:","Lowest:","Average Close:","Close:");


    public ObservableList<String> dateList = FXCollections.observableArrayList();
    public ObservableList<String> dateList65 = FXCollections.observableArrayList();
    public ObservableList<Double> openList = FXCollections.observableArrayList();
    public ObservableList<Double> highestList = FXCollections.observableArrayList();
    public ObservableList<Double> lowestList = FXCollections.observableArrayList();
    public ObservableList<Double> closeList = FXCollections.observableArrayList();
    public ObservableList<Double> volumeList = FXCollections.observableArrayList();

    public ObservableList<String> dateListPrint = FXCollections.observableArrayList();
    public ObservableList<Double> highestListPrint = FXCollections.observableArrayList();
    public ObservableList<Integer> highestListIndexHolder = FXCollections.observableArrayList();
    public ObservableList<String> highestListIndexDate = FXCollections.observableArrayList();
    public ObservableList<Integer> lowestListIndexHolder = FXCollections.observableArrayList();
    public ObservableList<String> lowestListIndexDate = FXCollections.observableArrayList();
    public ObservableList<Double> lowestListPrint = FXCollections.observableArrayList();
    public ObservableList<Double> closeAvgListPrint = FXCollections.observableArrayList();
    public ObservableList<Double> closeListPrint = FXCollections.observableArrayList();

	public Double higheststockdbl;
	public Double loweststockdbl;
	public Double avgclosedbl;
	public Double latestclosedbl;
	public String loweststockdatestr;
	public String higheststockdatestr;

	public String dateMaxOpen;
	public String maxOpenCompany;
	public String maxOpen;
	public String dateMinOpen;
	public String minOpenCompany;
	public String minOpen;
	public String dateMaxHigh;
	public String maxHigh;
	public String maxHighCompany;
	public String minLowCompany;
	public String minLow;
	public String dateMinLow;
	public String minVolCompany;
	public String volLow;
	public String dateVolLow;
	public String maxVolCompany;
	public String volHigh;
	public String dateVolHigh;

	private BufferedReader reader;
    public Window primaryStage = null;

    @FXML
    private void initialize() throws IOException {
    	numLabel.setText("");
    	stocksymbolLabel.setText("");
    	companynameLabel.setText("");
		highestLabel.setText("");
		lowestLabel.setText("");
		avgcloseLabel.setText("");
		closeLabel.setText("");

		try {
			for (int i = 0; i < companiescsvlist.size(); i++ ) {
			reader = new BufferedReader(new FileReader(companiescsvlist.get(i)));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line=null;
			// While the list is not null
			while ((line = reader.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 dateList.add(alllist[0]);
				 openList.add(Double.parseDouble(alllist[1]));
				 highestList.add(Double.parseDouble(alllist[2]));
				 lowestList.add(Double.parseDouble(alllist[3]));
				 closeList.add(Double.parseDouble(alllist[4]));
				 volumeList.add(Double.parseDouble(alllist[5]));
				 }
			reader.close();
			}

			int size = 65;
		    for (int start = 0; start < highestList.size(); start += size) {
		        int end = Math.min(start + size, highestList.size());
				List<Double> sublist = highestList.subList(start, end);
				higheststockdbl = Collections.max(sublist);
				int highestListIndex = highestList.indexOf(higheststockdbl);
				highestListPrint.add(higheststockdbl);
				highestListIndexHolder.add(highestListIndex);
		    }

		    for (int i = 0; i < highestListIndexHolder.size(); i++ ) {
		    	highestListIndexDate.add(dateList.get(highestListIndexHolder.get(i)));
		    }

		    for (int start = 0; start < lowestList.size(); start += size) {
		        int end = Math.min(start + size, lowestList.size());
				List<Double> sublist = lowestList.subList(start, end);
				loweststockdbl = Collections.min(sublist);
				int lowestListIndex = lowestList.indexOf(loweststockdbl);
				lowestListPrint.add(loweststockdbl);
				lowestListIndexHolder.add(lowestListIndex);
		    }

		    for (int i = 0; i < lowestListIndexHolder.size(); i++ ) {
		    	lowestListIndexDate.add(dateList.get(lowestListIndexHolder.get(i)));
		    }

		    for (int start = 0; start < closeList.size(); start += size) {
		        int end = Math.min(start + size, closeList.size());
				List<Double> sublist = closeList.subList(start, end);
				double sum = sublist.stream().mapToInt(Double::intValue).sum();
				closeAvgListPrint.add(sum/size);
		    }

			//Latest Closing Price for all Companies
			for (int cl = 0; cl < closeList.size() ; cl+= 65) {
			closeListPrint.add(closeList.get(cl));
			}
			//Latest Closing Price for all Companies
			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }

		//Get the maximum/minimum respective values
		double maxOpen = Collections.max(openList);
		double minOpen = Collections.min(openList);
		double maxHigh = Collections.max(highestList);
		double minLow = Collections.min(lowestList);
		double volHigh = Collections.max(volumeList);
		double volLow = Collections.min(volumeList);

		//Get the index of it
		int maxOpenListIndex = openList.indexOf(maxOpen);
		int minOpenListIndex = openList.indexOf(minOpen);
		int maxHighListIndex = highestList.indexOf(maxHigh);
		int minLowListIndex = lowestList.indexOf(minLow);
		int maxVolListIndex = volumeList.indexOf(volHigh);
		int minVolListIndex = volumeList.indexOf(volLow);

		//Get the company that it belongs to by dividing by 65 (as there are 65 rows per .csv)
		int maxOpenCompanyIndex = (maxOpenListIndex/65);
		int minOpenCompanyIndex = (minOpenListIndex/65);
		int maxHighCompanyIndex = (maxHighListIndex/65);
		int minLowCompanyIndex = (minLowListIndex/65);
		int maxVolCompanyIndex = (maxVolListIndex/65);
		int minVolCompanyIndex = (minVolListIndex/65);

		//Get the company name
		String maxOpenCompany = companiesnamelist.get(maxOpenCompanyIndex);
		String minOpenCompany = companiesnamelist.get(minOpenCompanyIndex);
		String maxHighCompany = companiesnamelist.get(maxHighCompanyIndex);
		String minLowCompany = companiesnamelist.get(minLowCompanyIndex);
		String maxVolCompany = companiesnamelist.get(maxVolCompanyIndex);
		String minVolCompany = companiesnamelist.get(minVolCompanyIndex);

		//Get the starting index of that company
		int Openindextominusmax = maxOpenCompanyIndex*65;
		int Openindextominusmin = minOpenCompanyIndex*65;
		int Highindextominusmax = maxHighCompanyIndex*65;
		int Lowindextominusmax = minLowCompanyIndex*65;
		int HighVolindextominusmax = maxVolCompanyIndex*65;
		int LowVolindextominusmax = minVolCompanyIndex*65;

		//Get the index of the date in the .csv
		int Opencompanypositionmax = maxOpenListIndex - Openindextominusmax;
		int Opencompanypositionmin = minOpenListIndex - Openindextominusmin;
		int Highestcompanypositionmin = maxHighListIndex - Highindextominusmax;
		int Lowestcompanypositionmin = minLowListIndex - Lowindextominusmax;
		int HighestVolcompanypositionmin = maxVolListIndex - HighVolindextominusmax;
		int LowestVolcompanypositionmin = minVolListIndex - LowVolindextominusmax;

		//Feed in a .csv to get all the dates
		String inputcsv = companiescsvlist.get(maxOpenCompanyIndex);
		reader = new BufferedReader(new FileReader(inputcsv));
		//Read the first line
		reader.readLine();
		// Set string 'line' to null
		String line=null;
		// While the list is not null
		while ((line = reader.readLine()) != null){
			 // Split each string and store them into a list called 'alllist'
			 String[] alllist = line.split(",");
			 //Populate the dropdown list with the items inside 'alllist'
			 dateList65.add(alllist[0]);
		}

		//Get the respective dates
		dateMaxOpen = dateList65.get(Opencompanypositionmax);
		dateMinOpen = dateList65.get(Opencompanypositionmin);
		dateMaxHigh = dateList65.get(Highestcompanypositionmin);
		dateMinLow = dateList65.get(Lowestcompanypositionmin);
		dateVolHigh = dateList65.get(HighestVolcompanypositionmin);
		dateVolLow = dateList65.get(LowestVolcompanypositionmin);

		//Append to the labels
		higheststockopeningeverLabel.setText(maxOpenCompany + ", Stock Price: " + maxOpen + " on " + dateMaxOpen);
		loweststockopeningeverLabel.setText(minOpenCompany + ", Stock Price: " + minOpen + " on " + dateMinOpen);
		higheststockeverLabel.setText(maxHighCompany + ", Stock Price: " + maxHigh + " on " + dateMaxHigh);
		loweststockeverLabel.setText(minLowCompany + ", Stock Price: " + minLow + " on " + dateMinLow);
		highestvolumeeverLabel.setText(maxVolCompany + ", Stock Price: " + volHigh + " on " + dateVolHigh);
		lowestvolumeeverLabel.setText(minVolCompany + ", Stock Price: " + volLow + " on " + dateVolLow);
    }




	public void runfuncSPC(){
		companyChoiceBox3.getItems().addAll(companiesnamelist);
		companyChoiceBox3.getSelectionModel().select(0);
	}

	public void viewData() throws IOException {
		highestList.clear();
		lowestList.clear();
		closeList.clear();

		int selectedIndexCompany= companyChoiceBox3.getSelectionModel().getSelectedIndex();
		int sequencenumber = selectedIndexCompany + 1;
		String selectedsymbolCompany = companiessymbollist.get(selectedIndexCompany);
		String selectednameCompany = companiesnamelist.get(selectedIndexCompany);
		String inputcsv = companiescsvlist.get(selectedIndexCompany);

		try {
			reader = new BufferedReader(new FileReader(inputcsv));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line=null;
			// While the list is not null
			while ((line = reader.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 dateList.add(alllist[0]);
				 highestList.add(Double.parseDouble(alllist[2]));
				 lowestList.add(Double.parseDouble(alllist[3]));
				 closeList.add(Double.parseDouble(alllist[4]));
				 }
			reader.close();
			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }

		higheststockdbl = Collections.max(highestList);
		int highestListIndex = highestList.indexOf(higheststockdbl);
		higheststockdatestr = dateList.get(highestListIndex);

		loweststockdbl = Collections.min(lowestList);
		int lowestListIndex = lowestList.indexOf(loweststockdbl);
		loweststockdatestr = dateList.get(lowestListIndex);

		double sum = 0;
		Iterator<Double> iter1 = closeList.iterator();
		while (iter1.hasNext()) {
		    sum += iter1.next();
		}
		double average = sum / closeList.size();

		latestclosedbl = closeList.get(0);

		numLabel.setText(String.valueOf(sequencenumber));
	    stocksymbolLabel.setText(selectedsymbolCompany);
	    companynameLabel.setText(selectednameCompany);
	    highestLabel.setText(Double.toString(higheststockdbl) + " on " + higheststockdatestr);
	    lowestLabel.setText(Double.toString(loweststockdbl) + " on " + loweststockdatestr);
	    avgcloseLabel.setText(Double.toString(average));
	    closeLabel.setText(Double.toString(latestclosedbl));
	}

	public void printData() throws IOException {
		dateList.clear();
		highestList.clear();
		lowestList.clear();
		closeList.clear();
		highestListPrint.clear();
		lowestListPrint.clear();
		closeListPrint.clear();

		try {
			for (int i = 0; i < companiescsvlist.size(); i++ ) {
			reader = new BufferedReader(new FileReader(companiescsvlist.get(i)));
			//Read the first line
			reader.readLine();
			// Set string 'line' to null
			String line=null;
			// While the list is not null
			while ((line = reader.readLine()) != null){
				 // Split each string and store them into a list called 'alllist'
				 String[] alllist = line.split(",");
				 //Populate the dropdown list with the items inside 'alllist'
				 dateList.add(alllist[0]);
				 openList.add(Double.parseDouble(alllist[1]));
				 highestList.add(Double.parseDouble(alllist[2]));
				 lowestList.add(Double.parseDouble(alllist[3]));
				 closeList.add(Double.parseDouble(alllist[4]));
				 volumeList.add(Double.parseDouble(alllist[5]));
				 }
			reader.close();
			}

			int size = 65;
		    for (int start = 0; start < highestList.size(); start += size) {
		        int end = Math.min(start + size, highestList.size());
				List<Double> sublist = highestList.subList(start, end);
				higheststockdbl = Collections.max(sublist);
				int highestListIndex = highestList.indexOf(higheststockdbl);
				highestListPrint.add(higheststockdbl);
				highestListIndexHolder.add(highestListIndex);
		    }

		    for (int i = 0; i < highestListIndexHolder.size(); i++ ) {
		    	highestListIndexDate.add(dateList.get(highestListIndexHolder.get(i)));
		    }

		    for (int start = 0; start < lowestList.size(); start += size) {
		        int end = Math.min(start + size, lowestList.size());
				List<Double> sublist = lowestList.subList(start, end);
				loweststockdbl = Collections.min(sublist);
				int lowestListIndex = lowestList.indexOf(loweststockdbl);
				lowestListPrint.add(loweststockdbl);
				lowestListIndexHolder.add(lowestListIndex);
		    }

		    for (int i = 0; i < lowestListIndexHolder.size(); i++ ) {
		    	lowestListIndexDate.add(dateList.get(lowestListIndexHolder.get(i)));
		    }


			int sum = 0;
			for (Double num:closeList) {
				sum+=num;
			}
			closeAvgListPrint.add((((double) sum/65)));

			closeAvgListPrint.remove(28);

			//Latest Closing Price for all Companies
			for (int cl = 0; cl < closeList.size() ; cl+= 65) {
			closeListPrint.add(closeList.get(cl));
			}
			//Latest Closing Price for all Companies
			//Exception error
    		} catch (Exception e) {
	     		e.printStackTrace();
		    }

	    FileChooser fileChooser = new FileChooser();

	     //Set extension filter
	     FileChooser.ExtensionFilter extFilter =
	                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	     fileChooser.getExtensionFilters().add(extFilter);

	     //Show save file dialog
		 File file = fileChooser.showSaveDialog(primaryStage);

         FileWriter fileWriter;
         fileWriter = new FileWriter(file,true);
         BufferedWriter br = new BufferedWriter(fileWriter);

         for (int i = 0; i < 28; i++ ) {
        	br.write(companiesprintparameters.get(0));
        	br.write(String.valueOf(i+1));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(1));
        	br.write(companiessymbollist.get(i));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(2));
        	br.write(companiesnamelist.get(i));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(3));
        	br.write(String.valueOf(highestListPrint.get(i)));
        	br.write(" on ");
        	br.write(String.valueOf(highestListIndexDate.get(i)));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(4));
        	br.write(String.valueOf(lowestListPrint.get(i)));
        	br.write(" on ");
        	br.write(String.valueOf(lowestListIndexDate.get(i)));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(5));
        	br.write(String.valueOf(closeAvgListPrint.get(i)));
        	br.write("\r\n");
        	br.write(companiesprintparameters.get(6));
        	br.write(String.valueOf(closeListPrint.get(i)));
        	br.write("\r\n");
        	br.write("\r\n");
         }
        br.close();
        fileWriter.close();
	}
   }
