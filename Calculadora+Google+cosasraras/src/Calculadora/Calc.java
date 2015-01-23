/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author Easysoft Company
 */
public class Calc {

    private double Dnuma;
    private double Dnumb;

    public Calc(String Dnuma, String Dnumb) {
        this.Dnuma = Double.parseDouble(Dnuma);
        this.Dnumb = Double.parseDouble(Dnumb);
    }

    public String suma() {
        String R = null;

        Double Result = Dnuma + Dnumb;
        R = Result.toString();

        return R;
    }

    public String resta() {
        String R = null;

        Double Result = Dnuma - Dnumb;
        R = Result.toString();

        return R;
    }

    public String multiplica() {
        String R = null;

        Double Result = Dnuma * Dnumb;
        R = Result.toString();

        return R;
    }

    public String divide() {
        String R = null;

        if (Dnumb == 0) {
            R = "una division entre 0";
        } else {

            Double Result = Dnuma / Dnumb;
            R = Result.toString();
        }

        return R;
    }

}
