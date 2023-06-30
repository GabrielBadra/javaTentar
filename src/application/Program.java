package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entiteis.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		Date checkout = sdf.parse(sc.next());
	
		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		System.out.println("Reservation: " + reservation);
			
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in: ");
		checkin = sdf.parse(sc.next());
		System.out.print("Check-out: ");
		checkout = sdf.parse(sc.next());
			
			
		reservation.updateDates(checkin, checkout);
		System.out.println("Reservation: " + reservation);
		
		}catch(ParseException e) {
			System.out.println("Invalid date format.");
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("Erro não identificado.");
		}

		sc.close();
	}

}
