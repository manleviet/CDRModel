/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel.test.model;

import at.tugraz.ist.ase.cdrmodel.CDRModel;
import at.tugraz.ist.ase.cdrmodel.IChocoModel;
import at.tugraz.ist.ase.cdrmodel.test.ITestModel;
import lombok.Getter;
import org.apache.commons.collections4.IteratorUtils;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;

import java.util.*;

import static at.tugraz.ist.ase.cdrmodel.test.csp.CSPModels.createModel1;

public class TestModel1 extends CDRModel implements IChocoModel, ITestModel {

    @Getter
    private Model model;

    private List<Set<String>> allDiagnoses = null;
    private List<Set<String>> allConflicts = null;

    public TestModel1(String name) {
        super(name);
    }

    @Override
    public void initialize() {
        model = createModel1();

        // sets possibly faulty constraints to super class
        List<String> C = new ArrayList<>();
        for (Constraint c: model.getCstrs()) {
            C.add(c.toString());
        }
        Collections.reverse(C);
        this.setPossiblyFaultyConstraints(C);

        identifyExpectedResults();
    }

    public void identifyExpectedResults() {
        Set<String> C = this.getPossiblyFaultyConstraints();

        // Expected diagnoses
        Set<String> diag1 = new LinkedHashSet<>();
        diag1.add(IteratorUtils.get(C.iterator(), 2));
        diag1.add(IteratorUtils.get(C.iterator(), 3));

        Set<String> diag2 = new LinkedHashSet<>();
        diag2.add(IteratorUtils.get(C.iterator(), 0));
        diag2.add(IteratorUtils.get(C.iterator(), 3));

        Set<String> diag3 = new LinkedHashSet<>();
        diag3.add(IteratorUtils.get(C.iterator(), 1));
        diag3.add(IteratorUtils.get(C.iterator(), 2));

        Set<String> diag4 = new LinkedHashSet<>();
        diag4.add(IteratorUtils.get(C.iterator(), 0));
        diag4.add(IteratorUtils.get(C.iterator(), 1));

        allDiagnoses = new ArrayList<>();
        allDiagnoses.add(diag1);
        allDiagnoses.add(diag2);
        allDiagnoses.add(diag3);
        allDiagnoses.add(diag4);

        // Expected conflicts
        Set<String> cs1 = new LinkedHashSet<>();
        cs1.add(IteratorUtils.get(C.iterator(), 1));
        cs1.add(IteratorUtils.get(C.iterator(), 3));

        Set<String> cs2 = new LinkedHashSet<>();
        cs2.add(IteratorUtils.get(C.iterator(), 0));
        cs2.add(IteratorUtils.get(C.iterator(), 2));

        allConflicts = new ArrayList<>();
        allConflicts.add(cs1);
        allConflicts.add(cs2);
    }

    @Override
    public Set<String> getExpectedFirstDiagnosis() {
        if (allDiagnoses != null)
            return allDiagnoses.get(0);
        return null;
    }

    @Override
    public List<Set<String>> getExpectedAllDiagnoses() {
        return allDiagnoses;
    }

    @Override
    public Set<String> getExpectedFirstConflict() {
        if (allConflicts != null)
            return allConflicts.get(0);
        return null;
    }

    @Override
    public List<Set<String>> getExpectedAllConflicts() {
        return allConflicts;
    }
}
