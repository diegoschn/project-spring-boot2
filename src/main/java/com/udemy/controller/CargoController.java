package com.udemy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.udemy.domain.Cargo;
import com.udemy.domain.Departamento;
import com.udemy.service.CargoService;
import com.udemy.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.listarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo,BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		this.cargoService.salvar(cargo);
		redirect.addFlashAttribute("success", "Cargo cadastro com sucesso.");
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> getDepartamentos(){
		return departamentoService.listarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "/cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "/cargo/lista";
		}
		this.cargoService.editar(cargo);
		redirect.addFlashAttribute("success","Cargo atualizado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes redirect) {
		if(cargoService.cargoTemFuncionarios(id)) {
			redirect.addFlashAttribute("fail","Cargo não excluído por existir funcionários vinculados");
		}
		cargoService.excluir(id);
		redirect.addFlashAttribute("success","Cargo excluído com sucesso!");
		return "redirect:/cargos/listar";
	}
}
