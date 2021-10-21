package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result{

	//işlem başarısız

	public ErrorResult() {
		
		super(false);
	}
	public ErrorResult(String message)
	{
		super(false,message);
		
	}

}
