/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel.test.model;

import org.chocosolver.solver.Model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestModel1Test {
    static TestModel1 testModel;

    @BeforeAll
    static void setUp() throws Exception {
        testModel = new TestModel1("testModel1");
        testModel.initialize();
    }

    @Test
    void testModel() {
        Model model = testModel.getModel();

        assertAll(() -> assertEquals(2, model.getNbVars()),
                () -> assertEquals(4, model.getNbCstrs()),
                () -> assertEquals("ARITHM ([x >= 2])", model.getCstrs()[0].toString()),
                () -> assertEquals("ARITHM ([y >= x + 1])", model.getCstrs()[1].toString()),
                () -> assertEquals("ARITHM ([x <= 0])", model.getCstrs()[2].toString()),
                () -> assertEquals("ARITHM ([y = -10])", model.getCstrs()[3].toString()));
    }

    @Test
    void testConstraints() {
        assertAll(() -> assertTrue(testModel.getCorrectChocoConstraints().isEmpty()),
                () -> assertEquals(4, testModel.getPossiblyFaultyChocoConstraints().size()),
                () -> assertTrue(testModel.getPossiblyFaultyChocoConstraints().contains("ARITHM ([x >= 2])")),
                () -> assertTrue(testModel.getPossiblyFaultyChocoConstraints().contains("ARITHM ([y >= x + 1])")),
                () -> assertTrue(testModel.getPossiblyFaultyChocoConstraints().contains("ARITHM ([x <= 0])")),
                () -> assertTrue(testModel.getPossiblyFaultyChocoConstraints().contains("ARITHM ([y = -10])")),
                () -> assertFalse(testModel.getPossiblyFaultyChocoConstraints().contains("ARITHM ([y = 10])")));
    }

    @Test
    void testExpectedResults() {
        assertAll(() -> assertEquals(2, testModel.getExpectedFirstConflict().size()),
                () -> assertTrue(testModel.getExpectedFirstConflict().contains("ARITHM ([x >= 2])")),
                () -> assertTrue(testModel.getExpectedFirstConflict().contains("ARITHM ([x <= 0])")),
                () -> assertEquals(2, testModel.getExpectedAllConflicts().size()),
                () -> assertTrue(testModel.getExpectedAllConflicts().get(0).contains("ARITHM ([x >= 2])"), "Expected first conflict"),
                () -> assertTrue(testModel.getExpectedAllConflicts().get(0).contains("ARITHM ([x <= 0])"), "Expected first conflict"),
                () -> assertTrue(testModel.getExpectedAllConflicts().get(1).contains("ARITHM ([y >= x + 1])"), "Expected second conflict"),
                () -> assertTrue(testModel.getExpectedAllConflicts().get(1).contains("ARITHM ([y = -10])"), "Expected second conflict"),
                () -> assertEquals(2, testModel.getExpectedFirstDiagnosis().size()),
                () -> assertTrue(testModel.getExpectedFirstDiagnosis().contains("ARITHM ([x >= 2])"), "Expected first diagnosis"),
                () -> assertTrue(testModel.getExpectedFirstDiagnosis().contains("ARITHM ([y >= x + 1])"), "Expected first diagnosis"),
                () -> assertEquals(4, testModel.getExpectedAllDiagnoses().size()),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(0).contains("ARITHM ([x >= 2])"), "Expected first diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(0).contains("ARITHM ([y >= x + 1])"), "Expected first diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(1).contains("ARITHM ([y = -10])"), "Expected second diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(1).contains("ARITHM ([x >= 2])"), "Expected second diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(2).contains("ARITHM ([x <= 0])"), "Expected third diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(2).contains("ARITHM ([y >= x + 1])"), "Expected third diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(3).contains("ARITHM ([x <= 0])"), "Expected fourth diagnosis"),
                () -> assertTrue(testModel.getExpectedAllDiagnoses().get(3).contains("ARITHM ([y = -10])"), "Expected fourth diagnosis")
        );

    }
}