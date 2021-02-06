package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer idIncrement = 1;
	
	static {
		  Empresa empresa = new Empresa();
		  empresa.setNome("Alura");
		  empresa.setId(Banco.idIncrement++);
		  Empresa empresa2 = new Empresa();
		  empresa2.setNome("Caelum");
		  empresa2.setId(Banco.idIncrement++);
		  Banco.lista.add(empresa);
		  Banco.lista.add(empresa2);
		}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.idIncrement++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = (Empresa) it.next();
			
			if(empresa.getId() == id) {
				
				it.remove();
			}
		}
		
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		
		for(Empresa empresa: lista) {
			
			if(empresa.getId() == id) {
				return empresa;
				
			}
		}
		return null;
	}
}
