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
package org.codehaus.groovy.antlr.java;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.util.Arrays;

public class Java2GroovyMain {

    public static void main(String[] args) {
        try {
            Options options = new Options();
            CommandLineParser cliParser = new DefaultParser();
            CommandLine cli = cliParser.parse(options, args);
            String[] filenames = cli.getArgs();
            if (filenames.length == 0) {
                System.err.println("Needs at least one filename");
            }
            Java2GroovyProcessor.processFiles(Arrays.asList(filenames));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
