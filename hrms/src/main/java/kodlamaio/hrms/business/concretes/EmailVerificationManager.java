package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmailVerificationManager implements EmailVerificationService {


	@Override
	public String sendVerification(String email) {
	
		return "Email verification send" +email;
	}
}
