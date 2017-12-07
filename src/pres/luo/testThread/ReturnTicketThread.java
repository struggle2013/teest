package pres.luo.testThread;

public class ReturnTicketThread extends Thread {
	private Ticket ticket;
	private int num;

	public ReturnTicketThread(Ticket ticket) {
		// TODO Auto-generated constructor stub
		this.ticket = ticket;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		int count=1;
		while (count<=5) {
			count++;
			
			if (ticket.isSelling) {
				System.out.println("正在售票，ReturnTicketThread wait...");
				//ticket.wait();
			}
			ticket.setReturning(true);
			ticket.returnTicket(num);
			ticket.setReturning(false);
			
			
		}
	}
}
