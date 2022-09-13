package AA16;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AspectoLog {
	
	@Before("execution(* generarArchivo())")
	@After("execution(* exito())")
	
	public void log() {
		System.out.println("Informacion: ");
	}
}
