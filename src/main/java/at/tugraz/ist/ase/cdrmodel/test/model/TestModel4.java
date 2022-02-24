/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021-2022
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel.test.model;

import at.tugraz.ist.ase.cdrmodel.CDRModel;
import at.tugraz.ist.ase.cdrmodel.IChocoModel;
import at.tugraz.ist.ase.cdrmodel.test.ITestModel;
import at.tugraz.ist.ase.cdrmodel.test.csp.CSPModels;
import at.tugraz.ist.ase.common.LoggerUtils;
import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.chocosolver.solver.Model;

import java.util.*;

@Slf4j
public class TestModel4 extends CDRModel implements IChocoModel, ITestModel {
    @Getter
    private Model model;

    private List<Set<Constraint>> allDiagnoses = null;
    private List<Set<Constraint>> allConflicts = null;

    public TestModel4() {
        super("Test 4");
    }

    @Override
    public void initialize() throws Exception {
        log.trace("{}Initializing CDRModel for {} >>>", LoggerUtils.tab, getName());
        LoggerUtils.indent();

        model = CSPModels.createModel4();

        // sets possibly faulty constraints to super class
        List<Constraint> C = new ArrayList<>();
        for (org.chocosolver.solver.constraints.Constraint c: model.getCstrs()) {
            Constraint constraint = new Constraint(c.toString());
            constraint.addChocoConstraint(c);

            C.add(constraint);
        }
        Collections.reverse(C);
        this.setPossiblyFaultyConstraints(C);
        log.trace("{}Added constraints to the possibly faulty constraints [C={}]", LoggerUtils.tab, C);

        identifyExpectedResults();

        model.unpost(model.getCstrs());

        LoggerUtils.outdent();
        log.debug("{}<<< Initialized CDRModel for {}", LoggerUtils.tab, getName());
    }

    private void identifyExpectedResults() {
        Set<Constraint> C = this.getPossiblyFaultyConstraints();

        // Expected results
        Set<Constraint> diag1 = new LinkedHashSet<>();
        diag1.add(IteratorUtils.get(C.iterator(), 6));

        Set<Constraint> diag2 = new LinkedHashSet<>();
        diag2.add(IteratorUtils.get(C.iterator(), 5));

        allDiagnoses = new ArrayList<>();
        allDiagnoses.add(diag1);
        allDiagnoses.add(diag2);

        // Expected results
        Set<Constraint> cs1 = new LinkedHashSet<>();
        cs1.add(IteratorUtils.get(C.iterator(), 5));
        cs1.add(IteratorUtils.get(C.iterator(), 6));

        allConflicts = new ArrayList<>();
        allConflicts.add(cs1);

        log.trace("{}Generated expected results", LoggerUtils.tab);
    }

    @Override
    public Set<Constraint> getExpectedFirstDiagnosis() {
        if (allDiagnoses != null)
            return allDiagnoses.get(0);
        return null;
    }

    @Override
    public List<Set<Constraint>> getExpectedAllDiagnoses() {
        return allDiagnoses;
    }

    @Override
    public Set<Constraint> getExpectedFirstConflict() {
        if (allConflicts != null)
            return allConflicts.get(0);
        return null;
    }

    @Override
    public List<Set<Constraint>> getExpectedAllConflicts() {
        return allConflicts;
    }
}
