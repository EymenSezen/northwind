package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data, boolean success, String message) {
		super(data, false, message); //başarılı dönüş 
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResult(T data) {
		super(data,false); //sadece data döndürme
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResult(String message) {
		super(null, false, message); //başarılı mesaj dönüş 
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResult() {
		super(null, false); // 
		// TODO Auto-generated constructor stub
	}
	
}
