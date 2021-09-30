/*
 * CloudSim Plus: A modern, highly-extensible and easier-to-use Framework for
 * Modeling and Simulation of Cloud Computing Infrastructures and Services.
 * http://cloudsimplus.org
 *
 *     Copyright (C) 2015-2021 Universidade da Beira Interior (UBI, Portugal) and
 *     the Instituto Federal de Educação Ciência e Tecnologia do Tocantins (IFTO, Brazil).
 *
 *     This file is part of CloudSim Plus.
 *
 *     CloudSim Plus is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CloudSim Plus is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CloudSim Plus. If not, see <http://www.gnu.org/licenses/>.
 */
package org.cloudsimplus.traces.google;

/**
 * Defines the type of information missing in a {@link GoogleTaskEventsTraceReader} trace file.
 * It represents the possible values for the MISSING_INFO field.
 * @author Manoel Campos da Silva Filho
 * @since CloudSim Plus 4.0.0
 */
public enum MissingInfo {
    /**
     * 0: Means Google Clusters did not find a record representing the given event,
     * but a later snapshot of the job or task state indicated that the transition must have occurred.
     * The timestamp of the synthesized event is the timestamp of the snapshot.
     */
    SNAPSHOT_BUT_NO_TRANSITION,

    /**
     * 1: Means Google Clusters did not find a record representing the given termination event,
     * but the job or task disappeared from later snapshots of cluster states,
     * so it must have been terminated.
     * The timestamp of the synthesized event is a pessimistic upper bound on its
     * actual termination time assuming it could have legitimately been missing from one snapshot.
     */
    NO_SNAPSHOT_OR_TRANSITION,

    /**
     * 2: Means Google Clusters did not find a record representing the creation of the given task or job.
     * In this case, we may be missing metadata
     * (job name, resource requests, etc.) about the job or task.
     * Therefore, we may have placed SCHEDULE or SUBMIT events latter than they actually are.
     */
    EXISTS_BUT_NO_CREATION
}
