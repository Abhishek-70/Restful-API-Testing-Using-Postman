package com.web_App_2.Controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.web_App_2.ApplicationDto.ApplicationDto;
import com.web_App_2.ApplicationDto.ExtraMessageOrArgsDto;
import com.web_App_2.EntityClass.ApplicationData;
import com.web_App_2.ExceptionHandling.ResourceNotFoundException;
import com.web_App_2.Repository.ApplicationRepository;

//for making it as an API layer we have to add annotation @RestController
// http://localhost:8080/api/registration,,,it shows the content of the JSON object present in the database

@RestController
@RequestMapping("/api/application")
public class RestApplicationController {

	@Autowired
	private ApplicationRepository apprepo;

	// it Converts the Java Object into the JSON object using this Annotation
	// using the @GetMapping we can see the object content in the database into JSON
	// object

//	@GetMapping (used for the Mapping the data from the database
//	public List<ApplicationData> getAllApps() {
//		List<ApplicationData> finddata = apprepo.findAll();
//		return finddata;
//	}

	//**While Performing CRUD in the API Response Status Code is 200 for read,update,Delete
	//while for Create it's 201,
//	@GetMapping
//	public ResponseEntity<?> getAllApps() {
//
//		List<ApplicationData> finddata = apprepo.findAll();
//	//here If we gonna add Some More Message To the Console/Response We Have To Use the DTO Class	
//		ExtraMessageOrArgsDto e=new ExtraMessageOrArgsDto();
//		e.setMessage("All Data Have Been Readed");
//		e.setReadedAllDataSetter(finddata);
//		
//		return new ResponseEntity<>(e, HttpStatus.OK);
//
//	}

	// DeleteMapping used for the deleting a record from the database via testing
	// http://localhost:8080/api/registration/26

//	@DeleteMapping("/{s_NO_}")
//	public void deleteApplicationData(@PathVariable int s_NO_) {
//
//		apprepo.deleteById(s_NO_);
//
//	}
	
	//Now We gonna Put the Response message on the Server Side Of the Postman 
	//http://localhost:8080/api/application/5,,using this url we can delete a record with the id number which provided in url
	
//	@DeleteMapping("/{s_NO_}")
//	public ResponseEntity<?> deleteApplicationData(@PathVariable int s_NO_) {
//		apprepo.deleteById(s_NO_);
//
//		return new ResponseEntity<>("Record Is Deleted!",HttpStatus.OK);
//	}

	// save Application Data into database
//	@PostMapping
//	public void saveApplication(@RequestBody ApplicationData appdata) {
	// @RequestBody Annotation Convert the JSON object into java Object by sending all the key-Value pair to variable
		 //		apprepo.save(appdata);
//	}

	// for saving the data with proper Response using ResponseEntity Class

//	@PostMapping
//	public ResponseEntity<?> saveApplication(@RequestBody ApplicationData appdata) {
//		// we can return anything while using (?) in the RespoonseEntity
//		// apprepo.save(appdata);
//		// return new ResponseEntity<>("Record Is Saved",HttpStatus.CREATED);it shows
//		// only the message
//		// at the response Layer
//		ApplicationData savedData = apprepo.save(appdata);
//		return new ResponseEntity<>(savedData, HttpStatus.CREATED);
//	}

	// http://localhost:8080/api/application?s_NO_=28--> this is also known as the QUERY parameter.
	
	// @RequestBody Annotation Convert the JSON object into java Object by sending
	// all the data to variable make
	// sure that variables name are same in the java class
//	@PutMapping
//	public void updateApplicationDataById(@RequestParam int s_NO_, @RequestBody ApplicationDto appdto) {
//
//		ApplicationData appdata = apprepo.findById(s_NO_).get();
//		appdata.setEmail(appdto.getEmail());
//		appdata.setName(appdto.getName());
//		appdata.setPhone(appdto.getPhone());
//		appdata.setSchool(appdto.getSchool());
//
//		apprepo.save(appdata);
//	}
	
	//here we gonna put the response Status Will be Setteld
	@PutMapping
	public ResponseEntity<?> updateApplicationDataById(@RequestParam int s_NO_, @RequestBody ApplicationDto appdto) {

		ApplicationData appdata = apprepo.findById(s_NO_).get();
		appdata.setEmail(appdto.getEmail());
		appdata.setName(appdto.getName());
		appdata.setPhone(appdto.getPhone());
		appdata.setSchool(appdto.getSchool());

		ApplicationData updatedData = apprepo.save(appdata);
		return new  ResponseEntity<>(updatedData,HttpStatus.OK) ;
	}
	
	
	//Now We Gonna Limit The Response Console With A Specific Number & Type Of Outcome
	
	@PostMapping
	public ResponseEntity<?> saveApplication(
			@Valid 
			@RequestBody ApplicationData appdata,
			BindingResult result
						) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ApplicationData savedData = apprepo.save(appdata);
//		ApplicationDto2 appdto=new ApplicationDto2();
//		appdto.setName(savedData.getName());
//		appdto.setEmail(savedData.getEmail());
//		appdto.setPhone(savedData.getPhone());
	
		ExtraMessageOrArgsDto e=new ExtraMessageOrArgsDto();
		e.setMessage("Record Is saved Successfully!!");
		e.setReadedAllDataSetter(savedData);
		
		return new ResponseEntity<>(e, HttpStatus.CREATED);
	}

	//now here we gonna throw a Exception To the ResponseEntity Way throw Keyword
	
	@DeleteMapping("/{s_NO_}")
	public ResponseEntity<?> deleteRegistration(@PathVariable int s_NO_){
		Optional<ApplicationData> findByIddata = apprepo.findById(s_NO_);
		if(findByIddata.isPresent()) {
			
			apprepo.deleteById(s_NO_);
		
		}else {
		
			throw new ResourceNotFoundException("Id is Not present in the Database with s_NO:"+s_NO_);
		
			
		}
		
		return new ResponseEntity<>("Record IS Deleted",HttpStatus.OK);
	}
	
	
	
	
}
