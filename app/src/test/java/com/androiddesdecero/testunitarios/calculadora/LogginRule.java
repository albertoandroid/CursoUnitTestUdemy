package com.androiddesdecero.testunitarios.calculadora;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

public class LogginRule implements TestRule {

    public class LoggingStatement extends Statement {

        private final Statement statement;

        public LoggingStatement(Statement aStatement, String aName) {
            statement = aStatement;
        }

        @Override
        public void evaluate() throws Throwable {
            System.out.println("before: " + name);
            statement.evaluate();
            System.out.println("after: " + name);
        }

    }

    private final String name;

    public LogginRule(String aName) {
        name = aName;
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        System.out.println("apply: " + name);

        return new LoggingStatement(statement, name);
    }

}