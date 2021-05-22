package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excessoes.DominioExcessao;

public class Program {

	public static void main(String[] args){

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Quarto: ");
			int numQuarto = sc.nextInt();
			System.out.println("Data do check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out (dd/MM/yyyy): ");
			Date checkOut= sdf.parse(sc.next());
			
		
			Reserva reserva=new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("Data do check-in ATUALIZADO (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do check-out ATUALIZADO (dd/MM/yyyy): ");
			checkOut= sdf.parse(sc.next());
			
			reserva.attDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch(DominioExcessao e) {
			System.out.println("Erro na reserva" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	sc.close();
	}
}
