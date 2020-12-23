package com.anasayfa.baran;

import javafx.beans.property.SimpleStringProperty;

public class HastalarData {
	private final SimpleStringProperty AD;
	private final SimpleStringProperty SEHIR;
	private final SimpleStringProperty MESLEK;
	private final SimpleStringProperty CINS;
	private final SimpleStringProperty ATES;
	private final SimpleStringProperty TESHIS;
	private final SimpleStringProperty TARIH;
	private final SimpleStringProperty MAIL;
	private final SimpleStringProperty MAHALLE;
	
	
	
	public HastalarData(String AD,String SEHIR,String MESLEK,String CINS,String ATES,String TESHIS,String TARIH,String MAIL,String MAHALLE) {
		this.AD=new SimpleStringProperty(AD);
		this.SEHIR=new SimpleStringProperty(SEHIR);
		this.MESLEK=new SimpleStringProperty(MESLEK);
		this.CINS=new SimpleStringProperty(CINS);
		this.ATES=new SimpleStringProperty(ATES);
		this.TESHIS=new SimpleStringProperty(TESHIS);
		this.TARIH=new SimpleStringProperty(TARIH);
		this.MAIL=new SimpleStringProperty(MAIL);
		this.MAHALLE=new SimpleStringProperty(MAHALLE);
		
		
	}

	public String getMAIL() {
		return MAIL.get();
	}

	public String getMAHALLE() {
		return MAHALLE.get();
	}

	public String getAD() {
		return AD.get();
	}
	public String getTARIH() {
		return TARIH.get();
	}

	public String getSEHIR() {
		return SEHIR.get();
	}

	public String getMESLEK() {
		return MESLEK.get();
	}

	public String getCINS() {
		return CINS.get();
	}

	public String getATES() {
		return ATES.get();
	}

	public String getTESHIS() {
		return TESHIS.get();
	}
	

}
