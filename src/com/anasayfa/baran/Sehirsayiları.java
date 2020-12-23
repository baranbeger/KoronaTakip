package com.anasayfa.baran;

public class Sehirsayiları {
	String sehir;
	int hastasayi;

	public Sehirsayiları(String sehir,int hastaSayi) {
		this.hastasayi=hastaSayi;
		this.sehir = sehir;
		
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public int getHastasayi() {
		return hastasayi;
	}

	public void setHastasayi(int hastasayi) {
		this.hastasayi = hastasayi;
	}
	
	
	
}
