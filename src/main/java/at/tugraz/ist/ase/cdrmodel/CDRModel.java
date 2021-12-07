/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Contains the knowledge base for constraint problems.
 *
 * @author Viet-Man Le (vietman.le@ist.tugraz.at)
 */
public abstract class CDRModel {

    @Getter
    private final String name;

    /**
     * The set of constraints which we assume to be always correct (background knowledge)
     */
    @Getter
    private Set<String> correctConstraints = new LinkedHashSet<>();

    /**
     * The set of constraints which could be faulty = KB (knowledge base).
     */
    @Getter
    private Set<String> possiblyFaultyConstraints = new LinkedHashSet<>();

    /**
     * Creates an empty diagnosis model.
     */
    public CDRModel(String name) {
        this.name = name;
    }

    /**
     * Sets the correct constraints (or background knowledge).
     * @param correctConstraints a collection of correct constraints
     */
    public void setCorrectConstraints(Collection<String> correctConstraints) {
        this.correctConstraints = new LinkedHashSet<>(correctConstraints);
    }

    /**
     * Setter for the possibly faulty constraints (or knowledge base).
     * @param possiblyFaultyConstraints a collection of faulty constraints
     */
    public void setPossiblyFaultyConstraints(Collection<String> possiblyFaultyConstraints) {
        this.possiblyFaultyConstraints = new LinkedHashSet<>(possiblyFaultyConstraints);
    }

    /**
     * Getter for all constraints.
     * @return a set of all constraints
     */
    public Set<String> getAllConstraints() {
//        incrementCounter(COUNTER_UNION_OPERATOR);
        return Sets.union(correctConstraints, possiblyFaultyConstraints);
    }

    /**
     * Call this method to load the constraints for the model.
     * Override this method to add all variables and constraints.
     */
    public abstract void initialize() throws Exception;

    @Override
    public String toString() {
        String sb = "CDRModel{" + '\n' + " Name=" + this.name +
                '\n' + ',' + correctConstraints.size() + " correctConstraints=" + correctConstraints +
                '\n' + ',' + possiblyFaultyConstraints.size() + " possiblyFaultyConstraints=" + possiblyFaultyConstraints +
                '}';
        return sb;
    }
}
