package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Quarto: ");
		int numQuarto = sc.nextInt();
		System.out.println("Data do check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do check-out (dd/MM/yyyy): ");
		Date checkOut= sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Não é possível realizar checkin apos data de checkout! ");
		}
		else {
			Reserva reserva=new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println("Data do check-in ATUALIZADO (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out ATUALIZADO (dd/MM/yyyy): ");
			checkOut= sdf.parse(sc.next());
			
			String error = reserva.attDatas(checkIn, checkOut);
			if (error != null) {
				System.out.println("Erro na reserva: " + error);
			}
			else{
				System.out.println("Reserva: " + reserva);
			}
		}
	sc.close();
	}
}
