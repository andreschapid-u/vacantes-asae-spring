package co.edu.unicauca.asae.core.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.unicauca.asae.core.modelo.Vacante;
import co.edu.unicauca.asae.core.services.ICategoriasService;
import co.edu.unicauca.asae.core.services.IVacantesService;
import co.edu.unicauca.asae.core.services.IVacantesService;
import co.edu.unicauca.asae.core.util.Utileria;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService servicioGestionarVacantes;
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@Value("${empleoapp.ruta.imagenes}")
	String ruta;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante objVacante= servicioGestionarVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", objVacante);
		return ("detalle");
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante,Model model) {
		System.out.println("Borrando vacante con Id: " + idVacante);
		model.addAttribute("id", idVacante);
		return ("mensaje");
	}
	
	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {
		System.out.println("vacante: "+vacante);
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		return ("vacantes/formVacante");
	}
	
	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, Model model, @RequestParam("archivoImagen") MultipartFile multiPart, RedirectAttributes attributes) {	
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			}
			return("vacantes/formVacante");
		}
		
		if(!multiPart.isEmpty()) {
			//String ruta="d:/empleos/img-vacantes/";
			String nombreImagen=Utileria.guardarArchivo(multiPart, ruta);
			System.out.println("Archivo: "+nombreImagen);
			if(nombreImagen!=null) {
				vacante.setImagen(nombreImagen);
				
			}
		}
		
		serviceVacantes.guardar(vacante);
		//model.addAttribute("msg", "Registro guardado");
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println("Vacante: "+vacante);
		return ("redirect:/vacantes/index");
	}
	
	@GetMapping("/index")
	private String mostrarIndex(Model model) {
		List<Vacante> lista=serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return("vacantes/listVacantes");
	}
	

}
