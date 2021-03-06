/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.graalvm.compiler.nodes;

import java.util.List;

import org.graalvm.compiler.graph.NodeClass;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A {@link StructuredGraph} encoded in a compact binary representation as a byte[] array. See
 * {@link GraphEncoder} for a description of the encoding format. Use {@link GraphDecoder} for
 * decoding.
 */
public class EncodedGraph {

    private final byte[] encoding;
    private final int startOffset;
    private final Object[] objects;
    private final NodeClass<?>[] types;
    private final Assumptions assumptions;
    private final List<ResolvedJavaMethod> inlinedMethods;

    /**
     * The "table of contents" of the encoded graph, i.e., the mapping from orderId numbers to the
     * offset in the encoded byte[] array. Used as a cache during decoding.
     */
    protected int[] nodeStartOffsets;

    public EncodedGraph(byte[] encoding, int startOffset, Object[] objects, NodeClass<?>[] types, Assumptions assumptions, List<ResolvedJavaMethod> inlinedMethods) {
        this.encoding = encoding;
        this.startOffset = startOffset;
        this.objects = objects;
        this.types = types;
        this.assumptions = assumptions;
        this.inlinedMethods = inlinedMethods;
    }

    public byte[] getEncoding() {
        return encoding;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public Object[] getObjects() {
        return objects;
    }

    public NodeClass<?>[] getNodeClasses() {
        return types;
    }

    public Assumptions getAssumptions() {
        return assumptions;
    }

    public List<ResolvedJavaMethod> getInlinedMethods() {
        return inlinedMethods;
    }
}
