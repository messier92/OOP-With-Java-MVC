	//JAVA COURSEWORK 1 - C1868149
// MAINAPP.JAVA FOR CONTROLLING THE SCENES THAT WILL BE DISPLAYED

package cw.stockapp;

import java.io.IOException;

import cw.stockapp.view.StockRootController;
import cw.stockapp.view.StockViewerController;
import cw.stockapp.view.StockCompareController;
import cw.stockapp.view.StockCompareGraphController;
import cw.stockapp.view.StockPrintController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
	//Declare variables
	private Stage primaryStage;
	private BorderPane rootLayout;

	//Open the primaryStage, give it a title and run the function initRootLayout()
	@Override
	public void start(Stage primaryStage) {
			this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Stock Viewer C1868149");
	        initRootLayout();
	}

    //Initial page that the user will see upon running
    //Load the corresponding FXML file and set it to be the primary scene
    //Give it access to the the corresponding controller file
    public void initRootLayout() {
        try {
            //Load the layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StockRootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Set the scene containing the root layout (FXML file)
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            //Give the controller access to the scene
            StockRootController controller = loader.getController();
            //Call the function setData in StockRootController.java
            controller.setMainApp(this);
            controller.runfuncSRC();

            //Display the output
            primaryStage.show();
            //Catch any errors
            } catch (IOException e) {
            	e.printStackTrace();
            }
    }

    //showIndvPage function to show the charts page
	public void showIndvPage() {
        try {
            //Load the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StockViewerIndividual.fxml"));
            AnchorPane stockIndividual = (AnchorPane) loader.load();

            //Give the controller access to the scene and make the AnchorPane in the center of rootLayout
            StockViewerController svController = loader.getController();
            rootLayout.setCenter(stockIndividual);
            //Call the function setData in StockRootController.java
            svController.runfuncSVC();
           //Catch any errors
            } catch (IOException e) {
            	e.printStackTrace();
            }
    }

	//showCmpPage to show the comparison page
	public void showCmpPage() {
        try {
            //Load the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StockViewerCompare.fxml"));
            AnchorPane stockCompare = (AnchorPane) loader.load();

            //Give the controller access to the scene and make the AnchorPane in the center of rootLayout
            StockCompareController scController = loader.getController();
            rootLayout.setCenter(stockCompare);
            scController.runfuncSCC();
           //Catch any errors
            } catch (IOException e) {
            	e.printStackTrace();
            }
    }

	//showCmpPage to show the graphs
	public void showPrintPage() {
		try {
            //Load the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StockViewerPrint.fxml"));
            AnchorPane stockPrint = (AnchorPane) loader.load();

            //Give the controller access to the scene and make the AnchorPane in the center of rootLayout
            StockPrintController spController = loader.getController();
            rootLayout.setCenter(stockPrint);
            spController.runfuncSPC();
            } catch (IOException e) {
        	e.printStackTrace();
		}
	}

	//showCmpPage to show the comparison page
	public void showCmpGrpPage() {
        try {
            //Load the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StockViewerCompareGraph.fxml"));
            AnchorPane stockCompareGraph = (AnchorPane) loader.load();

            //Give the controller access to the scene and make the AnchorPane in the center of rootLayout
            StockCompareGraphController scgController = loader.getController();
            rootLayout.setCenter(stockCompareGraph);
            scgController.runfuncSCG();
           //Catch any errors
            } catch (IOException e) {
            	e.printStackTrace();
            }
    }

	//Return the primaryStage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
