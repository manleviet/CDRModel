/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel.test;

import java.util.List;
import java.util.Set;

public interface ITestModel {
    Set<String> getExpectedFirstDiagnosis();
    List<Set<String>> getExpectedAllDiagnoses();

    Set<String> getExpectedFirstConflict();
    List<Set<String>> getExpectedAllConflicts();
}
