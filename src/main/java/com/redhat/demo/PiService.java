package com.redhat.demo;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class PiService {

    public double calculatePi(double n) {
        double pi = 0;
        for (int i = 1; i < n; i++) {
            pi += Math.pow(-1,i+1) / (2*i - 1);
        }
        return 4 * pi;
    }

    public static void main(String ... args) {
        var t1 = new Date();
        System.out.println(new PiService().calculatePi(Math.pow(10, 9)));
        var t2 = new Date();
        System.out.println(t2.getTime()-t1.getTime());

    }

}
