package fr.umfds.exo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestClassUnderTest {

    ClassUnderTest sut;
    @InjectMocks
    ClassUnderTest sut2;
    @Mock
    UsedClass uc;


    @Test
    void m1whenUsedClassThrowsException() throws TreatmentException {
        // GIVEN
        when(uc.treatment1()).thenThrow(new TreatmentException());
        sut = new ClassUnderTest(uc); // création du SUT et injection du mock (injection par constructeur)
        // WHEN
        long result = sut.m1();
        // THEN
        assertEquals(0, result);
    }

    @Test
    void m1whenUsedClassReturnsALong(@Mock UsedClass uc2) throws TreatmentException {// utilisation d'un mock différent de uc
        // GIVEN
        long treatment1result = 100000l;
        long expectedresult = 100002l;
        when(uc2.treatment1()).thenReturn(treatment1result);
        sut = new ClassUnderTest(uc2); // création du SUT et injection du mock uc2 (injection par constructeur)
        // WHEN
        long result = sut.m1();
        // THEN
        assertEquals(expectedresult, result);
    }

    @Test
    void m2WhenTreatment2ReturnsTrue() {
        // GIVEN
        when(uc.treatment2()).thenReturn(true);
        // ici le mock uc n'est pas injecté manuellement, mais se produit via l'annotation @injectMocks placée sur sut2
        // on n'appelle pas non plus le constructeur pour initialiser sut2
        // WHEN
        int result= sut2.m2();
        // THEN
        assertEquals(1, result);
    }

    @Test
    void m2WhenTreatment2ReturnsFalse() {
        // GIVEN
        when(uc.treatment2()).thenReturn(false);
        // ici le mock n'est pas injecté manuellement, mais se produit via l'annotation @injectMocks placée sur sut2
        // on n'appelle pas non plus le constructeur pour initialiser sut2
        // WHEN
        int result= sut2.m2();
        // THEN
        assertEquals(0, result);
    }
}