package com.cibertec.cliente.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.cliente.entity.Edificio;
import com.cibertec.cliente.service.EdificioServicie;
import com.cibertec.cliente.service.TipoService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/edificio")
public class EdificioController {
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private EdificioServicie edificioServicie;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tipos",tipoService.listAll());
		model.addAttribute("edificio",new Edificio());
		return "edificio";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@ModelAttribute Edificio bean,RedirectAttributes redirec) {
		try {
			edificioServicie.registrar(bean);
			redirec.addFlashAttribute("MENSAJE","Registro guardado");
			
		} catch (Exception e) {
			redirec.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		return "redirect:/edificio/";
	}
	
	@RequestMapping("/consulta")
	@ResponseBody
	public List<Edificio> consulta(@RequestParam("codigo") int cod) {
		return edificioServicie.listarAllPorTipo(cod);
	}
	
	@RequestMapping("/reporte")
	public void medicamentos(HttpServletResponse response,@RequestParam("codigo") int cod) {
		try {
			List<Edificio> lista=edificioServicie.listarAllPorTipo(cod);
			File file=ResourceUtils.getFile("classpath:reporteEdificiosPorTipo.jrxml");
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource data=new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null, data); 
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
