package pres.luo.testThread;

public class Ticket {
	private int rows;	//票的总行数
	private int colums;	//票的总列数
	private int total;	//票的总数
	public int getTotal() {
		this.total = this.rows*this.colums;
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	private int freeSeatNum;	//剩余票数
	 public int getFreeSeatNum() {
		return freeSeatNum;
	}
	
	boolean isSelling;	//true 表示正在售票。
	 boolean isReturning; //true 表示正在退票
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColums() {
		return colums;
	}
	public void setColums(int colums) {
		this.colums = colums;
		this.freeSeatNum=this.rows*colums;
		this.total=this.freeSeatNum;
	}
	public boolean isSelling() {
		return isSelling;
	}
	public void setSelling(boolean isSelling) {
		this.isSelling = isSelling;
	}
	public boolean isReturning() {
		return isReturning;
	}
	public void setReturning(boolean isReturning) {
		this.isReturning = isReturning;
	}
	//售票方法
	synchronized public void sellTicket(int num) {
		while (this.freeSeatNum-num<0) {
			try {
				System.out.println("票不足了，请等待");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.freeSeatNum -= num;
		System.out.println("购买了" + num + "张票");
		System.out.println("售票后余票是：" + this.freeSeatNum+"\n");
	}
	public Ticket() {
		super();
		this.isSelling = false;
		this.isReturning = false;
	}
	synchronized public void returnTicket(int num) {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.freeSeatNum += num;
		System.out.println("退了" + num + "张票");
		System.out.println("退票后余票是：" + this.freeSeatNum+"\n");
		this.notifyAll();
	}
}
