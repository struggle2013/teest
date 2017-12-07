package pres.luo.testThread;

import java.util.Scanner;

public class TicketManagementSytem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		Scanner scaner = new Scanner(System.in);
		System.out.println("请输入行数：");
		//scaner.nextLine();
		//scaner.nextLine();
		int rows = Integer.parseInt(scaner.nextLine());
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ticket.setRows(rows);
		System.out.println("请输入列数：");
		int columns = Integer.parseInt(scaner.nextLine());
		ticket.setColums(columns);
		System.out.println("一共有"+ticket.getTotal()+"张票");
		SellTicketThread sellTicket = new SellTicketThread(ticket);
		ReturnTicketThread returnTicket = new ReturnTicketThread(ticket);
		sellTicket.setNum(4);
		returnTicket.setNum(2);
		sellTicket.start();
		returnTicket.start();
		
	}

}
