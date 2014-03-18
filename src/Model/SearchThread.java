package Model;

public class SearchThread implements Runnable{
	
	private Move aMove;
	private Thread t;
	
	public SearchThread(Move aMove){
		this.aMove=aMove;
		t= new Thread(this, "decision thread");
		
	}

	@Override
	public void run() {
		
		
		
	}
	
	public void start(){
		t.start();
	}

}
