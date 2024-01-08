package com.web_App_2.ServiceApplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web_App_2.EntityClass.ApplicationData;
import com.web_App_2.Repository.ApplicationRepository;

@Service
public class ApplicationServ {

	@Autowired
	ApplicationRepository apprepo;
	
	public void saveApplicationData(ApplicationData appdata) {
		apprepo.save(appdata);
		
	}

	public List<ApplicationData> getAllRegistration() {
		// TODO Auto-generated method stub
		
		List<ApplicationData> regs = apprepo.findAll();
		return regs;
		
	}

	public void deleteById(int s_NO_) {
		// TODO Auto-generated method stub
		apprepo.deleteById(s_NO_);
		
	}

	public ApplicationData getAndUpdateById(int s_NO_) {
		// TODO Auto-generated method stub
	ApplicationData appdata1 = apprepo.findById(s_NO_).get();
		return appdata1;
	}
	
}
