package diretorioDiff.resultados;

import diretorioDiff.Arquivo;


public class ResultadoArquivo {

	private Arquivo base;
	private Arquivo para;
	
	private TipoResultado tipo;
	private int similaridade = 0;
	private boolean escolhaHungaro = false;

	/**
	 * Cria uma classe para representar o resultado da compara��o entre arquivos
	 * @param arquivo1
	 * @param arquivo2
	 * @param tipo
	 */
	public ResultadoArquivo(Arquivo arquivo1, Arquivo arquivo2,
			TipoResultado tipo) {
		this.base = arquivo1;
		this.para = arquivo2;
		this.tipo = tipo;
		
	}

	public ResultadoArquivo(Arquivo arquivo, TipoResultado tipo) {
		
		switch (tipo) {
			case REMOVED:
				base = arquivo;			
				break;
	
			case ADDED:
				para = arquivo;
				break;
				
			default:
				break;
		}
		
		this.tipo = tipo;
	}

	public ResultadoArquivo(Arquivo base, Arquivo comparado, int similaridade) {
		this.base = base;
		this.para = comparado;
		this.similaridade = similaridade;		
		
		
		if (similaridade == Resultado.PERCENTUAL_IDENTICO) {
			if (base.getPathRelativo().equalsIgnoreCase(comparado.getPathRelativo())) {
				this.tipo = TipoResultado.UNCHANGED;				
			} else {
				this.tipo = TipoResultado.MOVED;
			}
		} else {
			this.tipo = TipoResultado.CHANGED;
		}	
	}

	/**
	 * Setter para o campo similaridade
	 * @param similaridade
	 */
	public void setSimilaridade(int similaridade) {
		this.similaridade  = similaridade;
	}

	/**
	 * Setter para o campo escolhaHungaro
	 * @param escolhaHungaro
	 */
	public void setEscolhaHungaro(boolean escolhaHungaro) {
		this.escolhaHungaro = escolhaHungaro;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("TIPO: " + tipo + " ");
		sb.append("SIMILARIDADE: " + getSimilaridade() + " ");
		sb.append("HUNGARO: " + isEscolhaHungaro() + " ");
		sb.append("\n");

		switch (tipo) {
			case ADDED:
				
				sb.append("ADD: " + para.getPathRelativo() + " ");
				sb.append("\n");
				
				break;
				
			case REMOVED:
				
				sb.append("DEL: " + base.getPathRelativo() + " ");
				sb.append("\n");
				
				break;
	
			default:
				sb.append("DE: " + base.getPathRelativo() + " ");
				sb.append("\n");
				sb.append("PARA: " + para.getPathRelativo() + " ");
				sb.append("\n");
				break;
		}
		
		return sb.toString();
	}

	/**
	 * @return the similaridade
	 */
	public int getSimilaridade() {
		return similaridade;
	}

	/**
	 * @return the escolhaHungaro
	 */
	public boolean isEscolhaHungaro() {
		return escolhaHungaro;
	}

	/**
	 * @return the base
	 */
	public Arquivo getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(Arquivo base) {
		this.base = base;
	}

	/**
	 * @return the para
	 */
	public Arquivo getPara() {
		return para;
	}

	/**
	 * @return the tipo
	 */
	public TipoResultado getTipo() {
		return tipo;
	}

	public boolean haveTo() {
		return getPara() != null;
	}
	
	public boolean haveFrom() {
		return getBase() != null;
	}

	public boolean isDirectory() {
		if (haveFrom()) {
			return getBase().isDirectory();
		}
		
		if (haveTo()) {
			return getPara().isDirectory();
		}
		
		return false;
	}

	public boolean isIdFrom(int id) {
		if (haveFrom() && getBase().getId() == id) {
			return true;
		}
		
		return false;
	}
	
	public boolean isIdTo(int id) {
		if (haveTo() && getPara().getId() == id) {
			return true;
		}
		
		return false;
	}
}