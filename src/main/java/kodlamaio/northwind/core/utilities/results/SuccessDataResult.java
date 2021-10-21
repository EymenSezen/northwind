package kodlamaio.northwind.core.utilities.results;


public class SuccessDataResult<T> extends DataResult<T> {

	
	public SuccessDataResult(T data, String message) {
		super(data, true, message); //başarılı dönüş 
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult(T data) {
		super(data,true); //sadece data döndürme
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult(String message) {
		super(null, true, message); //başarılı mesaj dönüş 
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult() {
		super(null, true); // 
		// TODO Auto-generated constructor stub
	}
	
	
}
