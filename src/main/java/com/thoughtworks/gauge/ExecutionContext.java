// Copyright 2015 ThoughtWorks, Inc.

// This file is part of Gauge-Java.

// This program is free software.
//
// It is dual-licensed under:
// 1) the GNU General Public License as published by the Free Software Foundation,
// either version 3 of the License, or (at your option) any later version;
// or
// 2) the Eclipse Public License v1.0.
//
// You can redistribute it and/or modify it under the terms of either license.
// We would then provide copied of each license in a separate .txt file with the name of the license as the title of the file.

package com.thoughtworks.gauge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExecutionContext {
    private Specification currentSpecification;
    private Scenario currentScenario;
    private StepDetails currentStep;

    public ExecutionContext(Specification specification, Scenario scenario, StepDetails stepDetails) {
        this.currentSpecification = specification;
        this.currentScenario = scenario;
        this.currentStep = stepDetails;
    }

    public ExecutionContext() {
        this.currentSpecification = new Specification();
        this.currentScenario = new Scenario();
        this.currentStep = new StepDetails();
    }

    public Specification getCurrentSpecification() {
        return currentSpecification;
    }

    public Scenario getCurrentScenario() {
        return currentScenario;
    }

    public StepDetails getCurrentStep() {
        return currentStep;
    }

    public List<String> getAllTags() {
        HashSet<String> specTags = new HashSet<String>(currentSpecification.getTags());
        specTags.addAll(currentScenario.getTags());
        return new ArrayList<String>(specTags);
    }
}