/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package groovy.bugs

import gls.CompilableTestSupport
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.ParserVersion

class Groovy5318Bug extends CompilableTestSupport {
    void testTypeArgumentsOnlyOnTheLastComponent() {
        def message = shouldNotCompile """
            def a = new java.util<Integer>.ArrayList<ArrayList<Integer>>()
        """

        if (ParserVersion.V_2 == CompilerConfiguration.DEFAULT.parserVersion) {
            assert message.contains('Unexpected type arguments found prior to: ArrayList')
        } else {
            assert message.contains('Unexpected input: \'new java.util<Integer>.\'')
        }
    }
}
