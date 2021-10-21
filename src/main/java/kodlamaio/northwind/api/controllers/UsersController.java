package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//responseentity kullanımı
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody  User user) {//ne döneceğine karar veremedim
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.userService.add(user));
	}
	/*
	@GetMapping("/findByEmail")
	public DataResult<User> findByEmail(String email)
	{
		return this.userService.findByEmail(email);
		
	}*/
	
	//tüm hatalar için hatayı bul ayıkla ve listeye atıp mesaj döndürüyoruz
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		//hangi alanda hata var?
		//hata ne?
		Map<String,String> validationErrors=new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			
				validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,false,"Doğrulama Hataları");//doğrulama hataları
		return errors;
		
	}

}
