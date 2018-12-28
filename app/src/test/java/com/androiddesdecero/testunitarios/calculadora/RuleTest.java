package com.androiddesdecero.testunitarios.calculadora;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

public class RuleTest {
    @ClassRule
    public static LogginRule classRule = new LogginRule("classrule");

    @Rule
    public LogginRule rule = new LogginRule("rule");

    @Test
    public void testSomething() {
        System.out.println("In TestSomething");
        Assert.assertTrue(true);
    }

    @Test
    public void testSomethingElse() {
        System.out.println("In TestSomethingElse");
        Assert.assertTrue(true);
    }
}
