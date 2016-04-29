package teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.RemedioBO;
import br.com.fiap.entity.Remedio;

public class Teste2 {
	
	public static void main(String[] args) throws AxisFault {
		
		
		String currentTime = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
		System.out.println(currentTime);
		
		RemedioBO bo = new RemedioBO();
		List<Remedio> r = bo.readRemedioPorPessoa(45047990818l);
		
		if(r == null){
			System.out.println("vazio");
		}else{
			System.out.println("Foi");
		}
		
		for (Remedio remedio : r) {
			System.out.println(remedio.getNome());
		}
	}
	
}
