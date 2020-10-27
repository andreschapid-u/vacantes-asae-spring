package co.edu.unicauca.asae.core.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.core.modelo.Vacante;



@Service
public class VacantesServiceImpl implements IVacantesService {

	
	private List<Vacante> lista = null;	
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			//Oferta de trabajo01
			Vacante vacante01=new Vacante();
			vacante01.setId(1);
			vacante01.setNombre("Ingeniero civil");
			vacante01.setDescripcion("Solicitamos ing. civil para diseñar puente peatonal");
			vacante01.setFecha(sdf.parse("08-02-2019"));
			vacante01.setSalario(8500.0);
			vacante01.setDestacado(1);
			vacante01.setImagen("empresa1.png");
			
			//Oferta de trabajo02
			Vacante vacante02=new Vacante();
			vacante02.setId(2);
			vacante02.setNombre("Contador Público");
			vacante02.setDescripcion("Empresa importante necesita contador con 5 años de experiencia titulado");
			vacante02.setFecha(sdf.parse("09-02-2019"));
			vacante02.setSalario(12000.0);
			vacante02.setDestacado(0);
			vacante02.setImagen("empresa2.png");
			
			//Oferta de trabajo03
			Vacante vacante03=new Vacante();
			vacante03.setId(3);
			vacante03.setNombre("Ingeniero Eléctrico");
			vacante03.setDescripcion("Empresa internacional solicita Ing. mecánico para mantenimiento de la instalación eléctrica");
			vacante03.setFecha(sdf.parse("10-02-2019"));
			vacante03.setSalario(10500.0);
			vacante03.setDestacado(0);
			
			//Oferta de trabajo04
			Vacante vacante04=new Vacante();
			vacante04.setId(4);
			vacante04.setNombre("Diseñador Gráfico");
			vacante04.setDescripcion("Solicitamos diseñador gráfico titulado para diseñar publicidad de la empresa");
			vacante04.setFecha(sdf.parse("11-02-2019"));
			vacante04.setSalario(7500.0);
			vacante04.setDestacado(1);
			vacante04.setImagen("empresa3.png");
			
			//Agregar los 4 elementos a la lista
			lista.add(vacante01);
			lista.add(vacante02);
			lista.add(vacante03);
			lista.add(vacante04);
			
			
			
		}catch(ParseException e) {
			System.out.println("Error gV: "+e.getMessage());
		}
		
	}

	@Override
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante v: lista) {
			if(v.getId()==idVacante)
				return v;
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

}
