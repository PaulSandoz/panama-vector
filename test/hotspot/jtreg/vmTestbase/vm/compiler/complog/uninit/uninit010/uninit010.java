/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 *
 * @summary converted from VM Testbase vm/compiler/complog/uninit/uninit010.
 * VM Testbase keywords: [quick, jit]
 *
 * @library /vmTestbase
 *          /test/lib
 * @build vm.compiler.complog.share.LogCompilationTest
 *        vm.compiler.complog.uninit.uninit010.uninit010
 *        vm.compiler.complog.uninit.UninitializedTrapCounter
 * @run main/othervm PropertyResolvingWrapper
 *      vm.compiler.complog.share.LogCompilationTest
 *      -testedJava ${test.jdk}/bin/java
 *      -options "${test.vm.opts} ${test.java.opts}"
 *      -testClass vm.compiler.complog.uninit.uninit010.uninit010
 *      -parserClass vm.compiler.complog.uninit.UninitializedTrapCounter
 *      -parserOptions "-classFilter=.*uninit.*"
 */

package vm.compiler.complog.uninit.uninit010;
import vm.compiler.complog.share.Constants;

/**
 * Provoke OSR in initializer of class with 'new' calls of
 * distinct class which calls 'new' of uninitialized class.
 */

public class uninit010 {

    static {
        for(int i = 0; i<Constants.LOOP_ITERATIONS; i++) {
            Object o = new uninit010a();
        }
    }

    public uninit010() {

    }

    public static void main(String args[]) {
    }

}

class uninit010a {

    public uninit010a() {
        Object o = new uninit010();
    }

}
