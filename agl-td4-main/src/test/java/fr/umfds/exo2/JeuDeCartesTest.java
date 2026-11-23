package fr.umfds.exo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

import static fr.umfds.exo2.Couleur.pique;
import static fr.umfds.exo2.Couleur.trefle;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
class JeuDeCartesTest {

    @Mock
    Random mockrandom;

    @InjectMocks
    JeuDeCartes sut=new JeuDeCartes();


    @Test
    void testpiochedenierroidetrefle(){
        when(mockrandom.nextInt(52)).thenReturn(51);
        Carte carte = sut.pioche();
        assertEquals(13, carte.getHauteur());
        assertEquals(trefle, carte.getCouleur());
    }
    @Test
    void testpiochepremieraspique(){
        when(mockrandom.nextInt(52)).thenReturn(0);
        Carte carte = sut.pioche();
        assertEquals(1, carte.getHauteur());
        assertEquals(pique, carte.getCouleur());
    }

    @Test
    void distribution2paque3carte(){
        ArrayList<ArrayDeque<Carte>> listdeck;
        when(mockrandom.nextInt(52)).thenReturn(0);
        when(mockrandom.nextInt(51)).thenReturn(0);
        when(mockrandom.nextInt(50)).thenReturn(0);
        when(mockrandom.nextInt(49)).thenReturn(46);
        when(mockrandom.nextInt(48)).thenReturn(46);
        when(mockrandom.nextInt(47)).thenReturn(46);
        try{
            listdeck = sut.distribution(3,2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(pique,listdeck.get(0).getFirst().getCouleur());
        assertEquals(1,listdeck.get(0).getFirst().getHauteur());
        listdeck.get(0).removeFirst();
        assertEquals(pique,listdeck.get(0).getFirst().getCouleur());
        assertEquals(2,listdeck.get(0).getFirst().getHauteur());
        listdeck.get(0).removeFirst();
        assertEquals(pique,listdeck.get(0).getFirst().getCouleur());
        assertEquals(3,listdeck.get(0).getFirst().getHauteur());
        listdeck.get(0).removeFirst();



        assertEquals(trefle,listdeck.get(1).getFirst().getCouleur());
        assertEquals(11,listdeck.get(1).getFirst().getHauteur());
        listdeck.get(1).removeFirst();
        assertEquals(trefle,listdeck.get(1).getFirst().getCouleur());
        assertEquals(12,listdeck.get(1).getFirst().getHauteur());
        listdeck.get(1).removeFirst();
        assertEquals(trefle,listdeck.get(1).getFirst().getCouleur());
        assertEquals(13,listdeck.get(1).getFirst().getHauteur());
        listdeck.get(1).removeFirst();



    }
}