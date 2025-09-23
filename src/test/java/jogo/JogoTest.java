package jogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class JogoTest {

    /*
     * Se for o primeiro turno e a soma das faces dos dados cair 7 ou 11 voc� ganha
     * o jogo;
     * Se for o primeiro turno e a soma das faces dos dados cair 2, 3 e 12 voc�
     * perde o jogo;
     * Se n�o cair nenhum desses valores, o valor � armazenado e passa para o
     * segundo turno;
     * Se for o segundo turno e a soma das faces dos dados cair 7 novamente, voc�
     * perde o jogo;
     * Se for o segundo turno, voc� continuando jogando os dados e s� ganha se cair
     * um numero igual ao anterior do primeiro turno;
     */

    // ################## TESTA SE ENCERRA NO PRIMEIRO TURNO CORRETAMENTE ##################
    @Test
    public void testEncerraNoPrimeiroTurnoCom7() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(7);

        jogo.jogo(mockedJogador, dado1, dado2);

        verify(mockedJogador).lancar(dado1, dado2);
    }

    @Test
    public void testEncerraNoPrimeiroTurnoCom11() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(11);

        jogo.jogo(mockedJogador, dado1, dado2);

        verify(mockedJogador).lancar(dado1, dado2);
    }

    @Test
    public void testEncerraNoPrimeiroTurnoCom2() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(2);

        jogo.jogo(mockedJogador, dado1, dado2);

        verify(mockedJogador).lancar(dado1, dado2);
    }

    @Test
    public void testEncerraNoPrimeiroTurnoCom3() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(3);

        jogo.jogo(mockedJogador, dado1, dado2);

        verify(mockedJogador).lancar(dado1, dado2);
    }

    @Test
    public void testEncerraNoPrimeiroTurnoCom12() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2)).thenReturn(12);

        jogo.jogo(mockedJogador, dado1, dado2);

        verify(mockedJogador).lancar(dado1, dado2);
    }

    // ################## TESTA SE GANHA NO PRIMEIRO TURNO CORRETAMENTE ##################
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

    // ################## TESTA SE PERDE NO PRIMEIRO TURNO CORRETAMENTE ##################
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

    // ################## TESTA SE GANHA NO SEGUNDO TURNO CORRETAMENTE ##################
    @Test
    public void testGanhaNoSegundoTurnoComQuatroDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(4) // primeiro turno
                .thenReturn(4); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoSegundoTurnoComCincoDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(5) // primeiro turno
                .thenReturn(5); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoSegundoTurnoComSeisDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(6) // primeiro turno
                .thenReturn(6); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoSegundoTurnoComOitoDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(8) // primeiro turno
                .thenReturn(8); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoSegundoTurnoComNoveDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(9) // primeiro turno
                .thenReturn(9); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testGanhaNoSegundoTurnoComDezDuasVezesSeguidas() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(10) // primeiro turno
                .thenReturn(10); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertTrue(ganhou);
    }

    @Test
    public void testSePerdeNoSegundoTurnoCom7() {
        Jogo jogo = new Jogo();
        Jogador mockedJogador = mock(Jogador.class);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        // Primeiro turno: retorna 5 (não ganha nem perde, vai para o segundo turno)
        // Segundo turno: retorna 7 (deve perder)
        when(mockedJogador.lancar(dado1, dado2))
                .thenReturn(5) // primeiro turno
                .thenReturn(7); // segundo turno

        boolean ganhou = jogo.jogo(mockedJogador, dado1, dado2);
        assertFalse(ganhou);
    }
}
