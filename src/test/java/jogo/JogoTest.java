package jogo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class JogoTest {

    /*
	 * Se for o primeiro turno e a soma das faces dos dados cair 7 ou 11 voc� ganha o jogo;
	 * Se for o primeiro turno e a soma das faces dos dados cair 2, 3 e 12 voc� perde o jogo;
	 * Se n�o cair nenhum desses valores, o valor � armazenado e passa para o segundo turno;
	 * Se for o segundo turno e a soma das faces dos dados cair 7 novamente, voc� perde o jogo;
	 * Se for o segundo turno, voc� continuando jogando os dados e s� ganha se cair um numero igual ao anterior do primeiro turno;
	 */

    @Test
    public void testGanhaNoPrimeiroTurnoCom7() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(7);

		boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoPrimeiroTurnoCom11() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(11);

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testPerdeNoPrimeiroTurnoCom2() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(2);

		boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertFalse(ganhou);
    }

    @Test
    public void testPerdeNoPrimeiroTurnoCom3() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(3);

		boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertFalse(ganhou);
    }


    @Test
    public void testPerdeNoPrimeiroTurnoCom12() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(12);

		boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertFalse(ganhou);
    }
}
