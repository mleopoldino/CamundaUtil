package br.com.interfile.bpm.delegate;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ConsultaCpf implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unused")
		Long cpf = (Long) execution.getVariable("CPF");
		@SuppressWarnings("unused")
		Date nascimento = (Date) execution.getVariable("nascimento");
		
		String nome = null;
		String situacao = null;
		String codControle = null;
		
		execution.setVariable("nome", nome);
		execution.setVariable("situacao", situacao);
		execution.setVariable("codControle", codControle);
		
	}

}
