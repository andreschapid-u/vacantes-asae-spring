package co.edu.unicauca.asae.core.controladores;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.edu.unicauca.asae.core.modelo.Vacante;

import co.edu.unicauca.asae.core.services.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService servicioGestionarVacantes;
	
	@GetMapping("/ListarVacantes")
	private String mostrarTabla(Model model) {
		List<Vacante> lista= servicioGestionarVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}

	@GetMapping("/")
	public String mostrarHome(Model modelo)
	{
		List<Vacante> lista = servicioGestionarVacantes.buscarTodas();
		modelo.addAttribute("vacantes", lista);
	
		return "home";
	}
	
	@GetMapping("/ListarEmpleos")
	public String listarEmpleos(Model modelo)
	{
		ArrayList<String> listaEmpleos= new ArrayList<>();
		listaEmpleos.add("desarrollador");
		listaEmpleos.add("analista");
		listaEmpleos.add("tester");
		modelo.addAttribute("empleos", listaEmpleos);
		return "listaEmpleos";
	}
	
	@GetMapping("/detalleEmpleo")
	public String consultarEmpleo(Model modelo)
	{
		Vacante objVacante = new Vacante();
		objVacante.setId(1);
		objVacante.setNombre("Desarrollador en java");
		objVacante.setDescripcion("Se requiere con conocimiento en angular para el front end y Spring para el back end");
		objVacante.setFecha(new Date());
		objVacante.setSalario(5000000.0);
		modelo.addAttribute("vacante", objVacante);
		return "detalleEmpleo";
	}
	
}
