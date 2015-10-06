/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.cluster.datastore.entityownership.selectionstrategy;

import com.google.common.base.Preconditions;
import java.util.Collection;

/**
 * The FirstCandidateSelectionStrategy always selects the first viable candidate from the list of candidates
 */
public class FirstCandidateSelectionStrategy implements EntityOwnerSelectionStrategy {

    public static final FirstCandidateSelectionStrategy INSTANCE = new FirstCandidateSelectionStrategy();

    @Override
    public long selectionDelayInMillis() {
        return 0;
    }

    @Override
    public String newOwner(Collection<String> viableCandidates) {
        Preconditions.checkArgument(viableCandidates.size() > 0, "No viable candidates provided");
        return viableCandidates.iterator().next();
    }
}
