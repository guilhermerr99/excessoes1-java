package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excessoes.DominioExcessao;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DominioExcessao {
		if(!checkOut.after(checkIn)) {
			throw new DominioExcessao(" Não é possível realizar checkin apos data de checkout! ");
		}
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
	
	public void attDatas(Date checkIn, Date checkOut) throws DominioExcessao {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DominioExcessao(" Não é possível realizar pois devem ser datas futuras! ");
		}
		if(!checkOut.after(checkIn)) {
			throw new DominioExcessao(" Não é possível realizar checkin apos data de checkout! ");
		}
		this.checkIn = checkIn;
		this.checkOut= checkOut;
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
