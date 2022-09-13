package Spring;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AspectoLog {
	
	@Before("execution(* generarTxt())")
	@After("execution(* Saludar())")
	public void log() {
		System.out.println("Estas por ejecutar un TXT");
	}
}
