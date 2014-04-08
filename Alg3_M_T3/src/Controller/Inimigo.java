package Controller;

import Model.MapaMod;
import Model.SoldadoMod;
import View.MapaView;
import View.Utilitarios.Prints;

/**
 * Classe validadora de comandos
 * @author Neimar, Aurelio
 */
public class Inimigo {
	
	private static int chances = 0;
	private static int acertos = 0;
	MapaView mv = new MapaView();
	
	/**
	 * @param acertos
	 */
	public static void setAcertos(int acertos) {
		Inimigo.acertos = acertos;
	}
	
	/**
	 * @param chances
	 */
	public static void setChances(int chances) {
		Inimigo.chances = chances;
	}
	
	/**
	 * @return
	 */
	public static int getAcertos() {		
		return acertos;
	}
	
	/**
	 * @return
	 */
	public static int getChances() {
		return chances + SoldadoMod.getPontuacaoInicial();
	}
	
	
	/**
	 * M�todo de processamento da jogada
	 * @param linha
	 * @param coluna
	 * @param dado
	 */
	private void encontraAlvo(int linha, int coluna,String dado) {
		for (int i = 0; i <  MapaMod.getLinha(); i++) {
			for (int j = 0; j < MapaMod.getLinha(); j++) {				
				
				if (i == linha && j == coluna && MapaMod.mapa[i][j].equals("-") ){
					acertos += 3;
				}	
				
				if (i == linha && j == coluna ){
					MapaMod.mapa[i][j] = dado;
					Prints.msgl();					
				}				
			}
		}
	}

	/**
	 * M�todo de valida��o dados
	 * @param linha
	 * @param coluna
	 * @param dado
	 * @throws Exception
	 */
	public void ValidaAlvo(int linha, int coluna,String dado) throws Exception {
		
		if ((linha >= MapaMod.getLinha() || coluna >= MapaMod.getColuna()) &&
			(linha < MapaMod.getLinha() || coluna < MapaMod.getColuna())){
				Prints.msgb("As cordenadas n�o sao v�lidas!");
		}else{
			chances--;	
			encontraAlvo(linha, coluna, dado);	
			//mv.imprime(false," "); //Imprime mapa so jogo com distribui��o do navio no mapa
		}	
	}
	
	

}
