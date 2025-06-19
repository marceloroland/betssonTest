package runners;

import base.BaseTest;

public class BaseTestRunner {
    public static void main(String[] args) throws Exception {
        BaseTest test = new BaseTest();
        test.setUp();

        System.out.println(">>> App aberto. Aguardando 10 segundos...");
        Thread.sleep(10000);

        test.tearDown();
        System.out.println(">>> App fechado.");
    }
}
