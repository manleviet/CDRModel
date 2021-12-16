/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel.test.csp;

import at.tugraz.ist.ase.common.IOUtils;
import at.tugraz.ist.ase.common.LoggerUtils;
import at.tugraz.ist.ase.csp2choco.CSP2ChocoTranslator;
import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.io.IOException;
import java.io.InputStream;

import static at.tugraz.ist.ase.csp2choco.CSP2ChocoTranslator.loadConstraints;

@UtilityClass
@Slf4j
public class CSPModels {
    public Model createModel1() throws IOException {
        log.debug("{}Creating model from csp1.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 1");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar x = model.intVar("x", -10, 10);
        IntVar y = model.intVar("y", -10, 10);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp1.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp1.mzn created", LoggerUtils.tab);

        return model;
    }

    public Model createModel2() throws IOException {
        log.debug("{}Creating model from csp2.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 2");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar v1 = model.intVar("v1", 1, 3);
        IntVar v2 = model.intVar("v2", 1, 3);
        IntVar v3 = model.intVar("v3", 1, 3);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp2.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp2.mzn created", LoggerUtils.tab);

        return model;
    }

    public Model createModel3() throws IOException {
        log.debug("{}Creating model from csp3.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 3");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar v1 = model.intVar("v1", 1, 3);
        IntVar v2 = model.intVar("v2", 1, 3);
        IntVar v3 = model.intVar("v3", 1, 3);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp3.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp3.mzn created", LoggerUtils.tab);

        return model;
    }

    public Model createModel4() throws IOException {
        log.debug("{}Creating model from csp4.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 4");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar v1 = model.intVar("v1", 1, 3);
        IntVar v2 = model.intVar("v2", 1, 3);
        IntVar v3 = model.intVar("v3", 1, 3);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp4.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp4.mzn created", LoggerUtils.tab);

        return model;
    }

    public Model createModel5() throws IOException {
        log.debug("{}Creating model from csp5.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 5");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar v1 = model.intVar("v1", 1, 3);
        IntVar v2 = model.intVar("v2", 1, 3);
        IntVar v3 = model.intVar("v3", 1, 3);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp5.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp5.mzn created", LoggerUtils.tab);

        return model;
    }

    public Model createModel6() throws IOException {
        log.debug("{}Creating model from csp6.mzn >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        // create a model
        Model model = new Model("Test 6");

        // Decision variables
        log.trace("{}Creating model's variables", LoggerUtils.tab);
        IntVar v1 = model.intVar("v1", 1, 3);
        IntVar v2 = model.intVar("v2", 1, 3);
        IntVar v3 = model.intVar("v3", 1, 3);

        ClassLoader classLoader = CSPModels.class.getClassLoader();
        @Cleanup InputStream inputStream = IOUtils.getInputStream(classLoader, "csp6.mzn");

        loadConstraints(inputStream, model);

        LoggerUtils.outdent();
        log.debug("{}<<< The model from csp6.mzn created", LoggerUtils.tab);

        return model;
    }
}
