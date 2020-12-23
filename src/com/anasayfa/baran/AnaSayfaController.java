package com.anasayfa.baran;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.Optional;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AnaSayfaController implements Initializable{
	 String secilmisAd,secilmisMemleket,secilmisMeslek,secilmisCinsiyet,secilmisAtes,secilmisTeshis,secilmistarih;
	
	String isim=null,sehir=null,meslek=null,cinsiyet=null,teshis=null,ates=null;
	String tarih;
    String ikilisldr;
	ObservableList<HastalarData> list=FXCollections.observableArrayList();
     
	ObservableList<String> mesleklist=FXCollections.observableArrayList("Malatya","Hakkari","Hatay","Siirt","Mersin");
    
	 HastalarData secilenData;
	@FXML
    private TableView<HastalarData> tabelvw;

    @FXML
    private TableColumn<HastalarData, String> tabelvwAdi;

    @FXML
    private TableColumn<HastalarData, String> tabelvwSehri;

    @FXML
    private TableColumn<HastalarData, String> tabelvwMeslegi;

    @FXML
    private TableColumn<HastalarData, String> tabelvwCinsiyeti;

    @FXML
    private TableColumn<HastalarData, String> tabelvwAtesi;

    @FXML
    private TableColumn<HastalarData, String> tabelvwTeshisi;
    
    @FXML
    private TableColumn<HastalarData, String> tabelvwTarih;
    @FXML
    private TableColumn<HastalarData, String> tabelvwMuhtarMail;

    @FXML
    private TableColumn<HastalarData, String> tabelvwMahalle;
    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtMahalle;

    @FXML
    private JFXTextField txtAdi;

    @FXML
    private JFXComboBox<String> cmcMeslegi;

    @FXML
    private RadioButton radioIsci;

    @FXML
    private ToggleGroup meslekSinif;

    @FXML
    private RadioButton radioEmekli;

    @FXML
    private RadioButton radioMemur;

    @FXML
    private RadioButton radioOgr;

    @FXML
    private RadioButton radioErkek;

    @FXML
    private ToggleGroup cinsiyetSinif;

    @FXML
    private RadioButton radioKadin;

    @FXML
    private Slider txtsldr;

    @FXML
    private JFXCheckBox chckTeshis;

    @FXML
    private Label lblAtes;
    Alert mesajHata=new Alert(AlertType.ERROR);
    Alert mesajConfir=new Alert(AlertType.CONFIRMATION);
    Alert mesajBilgi=new Alert(AlertType.INFORMATION);
   
    
    @FXML
    private DatePicker dateBirinci;

    @FXML
    private DatePicker dateIkinci;
    @FXML
    private DatePicker dateSec1;

    @FXML
    void cmbMeslekAction(ActionEvent event) {
    	sehir=cmcMeslegi.getSelectionModel().getSelectedItem().toString();	
    }
    @FXML
    void sldrActionBitti(DragEvent event) {
        double a=txtsldr.getValue();
    	ates=Double.toString(a);
    	ikilisldr=String.format("%.1f", a);
    	lblAtes.setText(ikilisldr);
    }

    @FXML
    void sldrActionbasla(MouseEvent event) {
    	double a=txtsldr.getValue();
    	ates=Double.toString(a);
    	ikilisldr=String.format("%.1f", a);
    	lblAtes.setText(ikilisldr);

    }
   public static int seh1say=0,seh2say=0,seh3say=0,seh4say=0,seh5say=0;
	 String seh1="Malatya",seh2="Hakkari",seh3="Hatay",seh4="Siirt",seh5="Mersin";
    LocalDate tar;
    @FXML
    void ekleAction(ActionEvent event) {
    	isim=txtAdi.getText();
    	RadioButton meslekSecim=(RadioButton)meslekSinif.getSelectedToggle();
    	if(meslekSecim==radioOgr) {
			meslek=radioOgr.getText();
		}
    	else if(meslekSecim==radioEmekli) {
			meslek=radioEmekli.getText();
		}
    	else if(meslekSecim==radioIsci) {
			meslek=radioIsci.getText();
		}
    	else if(meslekSecim==radioMemur) {
			meslek=radioMemur.getText();
		}
    	else {
    		meslek="Secilmedi";
    	}
    	RadioButton cinsiyetSecim=(RadioButton)cinsiyetSinif.getSelectedToggle();
    	if(cinsiyetSecim==radioKadin) {
			cinsiyet=radioKadin.getText();
		}
    	if(cinsiyetSecim==radioErkek) {
			cinsiyet=radioErkek.getText();
		}
    	if(chckTeshis.isSelected()) {
    		teshis="Pozitif";
    	}
    	else {
    		teshis="Negatif";
    	}
    	String mail=txtMail.getText();
    	String mah=txtMahalle.getText();
    	tar=dateSec1.getValue();
    	 tarih=tar.toString();
    	HastalarData sinif=new HastalarData(isim, sehir, meslek, cinsiyet, ates, teshis,tarih,mail,mah);
    	list.add(sinif);
    	mesajBilgi.setTitle("Bilgi mesaji");
		mesajBilgi.setHeaderText("Onaylandý");
		mesajBilgi.setContentText("tabloya kayýt eklenme iþlemi baþarýlý");
		mesajBilgi.show();
		
		
		
		
			if(sehir.equals("Malatya")) {
				seh1say++;
			}
			 if(sehir.equals("Hakkari")) {
        	   seh2say++;
			}
			 if(sehir.equals("Hatay")) {
        	   seh3say++;
			}
		    if(sehir.equals("Siirt")) {
        	   seh4say++;
			}
		   if(sehir.equals("Mersin")) {
        	   seh5say++;
			}
		 
		
		
    	
    	
    }
    int index=0;
    @FXML
    void tabelvwAction(MouseEvent event) {
    	secilenData=tabelvw.getSelectionModel().getSelectedItem();
    	if(secilenData==null) {
    		mesajHata.setTitle("hata");
			mesajHata.setHeaderText("Seçim Hatasý");
			mesajHata.setContentText("Lutfen bir kayýt seciniz");
			mesajHata.show();
    	}
    	else {
    	secilmisAd=secilenData.getAD();
    	secilmisTeshis=secilenData.getTESHIS();
    	secilmisAtes=secilenData.getATES();
    	secilmisCinsiyet=secilenData.getCINS();
    	secilmisMemleket=secilenData.getSEHIR();
    	secilmisMeslek=secilenData.getMESLEK();
    	txtAdi.setText(secilenData.getAD());
    	secilmistarih=secilenData.getTARIH();
    	cmcMeslegi.setValue(secilmisMeslek);
    	if(secilmisMeslek==radioEmekli.getText()) {
			radioEmekli.setSelected(true);
		}
    	else if(secilmisMeslek==radioIsci.getText()) {
			radioIsci.setSelected(true);
		}
    	else if(secilmisMeslek==radioMemur.getText()) {
			radioMemur.setSelected(true);
		}
    	else if(secilmisMeslek==radioOgr.getText()) {
			radioOgr.setSelected(true);
		}
    	if(secilmisCinsiyet==radioErkek.getText()) {
    		radioErkek.setSelected(true);
    	}
    	else if(secilmisCinsiyet==radioKadin.getText()) {
    		radioKadin.setSelected(true);
    	}
    	lblAtes.setText(secilmisAtes);
    	if(secilmisTeshis.equals("Pozitif")) {
    		chckTeshis.setSelected(true);
    	}
    	else {
    		chckTeshis.setSelected(false);
    	}
    	
    	index=list.indexOf(secilenData);
    }}   
    @FXML
    void guncelleAction(ActionEvent event) {
    
    	mesajConfir.setTitle("Emin misiniz?");
    	mesajConfir.setHeaderText("Seçtiðiniz kayýt güncellenecektir:");
    	mesajConfir.setContentText("Seçtiðiniz kaydýn güncellensin mi?");
    	 Optional<ButtonType> result = mesajConfir.showAndWait();
    	 if(result.get()==ButtonType.OK) {
    		 isim=txtAdi.getText();
 	    	RadioButton meslekSecim=(RadioButton)meslekSinif.getSelectedToggle();
 	    	if(meslekSecim==radioOgr) {
 				meslek=radioOgr.getText();
 			}
 	    	else if(meslekSecim==radioEmekli) {
 				meslek=radioEmekli.getText();
 			}
 	    	else if(meslekSecim==radioIsci) {
 				meslek=radioIsci.getText();
 			}
 	    	else if(meslekSecim==radioMemur) {
 				meslek=radioMemur.getText();
 			}
 	    	else {
 	    		meslek="Secilmedi";
 	    	}
 	    	RadioButton cinsiyetSecim=(RadioButton)cinsiyetSinif.getSelectedToggle();
 	    	if(cinsiyetSecim==radioKadin) {
 				cinsiyet=radioKadin.getText();
 			}
 	    	if(cinsiyetSecim==radioErkek) {
 				cinsiyet=radioErkek.getText();
 			}
 	    	if(chckTeshis.isSelected()) {
 	    		teshis="Pozitif";
 	    	}
 	    	else {
 	    		teshis="Negatif";
 	    	}
 	    	LocalDate xxx=dateSec1.getValue();
 	    	String yyy=xxx.toString();
 	    	String h=txtMail.getText();
 	    	String l=txtMahalle.getText();
    		HastalarData kk=new HastalarData(isim, sehir, meslek, cinsiyet, ates, teshis,yyy,h,l);
    		list.set(index, kk);
    }
    	 }
    
    @FXML
    void silAction(ActionEvent event) {
    	list.remove(secilenData);
    	tabelvw.getItems().remove(secilenData);
    	mesajBilgi.setTitle("Bilgi mesaji");
		mesajBilgi.setHeaderText("Onaylandý");
		mesajBilgi.setContentText("tabloya kayýt eklenme iþlemi baþarýlý");
		mesajBilgi.show();

    }
    
    @FXML
    void sorgulaAction(ActionEvent event) {
    	int sayi=0;
    	double toplam=0;
    	double ortalama=0;
    	for(HastalarData i:list) {
    	
    		if(i.getSEHIR().equals(sehir)) {
    			sayi++;
    			double a=Double.parseDouble(i.getATES());
    			toplam+=a;
    		}
    	}
    	ortalama=toplam/sayi;
    	mesajBilgi.setTitle("Bilgi");
		mesajBilgi.setHeaderText(sehir+" inin istatistikleri:");
		mesajBilgi.setContentText(sehir+" inde hasta sayisi: "+sayi+" ve ates ortalama: "+new DecimalFormat("##.##").format(ortalama));
		mesajBilgi.show();
		
	
    }
    LocalDate a,b,c;
    int x,y,z;
    @FXML
    void birinciDate(ActionEvent event) {
    	a=dateBirinci.getValue();
    	x=a.getDayOfYear();
    	
    	
    	
    }
  
    @FXML
    void ikinciDate(ActionEvent event) {
    	b=dateIkinci.getValue();
    	y=b.getDayOfYear();
    	
    }
  
    int zzz;
    ArrayList<Integer> array=new ArrayList<Integer>();
    @FXML
    void tariheSoreSorgula(ActionEvent event) {
    	 
    	
    	for(HastalarData i : list) {
    		c=LocalDate.parse(i.getTARIH());
    		z=c.getDayOfYear();
    		
    		if(z<=x || z>=y) {
    		
    		zzz=list.indexOf(i);
		
    		array.add(zzz);
    		
    		}	
    	}
    	for(int i=0;i<array.size();i++) {
    		HastalarData aa=new HastalarData("", "", "","","", "", "","","");
    		list.set(array.get(i),aa);
    	
    		
    		}
    	
    }
 public static  ObservableList<String> listem2=FXCollections.observableArrayList();
    @FXML
    void istatistiklerAction(ActionEvent event) {
    	Sehirsayilarý a=new Sehirsayilarý(seh1, seh1say);
		Sehirsayilarý b=new Sehirsayilarý(seh2, seh2say);
		Sehirsayilarý c=new Sehirsayilarý(seh3, seh3say);
		Sehirsayilarý d=new Sehirsayilarý(seh4, seh4say);
		Sehirsayilarý e=new Sehirsayilarý(seh5, seh5say);
		listem.add(a);
		listem.add(b);
		listem.add(c);
		listem.add(d);
		listem.add(e);
		
		
		try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/anaSayfa/baran/Istatistikler.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ey) {
			// TODO Auto-generated catch block
			ey.printStackTrace();
		}
    }
    
public static ObservableList<Sehirsayilarý> listem=FXCollections.observableArrayList();
public static ObservableList<HastalarData> MailGonderilecekListesi=FXCollections.observableArrayList();
          @FXML
         void tarihMuhtaraMailAt(ActionEvent event) {
        	  for(HastalarData i : list) {
          		c=LocalDate.parse(i.getTARIH());
          		z=c.getDayOfYear();
          		
          		if(z>=x && z<=y) {
          		
  HastalarData kkk=new HastalarData(i.getAD(), i.getSEHIR(), i.getMESLEK(),i.getCINS(), i.getATES(), i.getTESHIS(), i.getTARIH(),i.getMAIL(),i.getMAHALLE());
  MailGonderilecekListesi.add(kkk);
          	
          		}	
          		}
        	  for(HastalarData i:MailGonderilecekListesi) {
        		  try {
					JavaMailGonderme.sendMail(i.getMAIL());
				} catch (Exception e) {
					e.printStackTrace();
				}
        	  }
        	
        	  	
              }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chckTeshis.setSelected(false);
		cmcMeslegi.getItems().addAll(mesleklist);
		tabelvwAdi.setCellValueFactory(new PropertyValueFactory<>("AD"));
		tabelvwSehri.setCellValueFactory(new PropertyValueFactory<>("SEHIR"));
		tabelvwMeslegi.setCellValueFactory(new PropertyValueFactory<>("MESLEK"));
		tabelvwCinsiyeti.setCellValueFactory(new PropertyValueFactory<>("CINS"));
		tabelvwAtesi.setCellValueFactory(new PropertyValueFactory<>("ATES"));
		tabelvwTeshisi.setCellValueFactory(new PropertyValueFactory<>("TESHIS"));
		tabelvwTarih.setCellValueFactory(new PropertyValueFactory<>("TARIH"));
		tabelvwMuhtarMail.setCellValueFactory(new PropertyValueFactory<>("MAIL"));
		tabelvwMahalle.setCellValueFactory(new PropertyValueFactory<>("MAHALLE"));
		tabelvw.setItems(list);
		
		
	
		
		
	}
}
