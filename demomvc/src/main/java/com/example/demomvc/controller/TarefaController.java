package com.example.demomvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demomvc.entity.Tarefa;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
	
	List<Tarefa> tarefas = new ArrayList<>();
	
	@GetMapping("/cadastro")
	public String cadastro(Tarefa tarefa) {
		return "/tarefa/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar (Tarefa tarefa) {
		
		Long id = tarefas.size() +1L;
		Tarefa t = new Tarefa ();
		
		t.setId(id);
		t.setNome(tarefa.getNome());
		t.setDataEntrega(tarefa.getDataEntrega());
		t.setResponsavel(tarefa.getResponsavel());
		
		tarefas.add(t);
		
		return "redirect:/tarefas/lista";
	}
	

}
