
public class Senha {

	
	

	private char tipo;
	private int prioridade;
	
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char c) {
		this.tipo = c;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTipo() + " " + getPrioridade();
	}
}
