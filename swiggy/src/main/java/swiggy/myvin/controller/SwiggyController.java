package swiggy.myvin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swiggy.myvin.exception.FoodAlreadyExistsException;
import swiggy.myvin.exception.MaxQntException;
import swiggy.myvin.exception.PaymentException;
import swiggy.myvin.model.Cart;
import swiggy.myvin.model.Food;
import swiggy.myvin.model.FoodOrdered;
import swiggy.myvin.service.SwiggyService;
import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class SwiggyController extends HttpServlet {

	@Autowired
	private SwiggyService service;

	@GetMapping("/menu")
	public List<Food> showmenu() {

		List<Food> foodList = service.listAll();
		System.out.println(foodList);
		return foodList;
	}
	@GetMapping("/pay")
	public ResponseEntity<?> payment(final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<String> responseEntity;
			final String authHeader = request.getHeader("authorization");
			final String token = authHeader.substring(7);
			String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
			
		 try {
			service.payment(userId);
			return  responseEntity = new ResponseEntity<String>("paid", HttpStatus.OK);
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			 return  responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
		
	}


	@PostMapping("/Add/{qnt}")
	public ResponseEntity<?> add(@RequestBody Food food, @PathVariable("qnt") Integer qnt, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		
		System.out.println("Awesome");
		System.out.println(food.getName());
		System.out.println(qnt);
		 ResponseEntity<String> responseEntity;
        
        try {
        	 service.addCart(food,userId,qnt);
        	 responseEntity = new ResponseEntity<String>("Food Added ", HttpStatus.OK);
		} catch (FoodAlreadyExistsException e) {
			System.out.println("Exception caught");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}

        
		
		return responseEntity;

	}
	
	@PostMapping("/changeQnt/{operation}")
	public ResponseEntity<?> changeQnt(@RequestBody FoodOrdered foodOrdered,@PathVariable("operation") String operation, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		
	
		
		ResponseEntity<String> responseEntity;
		try {
			service.changeQnt(operation,userId,foodOrdered);
			responseEntity = new ResponseEntity<String>("sucess", HttpStatus.OK);
		} catch (MaxQntException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		
		}
		
		return responseEntity;

	}
	
	
	@GetMapping("/ListCart")
	public ResponseEntity<?> listCart(final HttpServletRequest request,final HttpServletResponse response) {
	
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		Cart cart=service.getCart(userId);
		ResponseEntity<?> responseEntity = new ResponseEntity<Cart>(cart, HttpStatus.OK);
		return responseEntity;
	}




	
}
