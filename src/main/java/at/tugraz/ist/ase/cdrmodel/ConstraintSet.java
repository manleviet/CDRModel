/*
 * CDRModel - a Maven package for Conflict Detection and Resolution Models
 *
 * Copyright (c) 2021
 *
 * @author: Viet-Man Le (vietman.le@ist.tugraz.at)
 */

package at.tugraz.ist.ase.cdrmodel;

import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import lombok.Getter;
import lombok.NonNull;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents a set of constraints.
 *
 * Can be used as a conflict set, or a diagnosis.
 */
public class ConstraintSet {
    @Getter
    private final Set<Constraint> constraints;

    public ConstraintSet() {
        this.constraints = new LinkedHashSet<>();
    }

    public void setConstraint(@NonNull Constraint constraint) {
        this.constraints.add(constraint);
    }
}
