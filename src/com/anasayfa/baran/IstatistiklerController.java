package com.anasayfa.baran;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

public class IstatistiklerController implements Initializable{
    @FXML
    private PieChart pie;

    @FXML
    private BarChart<?, ?> barchart;

    @FXML
    private CategoryAxis xchart;

    @FXML
    private NumberAxis ychart;
   ObservableList<PieChart.Data> pielist=FXCollections.observableArrayList(
			new PieChart.Data("basdad", 5),
			new PieChart.Data("asdasd", 4),
			new PieChart.Data("fdgdfg", 5),
			new PieChart.Data("sdfsdf", 1),
			new PieChart.Data("sdfsdfdsf", 2)
			);
	
    @FXML
    void pieAction(MouseEvent event) {
    	
    	pie.getData().addAll(pielist);
    
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for(Sehirsayilarý i:AnaSayfaController.listem) {
			barchart.setTitle("Þehirlere Göre Hastalar");
			XYChart.Series seri=new XYChart.Series();
			seri.getData().add(new XYChart.Data<>(i.getSehir(),i.getHastasayi()));
	          	barchart.getData().add(seri);
	          	
		
			
		}
		   ObservableList<PieChart.Data> pielist=FXCollections.observableArrayList(
					new PieChart.Data("basdad", 5),
					new PieChart.Data("asdasd", 4),
					new PieChart.Data("fdgdfg", 5),
					new PieChart.Data("sdfsdf", 1),
					new PieChart.Data("sdfsdfdsf", 2)
					);
		
		   pie.getData().addAll(pielist);
	}
}
