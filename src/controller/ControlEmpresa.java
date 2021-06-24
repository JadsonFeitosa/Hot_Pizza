package controller;

import DTO.EmpresaDTO;
import model.Empresa;

public class ControlEmpresa {
	
	public void salvarEmpresa (Empresa empresa) {
		
		
		Empresa emp = empresa;
		
		Empresa.salvarEmpresa(emp);
		
	}
	public void caqEmpresa (String CNPJ, String nome, String end, String bairro, String cep, String cidade, String tel) {
		
		
		Empresa emp = new Empresa(CNPJ,nome,end,bairro,cep,cidade,tel);
		
		Empresa.salvarEmpresa(emp);

	}
	public static Empresa retEmpresa() {
		return Empresa.pesEmpresa();
	}

}
