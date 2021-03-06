package br.com.alura.gerenciador.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Banco {

	private static List<Empresa> lista = new ArrayList();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	
	static {
		Banco.lista.add(new Empresa("Alura", new Date()));
		Banco.lista.add(new Empresa("Caelum", new Date()));
		
		Banco.listaUsuarios.add(new Usuario("lucas","12345"));
		Banco.listaUsuarios.add(new Usuario("gleice","12345"));
	}

	static public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}

	static public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public static void removeEmpresa(String id) {
		Banco.lista.removeIf(empresa -> empresa.getId().equals(id));
	}

	public static Empresa buscaEmpresa(String id) {
		Optional<Empresa> findedEmpresa = Banco.lista.stream().filter(empresa -> empresa.getId().equals(id))
				.findFirst();

		return findedEmpresa.orElseGet(null);

	}

	public static void atualizaEmpresa(String id, String nome, String data) throws ParseException {
		Empresa empresa = Banco.buscaEmpresa(id);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataAbertura = format.parse(data);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
	}
	
	public static Usuario existeUsuario(String login,String senha) {
		return Banco.listaUsuarios.stream().filter(usuario-> usuario.ehIgual(login, senha)).findFirst().orElseGet(null);
	}

}
