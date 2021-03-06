/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021-2022
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel;

import at.tugraz.ist.ase.eval.test.TestCase;

import java.util.Set;

public interface IDebuggingModel {
    /**
     * Gets the set of test cases.
     * @return the set of test cases.
     */
    Set<TestCase> getTestcases();

    /**
     * Gets a corresponding {@link TestCase} object of a textual testcase.
     * @param testcase a textual testcase.
     * @return a corresponding {@link TestCase} object.
     */
    TestCase getTestCase(String testcase);
}