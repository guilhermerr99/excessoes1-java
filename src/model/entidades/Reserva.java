package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getNumQuarto() {
		return numQuarto;
	}


	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}	
	
	public long duraçao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String attDatas(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return " Não é possível realizar pois devem ser datas futuras! ";
		}
		if(!checkOut.after(checkIn)) {
			return " Não é possível realizar checkin apos data de checkout! ";
		}
		this.checkIn = checkIn;
		this.checkOut= checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto"
			  + numQuarto
			  + ", check-in: "
			  + sdf.format(checkIn)
			  +	", check-out: "
			  + sdf.format(checkOut)
			  + ", "
			  + duraçao()
			  + " noites";
	}
	
	
}
