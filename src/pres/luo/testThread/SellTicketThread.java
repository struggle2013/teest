package pres.luo.testThread;

public class SellTicketThread extends Thread {
	private Ticket ticket;
	private int num;

	public SellTicketThread(Ticket ticket) {
		// TODO Auto-generated constructor stub
		this.ticket = ticket;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		int count=1;
		while (count<=4) {
			count++;
			System.out.println("售票前余额："+ticket.getFreeSeatNum()+";想购票数："+this.num);
			if (ticket.isReturning) {
				System.out.println("退票中，SellTicketThread wait...");
			}
			ticket.setSelling(true);
			ticket.sellTicket(this.num);
			
			ticket.setSelling(false);
			
		}

	}
}
