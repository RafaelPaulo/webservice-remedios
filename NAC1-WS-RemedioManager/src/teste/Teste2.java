package teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.axis2.AxisFault;

import br.com.fiap.entity.Pessoa;

public class Teste2 {
	
	public static void main(String[] args) throws AxisFault {
		
		
		String currentTime = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
		System.out.println(currentTime);
		
		Pessoa p = new Pessoa();
		
		if(p.getCpf() <= 0){
			System.out.println("vazio");
		}else{
			System.out.println("=:"+p.getCpf());
		}
		
	}
	
}
