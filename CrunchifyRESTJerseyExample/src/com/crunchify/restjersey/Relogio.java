package com.crunchify.restjersey;

public class Relogio {
	private String hora;
	private int minutoPonteiro;
	private int horaPonteiro;
	private float angulo;
	
	public Relogio (String hora)
	{
		this.hora = hora;
		this.horaPonteiro = Integer.parseInt(hora.substring(0,2));
		this.minutoPonteiro = Integer.parseInt(hora.substring(3,5));
		this.angulo = calculaAngulo();
	}
	
	public Relogio ()
	{
		
	}
	public float calculaAngulo()
	{
		float aH, aMim;
		float horaAM;
		float aux;
		
		if (this.getHoraPonteiro() > 12)
			horaAM = this.getHoraPonteiro() - 12;
		else 
			horaAM = this.getHoraPonteiro();
		
		aH = horaAM * 30;
		aMim = this.getMinutoPonteiro() * 6;
		
		if ( aH >= aMim )
			aux = aH - aMim;
		else
			aux = aMim - aH;
		
		if (aux > 180)
			aux = 360 - aux;
		

		return aux;
	}
	
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getMinutoPonteiro() {
		return minutoPonteiro;
	}
	public void setMinutoPonteiro(int minutoPonteiro) {
		this.minutoPonteiro = minutoPonteiro;
	}
	public int getHoraPonteiro() {
		return horaPonteiro;
	}
	public void setHoraPonteiro(int horaPonteiro) {
		this.horaPonteiro = horaPonteiro;
	}
	public float getAngulo() {
		return angulo;
	}
	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}
	
}
